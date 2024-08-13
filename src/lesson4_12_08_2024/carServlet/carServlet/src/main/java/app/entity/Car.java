package app.entity;

public class Car {
    private Long id;
    private String brand;
    private String number;

    public Car(Long id, String brand, String number) {
        this.id = id;
        this.brand = brand;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
