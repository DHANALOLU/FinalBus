
import java.util.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import com.planon.mybus.Bus;
import com.planon.mybus.BusHelper;
import com.planon.mybus.NoBusFoundException;
import com.planon.mybus.Seater;
import com.planon.mybus.Sleeper;


public class BusJUnit {

	static BusHelper bushelp;
	static Sleeper sleeper ;
	static Seater seater;
	Map<String, List<String>> BusesAndRoutes = new HashMap<>();
	List<Bus> busDetails = new ArrayList<>();
	

	@BeforeClass
	public static void beforeClass() {
		bushelp = new BusHelper();
		sleeper= new Sleeper();
		seater=new Seater();
	}

	@Before
	public void setUpBeforeTestfindBus() {
		List<String> bus1 = List.of("A-B","A-C","B-C");
		BusesAndRoutes.put("B1", bus1);

		List<String> bus2 = List.of("A-C","C-E","B-C");
		
		BusesAndRoutes.put("B2", bus2);


		Bus B1 = new Bus("B1", 20, 30, 100.00, 150.00);
		Bus B2 = new Bus("B2", 40, 10, 150.00, 200.00);
		busDetails.add(B1);
		busDetails.add(B2);
		
	

	}

	@Test
	public void testfindBus() throws NoBusFoundException {

		List<String> BusesAvail = bushelp.findBus('A', 'C', BusesAndRoutes);

		assertThat("Buses Not Found", BusesAvail, hasItems("B2", "B1"));

	}

	@Test
	public void testvalidateBusBasedOnTicket() {

		List<String> BusesAvail = List.of("B1", "B2");
		List<Bus> finalBuses = bushelp.validateBusBasedOnTicket(BusesAvail, busDetails, "SL", 10);

		List<String> result = new ArrayList<>();
		for (Bus b : finalBuses) {
			result.add(b.getbusName());
		}
		assertThat("Buses Not Found with BusType and Ticket", result, hasItems("B2", "B1"));

	}
	@Test
	public void testTotalBill()
	{ 
		List<Double> ticketAmounts =List.of(150.00,200.00);
		 Double res = bushelp.TotalBilling(ticketAmounts);
		 double bill = res.doubleValue();
		 assertTrue("Expected and Actual Bill is Not Matching",bill-350.00==0);
	}

	
	@Test
	public void testBillOfSleeperPositive()
	{   
	    double fare = sleeper.printBill("B1", busDetails, 1);	
	    assertTrue("Fare doesnt match",fare-150.00==0);
	}
	
	@Test
	public void testBillOfSleeperNegative()
	{   
	    double fare = sleeper.printBill("B1", busDetails, 1);	
	    assertTrue("Fare doesnt match",fare-50.00==0);
	}
	@Test
	public void testBillOfSeaterPositive()
	{   
	    double fare = seater.printBill("B1", busDetails, 1);	
	    assertTrue("Fare doesnt match",fare-100.00==0);
	}
	@Test
	public void testBillOfSeaterNegative()
	{   
	    double fare = seater.printBill("B1", busDetails, 1);	
	    assertTrue("Fare doesnt match",fare-50.00==0);
	}
}
