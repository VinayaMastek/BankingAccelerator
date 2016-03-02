package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="templateLink")
public class TemplateLink {
	
	@Id
	private String id;
	private String eventType;
	private Language language;
	private Preference pref;
	private String templateName;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Preference getPref() {
		return pref;
	}
	public void setPref(Preference pref) {
		this.pref = pref;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	
}
