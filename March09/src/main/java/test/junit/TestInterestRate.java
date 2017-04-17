package main.java.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.com.vijay.web.javaDao.Eligibility;

public class TestInterestRate {

	@Test
	public void test() {
		
		Eligibility e = new Eligibility();
		e.setDirectDepositMonthly("YES");
		e.setCreditScore("GOOD");
		
		assertEquals("7.2",e.calculateInterest());
				
		
	}

}
