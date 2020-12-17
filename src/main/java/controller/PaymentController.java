package controller;

import domain.Menu;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class PaymentController {

    private static final int METHOD_CASH = 2;

    public static void run() {
        OutputView.printTables(TableRepository.tables());
        Table table = InputView.inputTableNumber();
        if (table.isEmpty()) {
            System.out.println("[ERROR] 이 테이블은 주문 내역이 없습니다.");
            return;
        }
        OutputView.printOrderContentsIn(table);
        System.out.println(table.toString() + "번 테이블의 결제를 진행합니다.");
        int method = InputView.inputPaymentMethod();
        System.out.println("## 최종 결제할 금액");
        System.out.println(paymentMoney(table, method) + "원");
        table.checkout();
    }

    private static int paymentMoney(Table table, int method) {
        int sum = 0;
        int numberOfChicken = 0;
        for (Map.Entry<Menu, Integer> entry : table.orderContents().entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
            if (entry.getKey().isChicken()) {
                numberOfChicken += entry.getValue();
            }
        }
        sum = discountByChicken(sum, numberOfChicken);
        if (method == METHOD_CASH) {
            sum = discountByCash(sum);
        }
        return sum;
    }

    private static int discountByChicken(int sum, int numberOfChicken) {
        return sum -= ((numberOfChicken / 10) * 10_000);
    }

    private static int discountByCash(int sum) {
        return sum *= 0.95;
    }
}
