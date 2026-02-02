package bus;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 24-01-2026
 * Description: A class which describes the entity of a bus
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class Bus extends Car implements Comparable<Bus>, Generated<Bus> {
    private int number;

    Bus(BusBuilder builder) {
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
                .setModel(Generated.generateFromList(busModels))
                .setMileage(Generated.generateNumber(1000, 0))
                .setNumber(Generated.generateNumber(100, 1))
                .build();
    }

    @Override
    public int compareTo(Bus bus) {
        if (this.getNumber() != bus.getNumber()) {
            return this.getNumber() - bus.getNumber();
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
}
