package controller;

import domain.Table;
import view.InputView;

public class MainController {

    public static void run() {
        MainController.print();
        Table currentTable = InputView.inputTableNumber();
        System.out.println(currentTable.toString());
    }

    private static void print() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }


}
