package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader implements Reader {
    public String[] read(String path) {

        if (path == null) {
            return new String[0];
        }
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            int lines = 0;

            while (reader.readLine() != null) {
                lines++;
            }
            String[] data = new String[lines];

            if (lines < 1) {
                return data;
            }
            for (int i = 0; i < lines; i++) {
                data[i] = reader.readLine();
            }
            return data;
        } catch (FileNotFoundException ignored) {
            System.out.println("Путь не корректен ");
        } catch (IOException ignored) {
            System.out.println("Ошибка чтения файла: ");
        }
        return new String[0];
    }
}
