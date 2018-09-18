package org.evolve.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.evolve.model.Country;
import org.evolve.model.CustomUrl;
import org.evolve.model.Devotee;
import org.evolve.service.CountryService;
import org.evolve.service.Mailer;
import org.evolve.service.PaymentService;
@Path("/devotees")
public class UserController {

	// CountryService countryService=new CountryService();

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Devotee> getCountries() {
	 * 
	 * List<Devotee> listOfCountries=countryService.getAllCountries(); return
	 * listOfCountries; }
	 */

	/*
	 * @GET
	 * 
	 * @Path("/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Country
	 * getCountryById(@PathParam("id") int id) { return
	 * countryService.getCountry(id); }
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public CustomUrl addDevotee(Devotee newDevotee) {
		String msg="Names dfsdf"+newDevotee.getName()+" age: "+newDevotee.getAge()+" email: "+newDevotee.getEmail()+" contact"+newDevotee.getPhone();
		    
		System.out.println(newDevotee.getName());
		// Mailer.send("radhekrishnaingokul@gmail.com","ramram0788","radheybhardwaj@gmail.com","New Devotee registered for JSD sessions",msg);  
		    
		System.out.println(newDevotee.getAge());
		PaymentService ps=new PaymentService();
//		return newDevotee;
	//	Response res=ps.initiatePayment();
		return new CustomUrl(ps.initiatePayment(newDevotee));
	}

	/*@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countryService.updateCountry(country);

	}
*/
	/*
	 * @DELETE
	 * 
	 * @Path("/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public void
	 * deleteCountry(@PathParam("id") int id) { countryService.deleteCountry(id);
	 * 
	 * }
	 */
}
