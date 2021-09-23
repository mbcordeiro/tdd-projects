package main;

import test.ObservableShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> itens = new ArrayList<>();
    private List<ObservableShoppingCart> observers = new ArrayList<>();

    public void addProduct(Product product) {
        itens.add(product);
        for (var observer : observers) {
            try {
                observer.addedProduct(product.getName(), product.getValue());
            } catch (RuntimeException e) {
            }
        }
    }

    public int total() {
        int total = 0;
        for (Product product : itens)
            total += product.getValue();
        return total;
    }

    public void addObserver(ObservableShoppingCart observer) {
        this.observers.add(observer);
    }
}
