package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 24-01-2026
 * Description: A class which describes the entity of a bus
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Bus extends Car implements Comparable<Bus>, Generated<Bus> {
    private int number;

    private Bus(BusBuilder builder) {
        super(builder.getModel(), builder.getMileage());
        this.number = builder.getNumber();
    }

    @Override
    public boolean checkBuilding() {
        return super.checkBuilding() && number > 0;
    }

    @Override
    public Bus generate() {
        return new BusBuilder()
                .setNumber(Generated.generateNumber(100, 1))
                .setModel(Generated.generateFromList(busModels))
                .setMileage(Generated.generateNumber(1000, 0))
                .build();
    }

    @Override
    public int compareTo(Bus bus) {
        if (this.number != bus.getNumber()) {
            return this.number - bus.getNumber();
        }
        if (this.getModel().compareTo(bus.getModel()) != 0) {
            return this.getModel().compareTo(bus.getModel());
        }
        return this.getMileage() - bus.getMileage();
    }

    @Override
    public String toString() {
        return String.format("number:%5d | model: %25s | mileage:%5d",
                number, getModel(), getMileage());
    }

    @Getter
    public static class BusBuilder {
        private int number;
        private String model;
        private int mileage;

        public BusBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            Bus bus = new Bus(this);
            if (bus.checkBuilding()) {
                return bus;
            } else {
                System.out.println("The object cannot be created. Number must be > 0, received number="
                        + getNumber() + "; Model must not be empty, received model=" + model +
                        "; Mileage must be >= 0, received mileage=" + mileage);
                return null;
            }
        }
    }
}
