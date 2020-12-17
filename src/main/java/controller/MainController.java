package controller;

import domain.Table;
import view.InputView;

public class MainController {

    public static void run() {
        MainController.print();
        int number = InputView.inputFunctionNumber();


        Table currentTable = InputView.inputTableNumber();
        System.out.println(currentTable.toString());
    }

    private static void print() {
        System.out.println(MainFunction.TITLE.toString());
        System.out.println(MainFunction.ORDER.toString());
        System.out.println(MainFunction.PAYMENT.toString());
        System.out.println(MainFunction.EXIT.toString());
    }

    private static void nextProcedure(int command) {

    }


}
