package parser;

import entity.Bus;

public class ParserTest {

    public static void main(String[] args) {
        BusParser parser = new BusParser();

        Bus bus = parser.parse("A123,Mercedes,120000");

        System.out.println(bus.getNumber());
        System.out.println(bus.getModel());
        System.out.println(bus.getMileage());
    }
}
