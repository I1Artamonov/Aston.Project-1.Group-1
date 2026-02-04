package parser;


import entity.Bus;


public class BusParser implements Parser {
    @Override
    public Bus parse(String line) {

        if (line == null || line.isBlank()) {
            System.out.println("Пустая строка.");
            return null;
        }

        String[] parts = line.trim().split(",");

        if (parts.length != 3) {
            System.out.println("Количество полей должно быть соответствующим.");
            return null;
        }

        int number = Integer.parseInt(parts[0]);
        String model = parts[1];
        int mileage = Integer.parseInt(parts[2]);

        validate(number, model, mileage);
        return new Bus.BusBuilder().setMileage(mileage).setModel(model).setNumber(number).build();



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
