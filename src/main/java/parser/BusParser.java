package parser;


import entity.Bus;

public class BusParser implements Parser {
    @Override
    public Bus parse(String input) {
        return new Bus();
    }
//
//    public Bus parse(String line) {
//
//        if (line == null || line.isBlank()) {
//            throw new IllegalArgumentException("Пустая строка");
//        }
//
//        String[] parts = line.split(",");
//
//        if (parts.length != 3) {
//            throw new IllegalArgumentException("Неверный формат строки: " + line);
//        }
//
//        String number = parts[0].trim();
//        String model = parts[1].trim();
//        int mileage;
//
//        try {
//            mileage = Integer.parseInt(parts[2].trim());
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Пробег не число: " + parts[2]);
//        }
//
//        validate(number, model, mileage);
//
//        return new Bus.Builder()
//                .number(number)
//                .model(model)
//                .mileage(mileage)
//                .build();
//    }
//
//    private void validate(String number, String model, int mileage) {
//        if (number.isEmpty()) {
//            throw new IllegalArgumentException("Номер пустой");
//        }
//        if (model.isEmpty()) {
//            throw new IllegalArgumentException("Модель пустая");
//        }
//        if (mileage < 0) {
//            throw new IllegalArgumentException("Пробег отрицательный");
//        }
//    }
}
