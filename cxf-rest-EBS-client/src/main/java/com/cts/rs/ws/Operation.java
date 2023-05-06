package com.cts.rs.ws;

import java.util.List;

import com.cts.rs.ws.dto.Consumer;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Operation {
	private static final String BILL_SERVICE = "http://localhost:8080/bill-service/consumer";

	public static void addOpt(Client client) {
		Consumer c1 = new Consumer();
		System.out.println("Enter the details :");
		String conId = Validation.getConsumerId();
		c1.setConsumerId(conId);
		String name = Validation.getConsumerName();
		c1.setConsumerName(name);
		String qn = Validation.getQName();
		c1.setqName(qn);
		c1.setConsumedUnit(Validation.getConsumedUnit());
		WebTarget targetPost = client.target(BILL_SERVICE);
		targetPost.register(new JacksonJsonProvider());
		Response post = targetPost.request().post(Entity.entity(c1, MediaType.APPLICATION_JSON));
		if (post.getStatus() == 200) {
			System.out.println("Details added successfully");
		} else {
			System.out.println("Unable to process the request");
		}
	}

	public static void findAllOpt(Client client) {
		List<Consumer> list = null;
		try {
			WebTarget target1 = client.target(BILL_SERVICE);
			target1.register(new JacksonJsonProvider());
			Invocation.Builder builder2 = target1.request();
			Response responseGetAll = builder2.get();
			if (responseGetAll.getStatus() != 200) {
				System.out.println("Unable to process the request");
			} else {
				System.out.println("Bill Details:");
				list = builder2.get(new GenericType<List<Consumer>>() {
				});

				if (list == null) {
					System.out.println("Returned bills null.");
				}
				list.forEach(i -> {
					System.out.println(i.toString());
				});

			}
		} catch (WebApplicationException ex) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

	}

	public static void findByIdOpt(Client client) {
		int id = Validation.getBillId();
		WebTarget target1 = client.target(BILL_SERVICE).path("/{billId}").resolveTemplate("billId", id);
		target1.register(new JacksonJsonProvider());
		Invocation.Builder builder1 = target1.request();
		Response response1 = builder1.get();
		if (response1.getStatus() != 200) {
			System.out.println("Bill not found with id: " + id);
		} else {

			Consumer event = builder1.get(Consumer.class);
			System.out.println(event.toString());
		}
	}

	public static void editOpt(Client client) {
		Consumer c2 = new Consumer();
		System.out.println("Enter the details :");

		int id1 = Validation.getBillId();
		c2.setBiilId(id1);
		WebTarget targetPut = client.target(BILL_SERVICE).path("/{billId}").resolveTemplate("billId", id1);
		targetPut.register(new JacksonJsonProvider());
		Invocation.Builder builder1 = targetPut.request();
		Response response1 = builder1.get();
		if (response1.getStatus() != 200) {
			System.out.println("Bill not found with id: " + id1);
		} else {

			c2.setConsumerId(Validation.getConsumerId());
			c2.setConsumerName(Validation.getConsumerName());
			c2.setqName(Validation.getQName());
			c2.setConsumedUnit(Validation.getConsumedUnit());

			Consumer putResponse = targetPut.request().put(Entity.entity(c2, MediaType.APPLICATION_JSON),
					Consumer.class);

			System.out.println(putResponse.toString());
		}
	}

	public static void deleteOpt(Client client) {
		int id2 = Validation.getBillId();
		WebTarget target2 = client.target(BILL_SERVICE).path("/{billId}").resolveTemplate("billId", id2);
		target2.register(new JacksonJsonProvider());
		Invocation.Builder builder2 = target2.request();
		Response response1 = builder2.get();
		if (response1.getStatus() != 200) {
			System.out.println("Bill not found with id: " + id2);
		} else {
			Consumer event2 = builder2.get(Consumer.class);

			Response response2 = builder2.delete();
			if (response2.getStatus() == 200) {
				System.out.println("Item is deleted successfully !!");
				System.out.println("Deleted Item: ");
				System.out.println(event2.toString());
			} else {
				System.out.println("Unable to process the request");
			}
		}
	}

	public static void findCostByIdOpt(Client client) {
		int id3 = Validation.getBillId();
		WebTarget target3 = client.target(BILL_SERVICE).path("/{billId}/cost").resolveTemplate("billId", id3);
		target3.register(new JacksonJsonProvider());
		Invocation.Builder builder3 = target3.request();
		Response response3 = builder3.get();
		if (response3.getStatus() != 200) {
			System.out.println("Bill not found with id: " + id3);
		} else {

			double cost = builder3.get(double.class);
			System.out.println("The electricity bill with the bill id " + id3 + " : " + cost);
		}
	}
}
