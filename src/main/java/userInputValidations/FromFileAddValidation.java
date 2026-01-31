package userInputValidations;

public class FromFileAddValidation {
    private String userPath;

    public FromFileAddValidation(String userPath) {
        this.userPath = userPath;
    }

    public boolean pathValidation() {
            return userPath != null && !userPath.isEmpty() && userPath.length() > 6
            && (userPath.endsWith("txt") || userPath.endsWith("doc")
            || userPath.endsWith("docx") || userPath.endsWith("pdf"));
    }




}
