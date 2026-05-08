package com.yehor.lab4;

public class ObjectNotFoundException extends RuntimeException { // власний виняток

    public ObjectNotFoundException(String message) { // конструктор винятку
        super(message);
    }
}