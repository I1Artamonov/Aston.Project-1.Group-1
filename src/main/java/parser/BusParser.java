package parser;


import entity.Bus;
import entity.BusBuilder;

public class BusParser implements Parser {
    @Override
    public Bus parse(String line) {

        if (line == null || line.isBlank()) {
            System.out.println("Пустая строка.");
        }

        assert line != null;
        String[] parts = line.split(",");

        if (parts.length != 3) {
            System.out.println("Колличество полей должно быть соответсвующим.");
        }

        int number = Integer.parseInt(parts[0].trim());
        String model = parts[1].trim();
        int mileage = Integer.parseInt(parts[2].trim());

        validate(number, model, mileage);
        return new BusBuilder().setMileage(mileage).setModel(model).setNumber(number).build();



    }

   private void validate(int number, String model, int mileage) {
        if (number < 0) {
            System.out.println("Номер пустой");
        }
        if (model.isEmpty()) {
            System.out.println("Модель пустая");
        }
        if (mileage < 0) {
            System.out.println("Пробег отрицательный");
        }
    }
}
