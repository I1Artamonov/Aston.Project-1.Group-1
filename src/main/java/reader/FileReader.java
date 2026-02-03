package reader;

public class FileReader implements Reader{
    @Override
    public String[] read(String path) {
        return new String[100];
    }


//    public List<String> readLines(String path) {
//        try {
//            return Files.lines(Path.of(path))
//                    .toList();
//        } catch (IOException e) {
//            throw new RuntimeException("Ошибка чтения файла", e);
//        }
//    }
}
