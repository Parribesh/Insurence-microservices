package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stripe.param.PaymentIntentCreateParams;

import com.example.model.ChargeRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Controller
@CrossOrigin("*")
public class CheckoutController {
	
	@Value("${STRIPE_SECRET_KEY}")
	private String stripePublicKey;
	
	private static Gson gson = new Gson();
	
	static class CreatePayment{
		
		@SerializedName("items")
		Object[] items;
		
		public Object[] getItems() {
			return items;
		}
	}
	
	
	static class CreatePaymentResponse{
		private String clientSecret;
		public CreatePaymentResponse(String clientSecret) {
			this.clientSecret = clientSecret;
		}
	}
	
	static int calculateOrderAmount(Object[] items) {
		// this should calcuate the order total and return the total
		//value
		System.out.println("items: "+ items[0]);
		return 1400;
	}
	
	@PostMapping("api/payment/create-payment-intent")
	@ResponseBody
	public String createPaymentIntent(@RequestBody JsonNode node ) throws StripeException {
		Stripe.apiKey = stripePublicKey;
		System.out.println("node: "+ node);
		ObjectMapper mapper= new ObjectMapper();
		
		CreatePayment postBody = mapper.convertValue(node, CreatePayment.class);
		PaymentIntentCreateParams params = 
				PaymentIntentCreateParams.builder()
				.setAmount(new Long(calculateOrderAmount(postBody.getItems())))
				.setCurrency("usd")
				.setAutomaticPaymentMethods(
						PaymentIntentCreateParams.AutomaticPaymentMethods
							.builder()
							.setEnabled(true)
							.build()
						)
					.build();
		PaymentIntent paymentIntent = PaymentIntent.create(params);
		CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
		System.out.println("paymentResponse: "+ paymentResponse.clientSecret);
		return gson.toJson(paymentResponse);
	}
}
