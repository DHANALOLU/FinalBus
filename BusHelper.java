import java.util.*;

import java.util.logging.Logger;

public class BusHelper {

	List<String> buses = new ArrayList<String>();
	List<Bus> BusesValidated = new ArrayList<>();
	Logger logger = Logger.getLogger(BusHelper.class.getName());

	public List<String> findBus(char source, char destination, Map<String, List<String>> BusesAndRoutes) {
		if (source == (destination)) {
			logger.info("Source And Destination Can't be Same");
		}

		for (Map.Entry<String, List<String>> entry : BusesAndRoutes.entrySet()) {
			List<String> routeList = entry.getValue();
			for (String b : routeList) {
				if (b.contains(String.valueOf(source)) & b.contains(String.valueOf(destination))
						& (b.indexOf(source) < b.indexOf(destination))) {
					buses.add(entry.getKey());
				}
			}
		}

		return buses;

	}

	public void printAvailableBuses(List<String> buses) {
		System.out.println("Buses Available are:");
		System.out.println("----------------------------");

		buses.forEach(bus -> System.out.print(bus + " "));
		System.out.println();
	}

	public void printBusDetails(List<String> buses, List<Bus> busDetails) {
		System.out.println("Bus" + "     " + "NoOfSeaterTickets" + "     " + "NoOfSleeperTickets" + "     "
				+ " PriceOfSeaterTickets" + "       " + "PriceOfSleeperTickets");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (Bus busdetails : busDetails) {
			for (String busavail : buses) {
				if (busdetails.getbusName() == busavail) {
					System.out.println(busdetails.getbusName() + "          " + busdetails.getseaterTickets()
							+ "           " + busdetails.getsleeperTickets() + "           "
							+ busdetails.getseaterPrice() + "          " + busdetails.getsleeperPrice());
				}
			}
		}
	}

	public List<Bus> validateBusBasedOnTicket(List<String> buses, List<Bus> busDetails, String ticketType,
			int ticketsCount) {

		for (Bus bus : busDetails) {
			for (String busavail : buses) {
				if ((bus.getbusName().equals(busavail)) & ticketType.equals("SL")) {
					if (bus.getsleeperTickets() >= ticketsCount)
						BusesValidated.add(bus);
				} else if ((bus.getbusName().equals(busavail)) & ticketType.equals("ST")) {
					if (bus.getseaterTickets() >= ticketsCount)
						BusesValidated.add(bus);
				}
			}
		}

		return BusesValidated;
	}

	public void printValidatedBuses(List<Bus> busesValidated) {
		System.out.println("Buses you can opt are:");
		System.out.println("-----------------------");
		busesValidated.forEach(bus -> System.out.println(bus.getbusName()));
	}

	public Double TotalBilling(List<Double> billing) {
		Double totalbill = 0.0;
		totalbill = billing.stream().mapToDouble(i -> i.doubleValue()).sum();
		return totalbill;

	}
}
