public class Bus {
	int seaterTickets;
	int sleeperTickets;
	double seaterPrice;
	double sleeperPrice;
	String busName;

	public Bus(String busName, int seaterTickets, int sleeperTickets, double seaterPrice, double sleeperPrice) {
		this.seaterTickets = seaterTickets;
		this.sleeperTickets = sleeperTickets;
		this.seaterPrice = seaterPrice;
		this.sleeperPrice = sleeperPrice;

		this.busName = busName;

	}

	public int getseaterTickets() {
		return seaterTickets;
	}

	public int getsleeperTickets() {
		return sleeperTickets;
	}

	public double getseaterPrice() {
		return seaterPrice;
	}

	public double getsleeperPrice() {
		return sleeperPrice;
	}

	public String getbusName() {
		return busName;
	}

	public void setChangedSeaterTickets(int changedTicket) {
		this.seaterTickets = changedTicket;

	}

	public void setChangedSleeperTickets(int changedTicket) {
		this.sleeperTickets = changedTicket;

	}
}
