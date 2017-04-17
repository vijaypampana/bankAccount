package main.java.com.vijay.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import main.java.com.vijay.web.javaDao.Eligibility;
import main.java.com.vijay.web.javaDao.EligibilityDAO;
import main.java.com.vijay.web.javaDao.ResultPage;

@Controller
@RequestMapping(value="/eligibility")
public class EligibilityController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String eligibilityform(Model model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		model.addAttribute("eligibility", new Eligibility());
		return "eligibility";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String eligibilityview(@Valid @ModelAttribute("eligibility") Eligibility e,BindingResult result, Map<String, Object> model) {
			
		if(result.hasErrors()){
			return "eligibility";
		}
		
		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext("beans.xml");
		//@Autowired
	    EligibilityDAO eDAO = (EligibilityDAO) context.getBean("eligibilitydao");
	    if(eDAO.insert(e)) {
	    	
	    	((AbstractApplicationContext)context).close();
		    ResultPage r = new ResultPage();
			model.put("resultPage", r);
			model.put("applNum", r.getApplicationNumber());
			model.put("applInterest", e.getInterestrate());
			return "resultPage";
			
	    } else {
	    	
	    	((AbstractApplicationContext)context).close();
	    	model.put("errval", "Encountered a Exception when inserting data into Eligibility table");
	    	return "eligibility";
	    	
	    }
	    
    }


}

