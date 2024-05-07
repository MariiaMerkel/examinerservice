package ru.merkel.examinerservice.exceptions;

public class ShortageOfQuestionsException extends RuntimeException {
    public ShortageOfQuestionsException(String message) {
        super(message);
    }
}
