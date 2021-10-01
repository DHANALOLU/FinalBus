import java.util.List;

public class Seater implements IBill {
	

	@Override
	public double printBill(String bus, List<Bus> busDetails, int ticketsCount) {
		double Totalbill = 0.0;
		for (Bus b : busDetails) {
			if (b.getbusName().equals(bus)) {
				Totalbill = b.getseaterPrice() * ticketsCount;
				int tickets = b.getseaterTickets() - ticketsCount;
				b.setChangedSeaterTickets(tickets);
				System.out.println(ticketsCount + "  " + "  seats booked in Bus  " + bus + " of type" + "Seater");
			}
		}
		return Totalbill;

	}}
