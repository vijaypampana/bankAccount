package main.java.com.vijay.web.javaDao;

import org.hibernate.validator.constraints.NotEmpty;


public class Eligibility {
	
	@NotEmpty(message = "Please enter your Account Type.")
	String accounttype;

	@NotEmpty(message = "Please select Initial Deposit.")
	String intialDeposit;
	
	@NotEmpty(message = "Please select Direct Deposit value.")
	String directDepositMonthly;
	
	@NotEmpty(message = "Please select Debit card Type")
	String debitCardVisaMaster;
	
	@NotEmpty(message = "Please enter Loan Requirement Amount.")
	String loanRequirement;
	
	@NotEmpty(message = "Please select Credit score")
	String creditScore;
	
	String interestrate;
	String cScore, dDepositMonthly;

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getIntialDeposit() {
		return intialDeposit;
	}

	public void setIntialDeposit(String intialDeposit) {
		this.intialDeposit = intialDeposit;
	}

	public String isDirectDepositMonthly() {
		return directDepositMonthly;
	}

	public void setDirectDepositMonthly(String directDepositMonthly) {
		this.directDepositMonthly = directDepositMonthly;
	}

	public String getDebitCardVisaMaster() {
		return debitCardVisaMaster;
	}

	public void setDebitCardVisaMaster(String debitCardVisaMaster) {
		this.debitCardVisaMaster = debitCardVisaMaster;
	}

	public String getLoanRequirement() {
		return loanRequirement;
	}

	public void setLoanRequirement(String loanRequirement) {
		this.loanRequirement = loanRequirement;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public String getDirectDepositMonthly() {
		return directDepositMonthly;
	}
	
	public String calculateInterest() {
    	
    	Double iRate = 0.0;
    	cScore = getCreditScore();
    	dDepositMonthly = getDirectDepositMonthly();
    	switch (cScore) {
    		case "EXCELLENT":
    			iRate = 4.0;
    			break;
    		case "GOOD":
    			iRate = 8.0;
    			break;
    		case "FAIR":
    			iRate = 12.0;
    			break;
    		case "BAD":
    			iRate = 16.0;
    			break;
    	}
    	
    	if(dDepositMonthly.equalsIgnoreCase("YES")) {
    		iRate = iRate * 0.9;
    	}
    	
    	return iRate.toString();
    }

	public String getInterestrate() {
		return calculateInterest();
	}
	
	
	
}
