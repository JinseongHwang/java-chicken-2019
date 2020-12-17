package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ ￦┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        int size = tables.size();
        printTopLine(size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printTopLine(final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (Table table : tables) {
            if (table.isEmpty()) {
                System.out.print(BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE_ORDERED);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrderContentsIn(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Map.Entry<Menu, Integer> entry : table.orderContents().entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + " " + entry.getKey().getPrice() * entry.getValue());
        }
    }
}
