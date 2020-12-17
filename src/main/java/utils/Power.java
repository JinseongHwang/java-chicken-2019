package utils;

public class Power {

    private static boolean power = true;

    public static boolean isOn() {
        return power;
    }

    public static void turnOff() {
        power = false;
    }
}
