public enum PlaneType {
    BOEING747(40, 4000),
    BOEING787DREAMLINER(50, 10000),
    AIRBUSA380(30, 4200),
    AIRBUSA340(1, 1400);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
