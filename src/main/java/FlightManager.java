import java.util.ArrayList;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public int calculateWeightForBaggage() {
        return (this.flight.getPlane().getTotalWeightFromEnum() /2);
    }

    public int calculateBaggageWeightPerPassenger() {
        return (calculateWeightForBaggage() / this.flight.getPlane().getCapacityFromEnum());
    }

    public int calculateBaggageWeightBooked() {
        int bagsBooked = 0;
        ArrayList<Passenger> bookedPassengers = this.flight.getPassengers();
        for (Passenger passenger : bookedPassengers) {
            bagsBooked += passenger.getBags();
        }
        int baggageWeightBooked = bagsBooked * 10;
        return baggageWeightBooked;
    }

}
