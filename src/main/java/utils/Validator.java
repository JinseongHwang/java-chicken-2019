package utils;

import domain.Menu;
import domain.Table;

public class Validator {

    private static final int MIN_MAIN_FUNCTION_NUMBER = 1;
    private static final int MAX_MAIN_FUNCTION_NUMBER = 3;
    private static final int MAX_ORDERABLE_QUANTITY = 99;
    private static final int METHOD_CREDIT_CARD = 1;
    private static final int METHOD_CASH = 2;

    public static int onlyMainFunction(int number) {
        if (MIN_MAIN_FUNCTION_NUMBER <= number && number <= MAX_MAIN_FUNCTION_NUMBER) {
            return number;
        }
        throw new IllegalArgumentException();
    }

    public static int reasonableQuantity(Table table, Menu menu, int quantity) {
        if (quantity > 0 && table.orderedQuantity(menu) + quantity <= MAX_ORDERABLE_QUANTITY) {
            return quantity;
        }
        throw new IllegalArgumentException();
    }

    public static int reasonableMethod(int method) {
        if (method == METHOD_CREDIT_CARD || method == METHOD_CASH) {
            return method;
        }
        throw new IllegalArgumentException();
    }

}
