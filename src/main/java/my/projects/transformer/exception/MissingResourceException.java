package my.projects.transformer.exception;

public class MissingResourceException extends MissionFailedException {
    private final String argumentName;


    public MissingResourceException(String argumentName, String message) {
        super(message);
        this.argumentName = argumentName;
    }

    public String getDetailMessage() {
        return this.getMessage() + ". Missing Argument:" + this.argumentName;
    }

}
