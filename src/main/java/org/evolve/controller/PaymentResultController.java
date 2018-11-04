package org.evolve.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.evolve.model.Country;
import org.evolve.service.CountryService;


@Path("/paymentstatus")
public class PaymentResultController {
	
	CountryService countryService=new CountryService();

	
	   @GET
	    @Produces(MediaType.TEXT_HTML)
		public InputStream getResult(	@QueryParam("payment_id") String payment_id,@QueryParam("payment_request_id") String requestId) throws FileNotFoundException
		{	
		
	    	File f = new File("../webapps/krishna/Successful.html");
	    
	    			 return new FileInputStream(f);
		}

	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id)
	{
		return countryService.getCountry(id);
	}
   
 /*   @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country)
	{
		return countryService.addCountry(country);
	}*/

    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public void addCountry(@FormParam("id") String param1,@FormParam("countryname") String param2)
	{
    	
    	System.out.println(param1);
    	System.out.println(param2);
//		return countryService.addCountry(country);
	}
    
    
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country)
	{
		return countryService.updateCountry(country);
		
	}
	
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id)
	{
		 countryService.deleteCountry(id);
		
	}
	
}
