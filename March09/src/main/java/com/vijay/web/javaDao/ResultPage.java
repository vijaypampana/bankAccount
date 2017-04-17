package main.java.com.vijay.web.javaDao;

import org.springframework.web.client.RestTemplate;

public class ResultPage {
	
	String applicationNumber;
	
	String interestRate;

	public String getApplicationNumber() {
		getApplNum();
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	
	public void getApplNum() {
			
		RestTemplate temp = new RestTemplate();
		applicationNumber = temp.getForObject("http://localhost:8080/TestWebServices/rest/GetQuote/quote", String.class);
		
	}
	
	}
