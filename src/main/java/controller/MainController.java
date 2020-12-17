package controller;

import view.InputView;

public class MainController {

    public static void run() {
        MainController.print();
        int selectedNumber = InputView.inputFunctionNumber();
        nextProcedure(selectedNumber);

//        Table currentTable = InputView.inputTableNumber();
//        System.out.println(currentTable.toString());
    }

    private static void print() {
        System.out.println(MainFunction.TITLE.toString());
        System.out.println(MainFunction.ORDER.toString());
        System.out.println(MainFunction.PAYMENT.toString());
        System.out.println(MainFunction.EXIT.toString());
    }

    private static void nextProcedure(int command) {
        if (command == MainFunction.ORDER.getNumber()) {
            OrderController.run();
        } else if (command == MainFunction.PAYMENT.getNumber()) {
            PaymentController.run();
        } else if (command == MainFunction.EXIT.getNumber()) {
            return;
        }
        MainController.run();
    }

}
