package edu.neu.cs5200.hw5;

import javax.ws.rs.*;

@Path("/hello")
public class Hello {
	@GET
	@Path("/world")
	public String sayHello(){
		return "Hello World";
	}
	
}
