package main;

public class Product {
    private String name;
    private int value;

    public Product() {

    }

    public Product(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
