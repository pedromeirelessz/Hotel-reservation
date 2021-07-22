package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Check-in Date(DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check-in Date(DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
		
			System.out.println(reservation);
			
			
			
			System.out.println();
			System.out.println("Enter data to update be reservation: ");
			
			System.out.print("Check-in Date(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-in Date(DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);

		} 
		catch (DomainException d) {
			System.out.println("Error in reservation: " + d.getMessage());
		} 
		catch (ParseException P) {
			System.out.println("Invalid date format");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

	}

}