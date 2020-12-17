package view;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import utils.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void bufferFlush() {
        scanner.nextLine();
    }

    public static int inputFunctionNumber() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            int functionNumber = scanner.nextInt();
            bufferFlush();
            return Validator.onlyMainFunction(functionNumber);
        } catch (InputMismatchException IME) {
            System.out.println("[ERROR] 정수를 입력해주세요.");
            bufferFlush();
            return inputFunctionNumber();
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            return  inputFunctionNumber();
        }
    }

    public static Table inputTableNumber() {
        try {
            System.out.println("## 테이블을 선택하세요.");
            int tableNumber = scanner.nextInt();
            bufferFlush();
            return TableRepository.getTablebyNumber(tableNumber);
        } catch (InputMismatchException IME) {
            System.out.println("[ERROR] 정수를 입력해주세요.");
            bufferFlush();
            return inputTableNumber();
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 존재하지 않는 테이블 번호입니다.");
            return inputTableNumber();
        }
    }
    
    public static Menu inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            int menuNumber = scanner.nextInt();
            bufferFlush();
            return MenuRepository.getMenuByNumber(menuNumber);
        } catch (InputMismatchException IME) {
            System.out.println("[ERROR] 정수를 입력해주세요.");
            bufferFlush();
            return inputMenuNumber();
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 존재하지 않는 메뉴 번호입니다.");
            return inputMenuNumber();
        }
    }

    public static int inputMenuQuantity(Table table, Menu menu) {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            int quantity = scanner.nextInt();
            bufferFlush();
            return Validator.reasonableQuantity(table, menu, quantity);
        } catch (InputMismatchException IME) {
            System.out.println("[ERROR] 정수를 입력해주세요.");
            bufferFlush();
            return inputMenuQuantity(table, menu);
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 1~99의 값만 입력 가능하며, 이 메뉴의 총 주문량은 99를 초과할 수 없습니다.");
            return 0;
        }
    }


}
