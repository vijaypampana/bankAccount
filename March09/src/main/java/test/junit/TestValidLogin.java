package main.java.test.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.vijay.web.javaDao.LoginDAO;

public class TestValidLogin {

	@Test
	public void test() {
		
		String userName = "vijay";
		String password = "pampana";
		
		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext("beans.xml");
		LoginDAO lDAO = (LoginDAO) context.getBean("logindao");
		assertTrue(lDAO.selectDAO(userName, password));
		
	}

}
