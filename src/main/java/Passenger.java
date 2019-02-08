public class Passenger {

    private String name;
    private int numberOfBags;
    private int wallet;

    public Passenger(String name, int numberOfBags, int wallet) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.wallet = wallet;
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
}
