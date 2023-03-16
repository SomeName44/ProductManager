package ru.netology.pro;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }
}
