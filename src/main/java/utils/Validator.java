package utils;

public class Validator {

    private static final int MIN_MAIN_FUNCTION_NUMBER = 1;
    private static final int MAX_MAIN_FUNCTION_NUMBER = 3;

    public static int onlyMainFunction(int number) {
        if (MIN_MAIN_FUNCTION_NUMBER <= number && number <= MAX_MAIN_FUNCTION_NUMBER) {
            return number;
        }
        throw new IllegalArgumentException();
    }



}
