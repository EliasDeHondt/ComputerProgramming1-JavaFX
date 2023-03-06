package be.kdg.mywoordle.model;

/**
 * Eigen UNchecked exception
 */
public class WoordleException extends RuntimeException{

    public WoordleException(String message) {
        super(message);
    }

    public WoordleException(String message, Throwable cause) {
        super(message, cause);
    }
}
