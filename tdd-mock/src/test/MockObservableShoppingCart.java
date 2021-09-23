package test;

import static org.junit.Assert.*;

public class MockObservableShoppingCart implements ObservableShoppingCart{
    private String receivedName;
    private int receivedValue;
    private boolean isError = false;

    @Override
    public void addedProduct(String name, int value) {
        if (isError)
            throw new RuntimeException();
        receivedName = name;
        receivedValue = value;
    }

    public void checkProductReceipt(String expectedProduct, int expectedValue) {
        assertEquals(expectedProduct, receivedName);
        assertEquals(expectedValue, receivedValue);
    }

    public void throwError() {
        this.isError = true;
    }
}
