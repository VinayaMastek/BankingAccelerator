package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONObject;

public class CustomerDetails {

	String customerId;
	String ageGroup; // CHILD(1-11), TEEN (12-19), YOUTH(20 - 30), YOUNGADULT(31
						// - 39), EARLYMIDDLEAGED(40-50), LATEMIDDLEAGED(51-60),
						// SENIOR(61-70), ELDER(71+)
	String incomeGroup; // LOWINCOME, MIDDLEINCOME, HIGHINCOME
	String qualificationGroup; // ILLITERATE, PRIMARY, SCHOOL, GRADUATE,
								// POSTGRAD,
	String employmentGroup; // SERVICE, VOCATIONAL, PROFESSIONAL,SELFEMPLOYED,
							// BUSINESS
	String location;
	String persona = "Generic";

	Map<String, String[]> personaMap = new HashMap<String, String[]>();
	Map<String, Collection<JSONObject>> spendMap = new HashMap<String, Collection<JSONObject>>();
	private TreeMap<String, String> qMap = new TreeMap<String, String>();

	public CustomerDetails() {
		super();
		
		qMap.put("EMPTY", "Unknown");
		qMap.put("B.Sc", "Graduate");
		qMap.put("B.Com", "Graduate");
		qMap.put("BE", "Graduate");
		qMap.put("MCA", "PostGraduate");
		qMap.put("MBA", "PostGraduate");
		qMap.put("H.S.C", "Jr College");
		qMap.put("S.S.C", "High School");

		personaMap.put("Urban-Intellect", new String[] { "Gifts", "Flowers",
				"Fine-Dining", "Apparels", "Hobby" });
		personaMap.put("Premium-Prudent", new String[] { "Fine-Dining",
				"Luxury", "Apparels", "Travel", "Spa" });
		personaMap.put("Affluent", new String[] { "Home-Appliance",
				"Fine-Dining", "Luxury", "Travel", "Gadgets",
				"Car-Accessories", "5-Star", "Beach Resort", "Spa" });
		personaMap.put("Family-Value-Minded", new String[] { "Travel",
				"Home-Appliance", "Apparels", "Car-Accessories", "Books",
				"Groceries" });
		personaMap.put("Early-Adopter", new String[] { "Travel", "Apparels",
				"Car-Accessories", "Books", "Gadgets" });
	}

	public CustomerDetails(String ageGroup, String incomeGroup,
			String qualificationGroup, String employmentGroup,
			Map<String, Collection<JSONObject>> spends) {
		super();
		this.ageGroup = ageGroup;
		this.incomeGroup = incomeGroup;
		this.qualificationGroup = qualificationGroup;
		this.employmentGroup = employmentGroup;
		this.spendMap = spends;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			LocalDate date = formatter.parse(dob).toInstant()
					.atZone(ZoneId.systemDefault()).toLocalDate();
			int age = Period.between(date, LocalDate.now()).getYears();

			this.ageGroup = (age ==0) ? "UNKNOWN"  
					: (age >0 & age <= 12) ? "CHILD"
					: (age > 12 & age <= 19) ? "TEEN"
							: (age > 19 & age <= 30) ? "YOUTH"
									: (age > 31 & age <= 39) ? "YOUNGADULT"
											: (age > 39 & age <= 50) ? "EARLYMIDDLEAGED"
													: (age > 50 & age <= 60) ? "LATEMIDDLEAGED"
															: (age > 60 & age <= 70) ? "SENIOR"
																	: "ELDER";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getIncomeGroup() {
		return incomeGroup;
	}

	public void setIncomeGroup(double income) {
		
		this.incomeGroup = (income == 0) ? "UNKNOWN" 
				: (income <= 100000) ? "LOW"
				: (income > 100000 & income <= 500000) ? "LOW-MIDDLE"
						: (income > 500000 & income <= 2500000) ? "HIGH-MIDDLE"
								: (income > 2500000 & income <= 10000000) ? "MASSAFFLUENT"
										: "AFFULENT";
	}

	public String getQualificationGroup() {
		return qualificationGroup;
	}

	public void setQualificationGroup(String qualification) {
		this.qualificationGroup = qMap.get(qualification);
	}

	public String getEmploymentGroup() {
		return employmentGroup;
	}

	public void setEmploymentGroup(String employment) {
		this.employmentGroup =employment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}

	public Map<String, Collection<JSONObject>> getSpendMap() {
		return spendMap;
	}

	public void setSpendMap(Map<String, Collection<JSONObject>> spendMap) {
		this.spendMap = spendMap;
	}
	
	public void setSpendMap(String key, Collection<JSONObject> value) {
		this.spendMap.put(key, value);
	}
	
	@Override
	public String toString() {
		return String
				.format("CustomerDetails [customerId=%s, ageGroup=%s, incomeGroup=%s, qualificationGroup=%s, employmentGroup=%s, location=%s, spendMap = %s]",
						customerId, ageGroup, incomeGroup, qualificationGroup,
						employmentGroup, location,
						Arrays.toString(this.spendMap.get("spends").toArray()));
	}

	
	
	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String derivePersona() {
		Set<String> spendCategories = new HashSet<String>();

		if (!this.spendMap.isEmpty()) {
			for (JSONObject obj : this.spendMap.get("spends")) {
				spendCategories.addAll((Collection<? extends String>) obj
						.get("categories"));
			}
			
			System.out.println("Spend Categories = "
					+ Arrays.toString(spendCategories.toArray()));

			for (Map.Entry<String, String[]> entry : personaMap.entrySet()) {
				boolean has = false;
				
				System.out.println("Persona Categories for " + entry.getKey()
						+ " = " + Arrays.toString(entry.getValue()));
				for (String value : entry.getValue()) {
					System.out.println("value to check : " + value);
					has = spendCategories.contains(value);
					if (!has)
						break;
				}
				if (has) {
					this.persona = entry.getKey();
					break;
				}
			}
		}
		System.out.println("Persona = " + persona);
		return this.persona;
	}
}
