import java.util.ArrayList;

public class Passenger {

    private String name;
    private int numberOfBags;
    private int wallet;
    private ArrayList<Flight> bookedFlights;

    public Passenger(String name, int numberOfBags, int wallet) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.wallet = wallet;
        this.bookedFlights = new ArrayList<Flight>();
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.numberOfBags;
    }

    public int getWallet() {
        return this.wallet;
    }

    public void payForFlight(int cost) {
        this.wallet -= cost;
    }

    public int getNumberOfBookedFlights() {
        return this.bookedFlights.size();
    }

    public void storeFlightDetails(Flight flight) {
        this.bookedFlights.add(flight);
    }

    public ArrayList<Flight> getBookedFlights() {
        return this.bookedFlights;
    }
}
