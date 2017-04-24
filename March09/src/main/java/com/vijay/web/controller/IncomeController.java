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
import main.java.com.vijay.web.javaDao.Income;
import main.java.com.vijay.web.javaDao.IncomeDAO;

@Controller
@RequestMapping(value="/income")
public class IncomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String incomeform(Model model, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		model.addAttribute("income", new Income());
		return "pages/income";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String incomeview(@Valid @ModelAttribute("income") Income c,BindingResult result, Map<String, Object> model) {
		
		//System.out.println(result.getErrorCount());
		
		if(result.hasErrors()){
			return "pages/income";
		}
		
		ApplicationContext context;
	    context =  new ClassPathXmlApplicationContext("beans.xml");
		//@Autowired
	    IncomeDAO iDAO = (IncomeDAO) context.getBean("incomedao");
	    if(iDAO.insert(c)) {
	    	
	    	((AbstractApplicationContext)context).close();
		    Eligibility e = new Eligibility();
			model.put("eligibility", e);
			return "pages/eligibility";
			
	    } else {
	    	
	    	((AbstractApplicationContext)context).close();
	    	model.put("errval", "Encountered a Exception when inserting data into Income table");
	    	return "pages/income";
	    }
	    
		
        
    }


}

