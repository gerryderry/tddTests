public class Car {

    private int gallons;
    private int milesToGallon;

    public Car(int milesToGallon) {
        this.milesToGallon = milesToGallon;
    }

    public void fill(int gallons){
        this.gallons = gallons;
    }

    public int getGallons() {
        return this.gallons;
    }
}
