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

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		System.out.println(id);
		
		return null;
	}

	public static void main(String a[]) {
		/*Devotee newdevotee = new Devotee(23, "ram", 34, "ramsdf@kumarr.com", "9800899874", "Jounrney of self discovery",
				"delhi");
		System.out.println("ra");
		// Mailer.send("evolvetoexcelteam@gmail.com", "Harekrishna108",
		// "radheybhardwaj@gmail.com",
		// "New Devotee registered for JSD sessions", "new registration");
		PaymentService ps = new PaymentService();
		// return newDevotee;
		// Response res=ps.initiatePayment();
		CustomUrl cm = new CustomUrl(ps.initiatePayment(newdevotee));

		System.out.println("rea");*/
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public CustomUrl addDevotee(Devotee newDevotee) {
		String msg = "Name " + newDevotee.getName() + " age: " + newDevotee.getAge() + " email: "
				+ newDevotee.getEmail() + " contact " + newDevotee.getPhone() + " city " + newDevotee.getCity();

		System.out.println(newDevotee.getName());
		System.out.println(newDevotee.getSessionId());
		System.out.println(newDevotee.getCity());
		try {

			Mailer.send("evolvetoexcelteam@gmail.com", "Harekrishna108", "radheybhardwaj@gmail.com",
					"New Devotee " + newDevotee.getName() + " registered for " + newDevotee.getSessionId(), msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(newDevotee.getAge());
		PaymentService ps = new PaymentService();
		// return newDevotee;
		// Response res=ps.initiatePayment();
		return new CustomUrl(ps.initiatePayment(newDevotee));
	}

	/*
	 * @PUT
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Country updateCountry(Country
	 * country) { return countryService.updateCountry(country);
	 * 
	 * }
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
