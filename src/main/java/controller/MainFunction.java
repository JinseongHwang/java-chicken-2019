package controller;

public enum MainFunction {
    TITLE(0, "## 메인화면"),
    ORDER(1, "1 - 주문등록"),
    PAYMENT(2, "2 - 결제하기"),
    EXIT(3, "3 - 프로그램 종료");

    private final int number;
    private final String text;

    MainFunction(final int number, final String text) {
        this.number = number;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public int getNumber() {
        return number;
    }
}
