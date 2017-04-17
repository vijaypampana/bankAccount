package main.java.test.junit;

import org.junit.Test;

import main.java.com.vijay.web.javaDao.ResultPage;

public class TestApplNum {

	@Test
	public void test() {
		
		ResultPage rPage = new ResultPage();
		System.out.println("The application number generated is: " + rPage.getApplicationNumber());
		
	}

}
