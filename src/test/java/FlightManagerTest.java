import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    Plane plane;
    Date departureTime;
    Flight flight;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
        departureTime = new Date (119, 01, 13);
        departureTime.setTime(departureTime.getTime() + 60000);
        flight = new Flight(plane, "GLA123", "Glasgow", departureTime, "Paris", 30);
        flightManager = new FlightManager(flight);
        passenger1 = new Passenger("Charlie", 1, 100);
        passenger2 = new Passenger("Dennis", 3, 40);
        passenger3 = new Passenger("Mac", 2,50);
    }

    @Test
    public void canCalculateTotalWeightForBaggage() {
        assertEquals(2000, flightManager.calculateWeightForBaggage());
    }

    @Test
    public void canCalculateBaggageWeightReservedPerPassenger() {
        assertEquals(50, flightManager.calculateBaggageWeightPerPassenger());
    }

    @Test
    public void canCalculateBaggageWeightBooked() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        assertEquals(60, flightManager.calculateBaggageWeightBooked());
    }

    @Test
    public void canCalculateRemainingAvailableBaggageWeight() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        assertEquals(1940, flightManager.calculateRemainingBaggageWeight());
    }

    @Test
    public void canSortPassengersBySeatNumber() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        assertEquals(1, flightManager.sortPassengersSeatsBubble());
    }
}
