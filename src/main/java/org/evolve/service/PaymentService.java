package org.evolve.service;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.evolve.model.Country;
import org.evolve.model.Devotee;
import org.evolve.service.CountryService;
import org.evolve.service.Mailer;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/makepayment")
public class PaymentService {

/*	public static void main(String a[]) {
		initiatePayment();
	}*/
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public  String initiatePayment(Devotee newDevotee) {

		/***** Create a new payment order *******/
		PaymentOrder order = new PaymentOrder();
		order.setId("234502");
		order.setName(newDevotee.getName());
		order.setEmail(newDevotee.getEmail());
		order.setPhone(newDevotee.getPhone());
		order.setCurrency("INR");
		order.setAmount(9D);
		order.setDescription("This is a test transaction.");
		order.setRedirectUrl("http://www.google.com");
		order.setWebhookUrl("http://www.google.com/");
		order.setTransactionId("dxg234560"+newDevotee.getName());
		String clientid = "test_cEqSPWwz3OJjYvxuSEKj4AtK1vBwtELxc6A";
		String clientsecret = "test_G4ftSco2jDbVo2Yy160qf9NzynhFAaG808CCiRedGAD5eQ6kFLuPiZ7UYJcClp0XiZbdZc5kx3U4Vfnn92s8gRfCIlwduySN2M3MfoIxCWLLxfd8YJZyjupeDo4";
		String apiEndpoint = "https://test.instamojo.com/v2/";
		String authEndPoint = "https://test.instamojo.com/oauth2/token/";

		Instamojo api = null;

		try {
			// gets the reference to the instamojo api
			// api = InstamojoImpl.getApi("[CLIENT_ID]", "[CLIENT_SECRET]",
			// "[API_ENDPOINT]", "[AUTH_ENDPOINT]");

			api = InstamojoImpl.getApi(clientid, clientsecret, apiEndpoint, authEndPoint);
		} catch (ConnectionException e) {
			// LOGGER.log(Level.SEVERE, e.toString(), e);
		}

		boolean isOrderValid = order.validate();

		if (isOrderValid) {
			try {
				System.out.println("new");
				CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
				System.out.println("redirect to new"+createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
				
				
				System.out.println(createPaymentOrderResponse.getPaymentOrder().getStatus());
				return createPaymentOrderResponse.getPaymentOptions().getPaymentUrl();
				//return Response.seeOther(URI.create("https://test.instamojo.com/@arpitneema25/l4532eb22f4a345a9a5ae882d11bd7ad2/"))
				//		.build();
				// response.sendRedirect();
				// print the status of the payment order.
			} catch (InvalidPaymentOrderException e) {
				// LOGGER.log(Level.SEVERE, e.toString(), e);

				if (order.isTransactionIdInvalid()) {
					System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
				}
				if (order.isCurrencyInvalid()) {
					System.out.println("Currency is invalid.");
				}
			} catch (ConnectionException e) {
				// LOGGER.log(Level.SEVERE, e.toString(), e);
			}
		} else {
			// inform validation errors to the user.
			if (order.isTransactionIdInvalid()) {
				System.out.println("Transaction id is invalid.");
			}
			if (order.isAmountInvalid()) {
				System.out.println("Amount can not be less than 9.00.");
			}
			if (order.isCurrencyInvalid()) {
				System.out.println("Please provide the currency.");
			}
			if (order.isDescriptionInvalid()) {
				System.out.println("Description can not be greater than 255 characters.");
			}
			if (order.isEmailInvalid()) {
				System.out.println("Please provide valid Email Address.");
			}
			if (order.isNameInvalid()) {
				System.out.println("Name can not be greater than 100 characters.");
			}
			if (order.isPhoneInvalid()) {
				System.out.println("Phone is invalid.");
			}
			if (order.isRedirectUrlInvalid()) {
				System.out.println("Please provide valid Redirect url.");
			}

			if (order.isWebhookInvalid()) {
				System.out.println("Provide a valid webhook url");
			}
		}
		return "https://test.instamojo.com/@arpitneema25/l4532eb22f4a345a9a5ae882d11bd7ad2/";
	}
}
