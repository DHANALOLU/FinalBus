
import java.util.*;

public class BusDetails {
	String busList[] = { "B1", "B2", "B3", "B4", "B5" };
	String stopsList[] = { "A", "B", "C", "D", "E" };
	List<Bus> busDetails = new ArrayList<>();
	Map<String, List<String>> BusesAndRoutes = new HashMap<>();

	public void printbusList() {
		System.out.print("Buses:" + " ");

		Arrays.stream(busList)
        .forEach(bus->System.out.print(bus + " "));

		System.out.println();

	}

	public void printstopList() {
		System.out.print("Stops:" + " ");
		Arrays.stream(stopsList)
        .forEach(stop->System.out.print(stop + " "));

		System.out.println();

	}

	public void printRoutes() {
		System.out.println("Buses and routes Available:");
		System.out.println("B1:" + "A-B-C");
		System.out.println("B2:" + "B-C-E");
		System.out.println("B3:" + "B-C-D-E");
		System.out.println("B4:" + "A-B-D-E");
		System.out.println("B5:" + "C-D-E");

	}

	public Map<String, List<String>> createBusRouteDetails() {

		List<String> bus1 = List.of("A-B","A-C","B-C");
		BusesAndRoutes.put("B1", bus1);

		List<String> bus2 = List.of("B-C","C-E","B-E");
		BusesAndRoutes.put("B2", bus2);

		List<String> bus3 = List.of("B-D","B-C","B-E","C-D","C-E","D-E");
		BusesAndRoutes.put("B3", bus3);

		List<String> bus4 = List.of("A-B","A-D","A-E","B-D","B-E","D-E");
		BusesAndRoutes.put("B4", bus4);

		List<String> bus5 = List.of("C-D","C-E","D-E");
		BusesAndRoutes.put("B5", bus5);

		return BusesAndRoutes;
	}

	public List<Bus> createBusDetails() {
		Bus B1 = new Bus("B1", 20, 30, 100.00, 150.00);
		Bus B2 = new Bus("B2", 40, 10, 150.00, 200.00);
		Bus B3 = new Bus("B3", 20, 30, 100.00, 200.00);
		Bus B4 = new Bus("B4", 25, 25, 200.00, 250.00);
		Bus B5 = new Bus("B5", 30, 35, 150.00, 200.00);
		busDetails.add(B1);
		busDetails.add(B2);
		busDetails.add(B3);
		busDetails.add(B4);
		busDetails.add(B5);
		return busDetails;
	}

}
