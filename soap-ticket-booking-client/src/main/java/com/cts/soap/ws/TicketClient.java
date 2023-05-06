package com.cts.soap.ws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class TicketClient {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the details : ");
			System.out.println("Enter the ticket id(Integers only):");
			Ticket ticket = new Ticket();
			ticket.setTicketId(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the date of the show(dd/MM/yyyy):");
			String date = sc.nextLine();

			
			LocalDate  now = LocalDate.now();
			
			if(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).compareTo(now)<0) {
				System.out.println("Booking can not be done!!! Invalid Date : You can not book show for previous dates");
				return;
			}
			ticket.setBookingDate(date);

			System.out.println("Enter the name of the show :");
			ticket.setShowName(sc.nextLine());
			System.out.println("Choose the screen type:\n1. S1\t2. S2\t3. S3\t4. S4");
			String screenNumber = sc.nextLine();
			if (screenNumber.matches("[sS][1-4]")) {
				ticket.setScreenNumber(screenNumber);
			} else {
				System.out.println("Invalid Screen Type");
				return;
			}

			System.out.println("Enter the no of tickets(Integers only):");
			
			int noOfT = Integer.parseInt(sc.nextLine());
			if (noOfT > 0) {
				ticket.setNoOfTickets(noOfT);
			}else {
				System.out.println("No of Tickets should be greater than zero");
				return;
			}

			BookingServiceImplService service = new BookingServiceImplService();
			BookingService bookingServicePortType = service.getBookingServiceImplPort();
			double amt = bookingServicePortType.calculatePrice(ticket);
			System.out.println("The total cost of the tickets are " + amt);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date :" + e);

		} catch (InvalidTicketDetailsException_Exception | RuntimeException e) {
			System.out.println("Invalid details: "+e);
		}

	}

}
