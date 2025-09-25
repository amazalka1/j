import java.util.Objects;

public class Car {
    private  int number;
    private String brand;

    public Car(String brand, int number) {
        this.number = number;
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brand);
    }
}
