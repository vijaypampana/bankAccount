package test.junit;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.vijay.web.javaDao.LoginDAO;

public class TestInvalidLogin {

	@Test
	public void test() {
		
		String userName = "test";
		String password = "pampana";
		
		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext("beans.xml");
		LoginDAO lDAO = (LoginDAO) context.getBean("logindao");
		assertFalse(lDAO.selectDAO(userName, password));
		
	}

}
