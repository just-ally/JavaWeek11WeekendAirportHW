import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Flight {

    // private LocalTime departureTime;
    // LocalTime sixThirty = LocalTime.of(6, 30);

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String departureAirport;
//    private String departureTime;
    private Date departureTime;
    private String destination;
    private int cost;
    private ArrayList<Integer> seatNumbers;

    public Flight(Plane plane, String flightNumber, String departureAirport, Date departureTime, String destination, int cost) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.destination = destination;
        this.cost = cost;
        // is this okay??!
        this.seatNumbers = populateSeatNumbers();
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

    public Date getDepartureTime() {
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
            passenger.storeFlightDetails(this);
            this.assignRandomSeatNumber(passenger);
        }
    }

    public ArrayList<Integer> populateSeatNumbers(){
        int capacity = this.plane.getCapacityFromEnum();
        ArrayList<Integer> seats = new ArrayList<Integer>();
        int i;
        for (i = 1; i <= capacity; i++){
            seats.add(i);
        }
        return seats;
    }

    public ArrayList<Integer> getSeatNumbers() {
        return this.seatNumbers;
    }

    // I think this guarantees uniqueness?
    // tested that random index starts at 0
    public void assignRandomSeatNumber(Passenger passenger) {
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(this.seatNumbers.size());
        int assignedSeat = this.seatNumbers.get(randomIndex);
        this.seatNumbers.remove(randomIndex);
        passenger.setSeatNumber(assignedSeat);
    }

}

//
//import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Random;
//
//public class GFG {
//
//    // Drive Function
//    public static void main(String[] args)
//    {
//
//        GFG obj = new GFG();
//
//        // boundIndex for select in sub list
//        int numberOfElements = 3;
//
//        // take a random element from list and print them
//        System.out.println(obj.getRandomElement(list,
//                numberOfElements));
//    }
//
//    // Function select an element base on index and return
//    // an element
//    public List<Integer> getRandomElement(List<Integer> list,
//                                          int totalItems)
//    {
//        Random rand = new Random();
//
//        // create a temporary list for storing
//        // selected element
//        List<Integer> newList = new ArrayList<>();
//        for (int i = 0; i < totalItems; i++) {
//
//            // take a raundom index between 0 to size
//            // of given List
//            int randomIndex = rand.nextInt(list.size());
//
//            // add element in temporary list
//            newList.add(list.get(randomIndex));
//
//            // Remove selected element from orginal list
//            list.remove(randomIndex);
//        }
//        return newList;
//    }
//}
//
