import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void fill() {
        Car myCar = new Car(20);

        assertEquals(0, myCar.getGallons());

        myCar.fill(5);
        assertEquals(5, myCar.getGallons());

        myCar.fill(6);
        assertEquals(11, myCar.getGallons());

        myCar.fill(10);
        assertEquals(20, myCar.getGallons());

    }

    @Test
    public void storesPetrolPerInstance() {
        Car car1 = new Car(10);
        car1.fill(5);

        Car car2 = new Car(10);
        car2.fill(4);

        assertEquals(5, car1.getGallons());
        assertEquals(4, car2.getGallons());

    }



    @Test
    public void usesPetrolWhenDriving() {
        Car myCar = new Car(10);
        myCar.fill(10);
        assertEquals(10, myCar.getGallons());
        myCar.drive(50);
        assertEquals(5, myCar.getGallons());

        myCar.drive(10);

        // Need to revisit this test, should be 4
        assertEquals(2, myCar.getGallons());

    }


    @Test
    public void incrementsTheOdometerWhenDriving() {
        Car car = new Car(10);
        car.fill(10);
        assertEquals(0, car.getOdometer());
        car.drive(50);
        assertEquals(50, car.getOdometer());
        car.drive(25);
        assertEquals(75, car.getOdometer());
    }


    @Test
    public void recordsTrips() {
        Car myCar = new Car(10);
        assertArrayEquals(new String[0], myCar.getTrips());

        myCar.fill(10);
        myCar.drive(50);

        String[] expectedRecordedTrip = new String[1];
        expectedRecordedTrip[0] = "50 Miles";

        assertArrayEquals(expectedRecordedTrip, myCar.getTrips());

        String[] updatedRecordedTrip = new String[2];
        updatedRecordedTrip[0] = "50 Miles";
        updatedRecordedTrip[1] = "25 Miles";

        myCar.drive(25);
        assertArrayEquals(updatedRecordedTrip, myCar.getTrips());
        assertEquals(2, myCar.getTrips().length);
        assertEquals("25 Miles", myCar.getTrips()[1]);

    }

}

