package main;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import twitter.GetTweets;

@Path("/pers")
public class Main {

	GetTweets getT = new GetTweets();
	
	@GET
	@Path("/users/date")
    @Produces(MediaType.TEXT_HTML)
    public String getDate(){
    String returnString = "<p>Database Status <p/>" + "<p>Database Date/Time return: "+ "Some other stuff should be here" + "<p/>";
    return returnString;
	   }
	
	@Path("/{user}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getTweet(@PathParam("user") String user){
		
		String returnString = "<p>The User you ask for is: <p/>" + "<p>"+ user + "<p/>" + "<p>" + getT.getAllTweets(user) + "</p>";
		
		return returnString;
	}
	
}
