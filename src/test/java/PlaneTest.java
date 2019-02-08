import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getType());
    }

    @Test
    public void hasCapacity() {
        assertEquals(40, plane.getCapacityFromEnum());
    }

    @Test
    public void hasTotalWeight() {
        assertEquals(4000, plane.getTotalWeightFromEnum());
    }
}
