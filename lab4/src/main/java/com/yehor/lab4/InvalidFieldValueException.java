package com.yehor.lab4;

public class InvalidFieldValueException extends RuntimeException { // власний виняток

    public InvalidFieldValueException(String message) { // конструктор винятку
        super(message);
    }
}