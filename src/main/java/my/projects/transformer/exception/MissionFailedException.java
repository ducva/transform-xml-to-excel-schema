package my.projects.transformer.exception;

public abstract class MissionFailedException extends Exception {
    private String message;

    public MissionFailedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
