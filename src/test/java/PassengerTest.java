import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Plane plane;
    Date departureTime;
    Flight flight;

    @Before
    public void before(){
        passenger = new Passenger("Charlie",1,100);
        plane = new Plane(PlaneType.BOEING747);

        departureTime = new Date (119, 01, 13);
        departureTime.setTime(departureTime.getTime() + 60000);
        flight = new Flight(plane, "GLA123", "Glasgow", departureTime, "Paris", 30);
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

    @Test
    public void startsWithNoFlightsBooked() {
        assertEquals(0, passenger.getNumberOfBookedFlights());
    }

    @Test
    public void canStoreBookedFlights() {
        flight.bookPassenger(passenger);
        assertEquals(1, passenger.getNumberOfBookedFlights());
        assertEquals(flight, passenger.getBookedFlights().get(0));
    }

    @Test
    public void seatNumberStartsAt0() {
        assertEquals(0, passenger.getSeatNumber());
    }

    // written to test that seat number has changed
//    @Test
//    public void hasRandomSeatNumberOnBookedFlight() {
//        flight.bookPassenger(passenger);
//        assertEquals(0, passenger.getSeatNumber());
//    }
}
