package bus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 24-01-2026
 * Description: An abstract class which describes the entity of a car
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private int mileage;

    public boolean checkBuilding() {
        return model != null && !model.isBlank() && mileage >= 0;
    }
}
