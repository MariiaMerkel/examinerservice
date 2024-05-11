package ru.merkel.examinerservice.exceptions;

public class QuestionAlreadyAddedException extends RuntimeException{
    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
