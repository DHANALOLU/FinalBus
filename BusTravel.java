import java.util.*;

import java.util.logging.Logger;

public class BusTravel {
	public static void main(String args[]) throws NoBusFoundException {
		Scanner sc = new Scanner(System.in);
		Logger logger = Logger.getLogger(BusTravel.class.getName());
		BusDetails bus = new BusDetails();

		List<Double> Billing = new ArrayList<>();

		bus.printbusList(); // Printing all the Buses
		bus.printstopList(); // Printing all the Stops
		bus.printRoutes(); // Printing all the routes
		Map<String, List<String>> BusesAndRoutes = bus.createBusRouteDetails(); // Creating map of buses available at
																				// Each Stops
		List<Bus> busDetails = bus.createBusDetails();
		try {
			boolean BuyTicket = true;
			while (BuyTicket) {
				logger.info("Enter Source"); // Enter Source
				char source = sc.next().charAt(0);
				logger.info("Enter Destination:"); // Enter Destination
				char destination = sc.next().charAt(0);
				BusHelper bushelper = new BusHelper();
				List<String> buses = bushelper.findBus(source, destination, BusesAndRoutes);
				// Find Bus between Source and Destination
				try {
					if (buses.isEmpty() & (source == destination)) {
						throw new NoBusFoundException();
					}
					if (buses.isEmpty() & source != destination) {
						
						throw new NoBusFoundException("Please Check Source and Destination...No Buses Found between two Stops!!!!");
					}
				} catch (NoBusFoundException e) {
					//System.err.println("No Buses");
					e.printStackTrace();
				}
				if (!buses.isEmpty()) {
					// If Buses Between Source and Destination are Found
					bushelper.printAvailableBuses(buses); // Print Available Buses
					bushelper.printBusDetails(buses, busDetails); // Print Their Details
					System.out.println("Please Enter Type of Ticket (Enter SL for Sleeper and ST for Seater):");
					String ticketType = sc.next(); // Enter Ticket Type
					System.out.println("Enter Number of Tickets you want of " + ticketType + "type:");
					int ticketsCount = sc.nextInt(); // Enter Ticket Count
					List<Bus> BusesValidated = bushelper.validateBusBasedOnTicket(buses, busDetails, ticketType,
							ticketsCount);// Validate buses
					if (!BusesValidated.isEmpty()) { // If Buses found Based on type and ticket count
						bushelper.printValidatedBuses(BusesValidated); // Print their details
						System.out.println("Please Enter Bus Name you want to book ticket from above Buses List:");
						String finalBus = sc.next(); // Choose bus you would like to take

						if (ticketType.equals("SL")) {
							IBill bill = new Sleeper(); // If Ticket type is Sleeper
							double billing = bill.printBill(finalBus, busDetails, ticketsCount);
							Billing.add(Double.valueOf(billing));
						} else {
							IBill bill = new Seater(); // If Ticket type is Seater
							double billing = bill.printBill(finalBus, busDetails, ticketsCount);
							Billing.add(Double.valueOf(billing));
						}

					} else {
						logger.warning("No Buses are Matching Your Ticket Type and Count");
					}
				}
				System.out
						.println(" Enter 1 to continue booking moretickets and 2 to stop buying tickets (1.Yes 2.No) ");
				int ch = sc.nextInt();
				if (ch == 1)
					BuyTicket = true;
				else
					BuyTicket = false;

			}

			BusHelper bushelper = new BusHelper();
			Double totalbill = bushelper.TotalBilling(Billing);

			System.out.println("Total Bill:" + totalbill);
			System.out.println("Thank You!!!!");
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("Please Check Input");
		}

	}
}
