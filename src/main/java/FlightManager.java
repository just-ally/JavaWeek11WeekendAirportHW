import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public int calculateWeightForBaggage() {
        return (this.flight.getPlane().getTotalWeightFromEnum() / 2);
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

    public int[] sortPassengersSeatsBubble() {
        // create new array with length equal to number of passengers
        int[] passengerSeats = new int[this.flight.countPassengers()];

        // populate array with seat numbers
        for (int i = 0; i < this.flight.countPassengers(); i++) {
            passengerSeats[i] = this.flight.getPassengers().get(i).getSeatNumber();
        }

        // sort seat numbers
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < passengerSeats.length - 1; i++) {
                if (passengerSeats[i] > passengerSeats[i + 1]) {
                    int temp = passengerSeats[i];
                    passengerSeats[i] = passengerSeats[i + 1];
                    passengerSeats[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return passengerSeats;

        // need to work out how to match sorted seats back to passengers...
//
//        ArrayList<Passenger> sortedPassengers = new ArrayList<Passenger>();
//
//        for (Passenger passenger : this.flight.getPassengers()) {
//            if (passenger.getSeatNumber() == passengerSeats[0]) {
//
//            }
//        }
//
//
//        for (int i = 0; i < passengerSeats.length; i++) {
//            if (this.flight.getPassengers().get(i) == passengerSeats[i]) {
//                sortedPassengers.add(this.flight.getPassengers().get(i));
//            }
//        }

    }
}
