import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

    // private LocalTime departureTime;
    // LocalTime sixThirty = LocalTime.of(6, 30);

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String departureAirport;
    private String departureTime;
    private String destination;
    private int cost;

    public Flight(Plane plane, String flightNumber, String departureAirport, String departureTime, String destination, int cost) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.destination = destination;
        this.cost = cost;
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public PlaneType getPlaneType() {
        return this.plane.getType();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getCost() {
        return this.cost;
    }

    public int getEmptySeats() {
        int seats = this.plane.getCapacityFromEnum();
        seats -= countPassengers();
        return seats;
    }

    public void bookPassenger(Passenger passenger) {
        if (getEmptySeats() > 0 && passenger.getWallet() >= getCost()) {
            this.passengers.add(passenger);
            passenger.payForFlight(this.cost);
        }
    }

}
