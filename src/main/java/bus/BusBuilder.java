package bus;

import lombok.Getter;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 24-01-2026
 * Description: A class for creating a bus
 */
@Getter
public class BusBuilder {
    private String model;
    private int mileage;
    private int number;

    public BusBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public BusBuilder setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BusBuilder setNumber(int number) {
        this.number = number;
        return this;
    }

    public Bus build() {
        Bus bus = new Bus(this);
        if (bus.checkBuilding()) {
            return bus;
        } else {
            throw new IllegalArgumentException("The object cannot be created");
        }
    }
}
