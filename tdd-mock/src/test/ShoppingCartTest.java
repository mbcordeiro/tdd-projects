package test;

import main.Product;
import main.ShoppingCart;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    @Test
    public void totalCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("shoes", 100));
        shoppingCart.addProduct(new Product("tshirt", 50));
        shoppingCart.addProduct(new Product("pants", 70));
        assertEquals(220, shoppingCart.total());
    }

    @Test
    public void listenAdditionProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        MockObservableShoppingCart mock = new MockObservableShoppingCart();
        shoppingCart.addObserver(mock);
        shoppingCart.addProduct(new Product("shoes", 100));
        mock.checkProductReceipt("shoes", 100);
    }

    @Test
    public void addTwoObservers() {
        ShoppingCart shoppingCart = new ShoppingCart();
        MockObservableShoppingCart firstMock = new MockObservableShoppingCart();
        MockObservableShoppingCart secondMock = new MockObservableShoppingCart();
        shoppingCart.addObserver(firstMock);
        shoppingCart.addObserver(secondMock);
        shoppingCart.addProduct(new Product("shoes", 100));
        firstMock.checkProductReceipt("shoes", 100);
        secondMock.checkProductReceipt("shoes", 100);
    }
    @Test
    public void toBeContinuedNotifyingWithErrorInObserver() {
        ShoppingCart shoppingCart = new ShoppingCart();
        MockObservableShoppingCart firstMock = new MockObservableShoppingCart();
        MockObservableShoppingCart secondMock = new MockObservableShoppingCart();
        MockObservableShoppingCart thirdMock = new MockObservableShoppingCart();
        secondMock.throwError();
        shoppingCart.addObserver(firstMock);
        shoppingCart.addObserver(secondMock);
        shoppingCart.addObserver(thirdMock);
        shoppingCart.addProduct(new Product("shoes", 100));
        firstMock.checkProductReceipt("shoes", 100);
        thirdMock.checkProductReceipt("shoes", 100);
    }
}
