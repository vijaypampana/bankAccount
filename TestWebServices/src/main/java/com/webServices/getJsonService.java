package main.java.com.webServices;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/GetQuote")
public class getJsonService {
	
	@GET
	@Path("/quote")
	@Produces(MediaType.TEXT_PLAIN)
	public String getQuote() {
		
		Random ran = new Random();
		return String.valueOf(2*ran.nextInt(10000000));
		

	}

}
