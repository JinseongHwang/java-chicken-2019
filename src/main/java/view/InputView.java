package view;

import domain.Table;
import domain.TableRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void bufferFlush() {
        scanner.nextLine();
    }

    public static Table inputTableNumber() {
        try {
            System.out.println("## 테이블을 선택하세요.");
            int tableNumber = scanner.nextInt();
            bufferFlush();
            return TableRepository.getTablebyNumber(tableNumber);
        } catch (InputMismatchException IME) {
            System.out.println("[ERROR] 정수를 입력해주세요..");
            bufferFlush();
            return inputTableNumber();
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 존재하지 않는 테이블 번호입니다.");
            return inputTableNumber();
        }
    }


}
