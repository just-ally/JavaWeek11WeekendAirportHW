import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Flight flight2;
    Plane plane;
    Plane plane2;
    Date departureTime;
    Date departureTime2;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.AIRBUSA340);

        departureTime = new Date (119, 01, 13);
        departureTime.setTime(departureTime.getTime() + 60000);
        flight = new Flight(plane, "GLA123", "Glasgow", departureTime, "Paris", 30);

        departureTime2 = new Date (119, 01, 13);
        departureTime2.setTime(departureTime2.getTime() + 80000);
        flight2 = new Flight(plane2, "EDI456", "Edinburgh", departureTime2, "Berlin", 5);
        passenger1 = new Passenger("Charlie", 1, 100);
        passenger2 = new Passenger("Dennis", 3, 10);
    }

    @Test
    public void startsWithNoBookedPassengers() {
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void canReturnBookedPassengers() {
        flight.bookPassenger(passenger1);
        assertEquals(passenger1, flight.getPassengers().get(0));
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, flight.getPlaneType());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("GLA123", flight.getFlightNumber());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("Glasgow", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void hasDestination() {
        assertEquals("Paris", flight.getDestination());
    }

    @Test
    public void hasCost() {
        assertEquals(30, flight.getCost());
    }

    @Test
    public void canReturnNumberOfAvailableSeats() {
        assertEquals(40, flight.getEmptySeats());
    }

    @Test
    public void canBookPassengerIfAvailableAndAffordable() {
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.countPassengers());
        assertEquals(39, flight.getEmptySeats());
    }

    @Test
    public void cantBookPassengerIfNoSeatsAvailable() {
        flight2.bookPassenger(passenger1);
        flight2.bookPassenger(passenger2);
        assertEquals(1, flight2.countPassengers());
    }

    @Test
    public void cantBookPassengerIfNotAffordable() {
        flight.bookPassenger(passenger2);
        assertEquals(0, flight.countPassengers());
    }
}
