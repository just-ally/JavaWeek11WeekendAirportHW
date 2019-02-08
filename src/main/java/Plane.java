public class Plane {

    private PlaneType typeOfPlane;

    public Plane(PlaneType typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public PlaneType getType() {
        return this.typeOfPlane;
    }

    public int getCapacityFromEnum() {
        return this.typeOfPlane.getCapacity();
    }

    public int getTotalWeightFromEnum() {
        return this.typeOfPlane.getTotalWeight();
    }
}
