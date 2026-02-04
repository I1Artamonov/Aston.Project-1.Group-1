package menu.userInputValidations;

public class FilePathValidation {
    private String userPath;

    public FilePathValidation(String userPath) {
        this.userPath = userPath;
    }

    public boolean pathValidation() {
        return userPath != null && !userPath.isEmpty() && userPath.length() > 6
                && (userPath.endsWith(".txt")); // минимальная длина пути + ".txt"
    }
}