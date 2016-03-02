
package util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import dao.CustPrefRepository;
import dao.NotifLogRepository;
import dto.CustPref;
import dto.Language;
import dto.NotificationLog;
import dto.Preference;
import dto.TemplateLink;

@Component("generateNotification")
public class GenerateNotification {
	@Autowired
	public CustPrefRepository custPrefRepo;

	@Autowired
	public MongoTemplate template;
	
	@Autowired
	public NotifLogRepository notifLogRepo;
	
	private Map<String, Object> dataAttributes = new HashMap<String, Object>();
	private Map<String, Object> custAttributes = new HashMap<String, Object>();
	private List<CustPref> custPrefList = null;
	
	public void generateNotification() throws IOException {
		
		Resource resource = new ClassPathResource("velocity.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		VelocityEngine ve = new VelocityEngine(props);
		ve.init();
		VelocityContext context = new VelocityContext();
		for (Map.Entry<String, Object> entry : dataAttributes.entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}
		
		for (Map.Entry<String, Object> entry : custAttributes.entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}
		List<Map<String,String>> contacts = (List<Map<String, String>>) context.get("contacts");
		String eventType = dataAttributes.get("EventType")+"";
		//EventTypexx eventType = EventTypexx.getEventType(""+dataAttributes.get("EventType"));
		this.custPrefList=custPrefRepo.findByCustomerId(context.get("customerId")+"");
		List<Preference> prefs = null;
		Language lang;
		CustPref custPref =null;
		if (custPrefList.isEmpty())  // when no customer preference is set use the default config
		{
			prefs=new ArrayList<Preference>();
			prefs.add(Preference.EMAIL);
			lang =  Language.ENGLISH;
			custPref = new CustPref();
			custPref.setCustomerId(context.get("customerId")+"");
			custPref.setLanguage(lang);
			custPref.setNotify(true);
			custPref.setPrefs(prefs);
			
			for (Map<String,String> contact : contacts) {
				if ((contact.get("contactType")).equalsIgnoreCase("Mobile")){
					custPref.setSms(contact.get("contact"));
				} else	if ((contact.get("contactType")).equalsIgnoreCase("Email")){
					custPref.setEmail(contact.get("contact"));
				}
			}
		}
		else{
			custPref = custPrefList.get(0);
			prefs = custPref.getPrefs();
			lang = custPref.getLanguage();
		}
		
		for(Preference pref: prefs) { //customer could have multiple pref set
			TemplateLink templateLink = getTemplateLink(eventType, lang, pref);
			String templatenm;
			if (templateLink == null)
			{
				templatenm =eventType+"_"+pref+"_en.vm";
			}	else{
				templatenm = templateLink.getTemplateName();
			}
			
			
			Template t = ve.getTemplate("templates/"+templatenm, "UTF-8");
			StringWriter stringWriter = new StringWriter();
			t.merge(context, stringWriter);
			String notificaiton = stringWriter.toString();
			NotificationLog notifLog = new NotificationLog();
			notifLog.setCustomerId(context.get("customerId")+"");
			notifLog.setDate(new Date()+"");
			notifLog.setPref(pref);
			notifLog.setNotification(notificaiton);
			if(pref.equals(Preference.EMAIL)){
				notifLog.setCommunicationId(custPref.getEmail());
			} else {
				notifLog.setCommunicationId(custPref.getSms());
			}

			//to be uncommented when the dispatcher service is ready
			//invokeDispatcher(notifLog);
			System.out.println(notifLog.getNotification());
			notifLogRepo.save(notifLog);
			sendEmail(notifLog);
		}
	}
	
	
	private void sendEmail(NotificationLog log)
	{
		
		final String username = "ravindrakad@gmail.com";
		final String password = "Online01";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(log.getCommunicationId()));
			message.setSubject("Information from Bank");
			message.setText(log.getNotification());
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	//Service to invoke dispatcher
/*	private void invokeDispatcher(NotificationLog log){
		String link = "http://127.0.0.1:8282/dispatchMessage/";
		JSONObject jsonlog = new JSONObject(log);
		String data = jsonlog.toString();
		String enData = null;
		try {
			enData = URLEncoder.encode(data, "UTF-8");
			Client client = ClientBuilder.newClient(new ClientConfig());
			client.target(link+enData).request(MediaType.APPLICATION_JSON).get(); //post(Entity.json(data));	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
*/
	public TemplateLink getTemplateLink(String eventType, Language lang, Preference pref){
		Query query = new Query();
		query.addCriteria(Criteria.where("eventType").is(eventType));
		query.addCriteria(Criteria.where("language").is(lang));
		query.addCriteria(Criteria.where("pref").is(pref));
		
		if (template.find(query, TemplateLink.class).isEmpty())
			return null;
		else
			return template.find(query, TemplateLink.class).get(0);
		
	}

	public Map<String, Object> getCustAttributes() {
		return custAttributes;
	}

	public void setCustAttributes(Map<String, Object> custAttributes) {
		this.custAttributes = custAttributes;
	}

	public Map<String, Object> getDataAttributes() {
		return dataAttributes;
	}

	public void setDataAttributes(Map<String, Object> dataAttributes) {
		this.dataAttributes = dataAttributes;
	}

}
