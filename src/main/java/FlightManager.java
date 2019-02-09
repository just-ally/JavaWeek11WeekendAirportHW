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

    public int calculateTotalBagsBooked() {
        int bagsBooked = 0;
        for (Passenger passenger : this.flight.getPassengers()) {
            bagsBooked += passenger.getBags();
        }
        return bagsBooked;
    }

    public int calculateBaggageWeightBooked() {
        return calculateTotalBagsBooked() * 10;
    }

    public int calculateRemainingBaggageWeight() {
        return calculateWeightForBaggage() - calculateBaggageWeightBooked();
    }
}
