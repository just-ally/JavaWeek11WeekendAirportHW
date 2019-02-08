import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Plane plane;
    Flight flight;

    @Before
    public void before(){
        passenger = new Passenger("Charlie",1,100);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "GLA123", "Glasgow", "19:00", "Paris", 30);
    }

    @Test
    public void hasName() {
        assertEquals("Charlie", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(1, passenger.getBags());
    }

    @Test
    public void hasWallet() {
        assertEquals(100, passenger.getWallet());
    }

    @Test
    public void canPayForFlight() {
        flight.bookPassenger(passenger);
        assertEquals(70, passenger.getWallet());
    }
}
