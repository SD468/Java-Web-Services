package com.cts.rs.ws;

import java.util.Scanner;

public class Validation {
	static Scanner sc = new Scanner(System.in);

	public static int getBillId() {
		while (true) {
			try {
				System.out.println("Enter the bill id :");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid details !!! Intergers only !!! Try again " + e);
			}
		}
	}

	public static String getConsumerId() {
		while (true) {

			System.out.println("Enter the Consumer id :");
			String conId = sc.nextLine();
			if (!conId.matches("[1-9][0-9]{8}")) {
				System.out.println("Invalid Details!!Consumer id must be 9 digit number\nTry Again");

			} else {
				return conId;
			}

		}
	}

	public static String getConsumerName() {
		while (true) {

			System.out.println("Enter the consumer name :");
			String name = sc.nextLine();
			if (!name.matches("[a-zA-Z ]+")) {
				System.out.println("Invalid Details!!Consumer name should be only alphabetical\nTry again");
			} else {
				return name;
			}

		}
	}

	public static String getQName() {
		while (true) {
			System.out.println("Enter the quarter name :");
			String qn = sc.nextLine();
			if (!qn.matches("[Q][1-4]")) {
				System.out.println("Invalid Details!! Quaters are Q1,Q2,Q3,Q4\nTry Again");
			} else {
				return qn;
			}
		}
	}

	public static int getConsumedUnit() {
		while (true) {
			try {
				System.out.println("Enter the consumed units :");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid details !!! Intergers only !!! Try again " + e);
			}
		}
	}
}
