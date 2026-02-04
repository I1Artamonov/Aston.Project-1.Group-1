package entity;

import java.util.Random;

/**
 * @author YuliyaVasilenko
 * @version 1.0.0
 * Date 25-01-2026
 * Description: An interface for generate something
 */
public interface Generated<T> {
    String[] busModels = {
            "Mercedes Benz Citaro", "Mercedes Benz Conecto", "Mercedes Benz Tourismo",
            "Volvo 7900", "Volvo 8900", "Scania Citywide", "Scania Interlink",
            "MAN Lion’s City", "MAN Lion’s Coach", "BYD K9", "BYD K11",
            "Yutong ZK6128HG", "Yutong ZK6116HG", "Higer KLQ6119TQ", "Higer KLQ6891GQ",
            "King Long XMQ6127C", "King Long XMQ6800Y", "Ankai HFF6120D03D", "Ankai HFF6801K03EV",
            "Setra S 515 HD", "Setra S 517 HDH", "Neoplan Cityliner", "Neoplan Skyliner",
            "Irisbus Crossway", "Irisbus Citelis", "Alexander Dennis Enviro200",
            "Alexander Dennis Enviro400", "Wrightbus StreetDeck", "Wrightbus Gemini 3",
            "Optare Solo", "Optare MetroCity", "VDL bus.Bus & Coach Futura", "VDL Citea",
            "SOR NB 12", "SOR CN 12", "Jelcz M081", "Jelcz PR110M", "Temsa Avenue", "Temsa Prestij",
            "Hyundai Universe", "Hyundai Aero City", "Kia Granbird", "Ashok Leyland Citiline",
            "Tata Starbus", "Isuzu Urban", "Hino Rainbow", "Mitsubishi Fuso Aero Star",
            "Dennis Trident", "Gräf & Stift BB15", "Solbus SM12", "LIAZ 5256"
    };

    static int getInt(int upper) {
        return new Random().nextInt(upper);
    }

    static <T> T generateFromList(T[] list) {
        int randomNumber = getInt(list.length);
        return list[randomNumber];
    }

    static int generateNumber(int upper, int lower) {
        return getInt(upper) + lower;
    }

    T generate();
}
