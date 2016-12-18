package ca.udia.webapp.controller;

public class UnknownResourceException extends RuntimeException {
    public UnknownResourceException() {
        super();
    }

    public UnknownResourceException(String s) {
        super(s);
    }

    public UnknownResourceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UnknownResourceException(Throwable throwable) {
        super(throwable);
    }
}
