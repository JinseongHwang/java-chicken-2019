package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class OrderController {

    public static void run() {
        OutputView.printTables(TableRepository.tables());
        Table table = InputView.inputTableNumber();
        OutputView.printMenus(MenuRepository.menus());
        Menu menu = InputView.inputMenuNumber();
        int quantity = InputView.inputMenuQuantity(table, menu);

        if (quantity == 0) {
            return;
        }

        table.add(menu, quantity);

        System.out.println("## 주문내역~~~");
        for (Map.Entry<Menu, Integer> entry : table.orderContents().entrySet()) {
            System.out.println(entry.getKey().toString() + "를 " + entry.getValue() + "개 시켰네요 ~~");
        }
    }
}
