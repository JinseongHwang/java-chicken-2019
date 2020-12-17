package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, Integer> orders = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int orderedQuantity(Menu menu) {
        if (orders.get(menu) == null) {
            return 0;
        }
        return orders.get(menu);
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void add(Menu menu, int quantity) {
        orders.put(menu, orderedQuantity(menu) + quantity);
    }

    public Map<Menu, Integer> orderContents() {
        return orders;
    }

}
