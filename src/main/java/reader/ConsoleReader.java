package reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    public String[] read(int count) {

        String[] data = new String[count];

        try(Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < count; i++) {
                data[i] = scanner.nextLine();
            }
        }

        return data;
    }
    public int readCount(){
        try(Scanner scanner = new Scanner(System.in)) {
             return scanner.nextInt();
            }



    }
}
