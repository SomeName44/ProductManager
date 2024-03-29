package ru.netology.pro;

public class Book extends Product {
    private String author;


    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            if (getAuthor().contains(search)) {
                return true;
            } else {
                return false;
            }
        }
    }


}

