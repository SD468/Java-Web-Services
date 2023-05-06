package com.cts.rs.ws;

import java.text.ParseException;
import java.util.Scanner;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class BillingClient {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {

		ClientBuilder.newBuilder();
		Client client = ClientBuilder.newClient();

		System.out.println("Hi!! Welcome to Consumer Bill Register");
		System.out.println("What do you want to perform"
				+ "\n1.\tAdd a new bill \n2.\tFind all bill details\n3.\tFind a bill \n4.\tEdit a bill"
				+ "\n5.\tDelete a bill\n6.\tCalculate Electricity bill  of a consumer\n7.\tExit");

		while (true) {
			System.out.println("Enter your choice");
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				Operation.addOpt(client);
				break;

			case 2:
				Operation.findAllOpt(client);
				break;
			case 3:
				
				Operation.findByIdOpt(client);
				break;
			case 4:
				Operation.editOpt(client);
				break;
			case 5:
				Operation.deleteOpt(client);
				break;
			case 6:
				Operation.findCostByIdOpt(client);
				break;
			case 7:
				System.out.println("Closing the application");
				return;
			default:
				System.out.println("Invalid input!! Try again");
				break;
			}
		}
	}

}
