import java.util.List;

public class Sleeper implements IBill {
	

	@Override

	public double printBill(String bus, List<Bus> busDetails, int ticketsCount) {
		double Totalbill = 0.0;
		for (Bus b : busDetails) {
			if (b.getbusName().equals(bus)) {
				Totalbill = b.getsleeperPrice() * ticketsCount;
				int tickets = b.getsleeperTickets() - ticketsCount;
				b.setChangedSleeperTickets(tickets);

				System.out.println(ticketsCount + " seats booked in Bus " + bus + " of type " + " Sleeper");

			}

		}
		return Totalbill;

	}

}
