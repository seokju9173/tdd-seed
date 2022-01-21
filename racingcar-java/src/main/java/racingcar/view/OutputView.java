package racingcar.view;

public class OutputView {
    private static final String PRINT_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String PRINT_HOW_MANY_PROGRESS = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT = "\n실행 결과";

    public static void printHowManyCars(){
        System.out.println(PRINT_HOW_MANY_CARS);
    }

    public static void printHowManyProgress(){
        System.out.println(PRINT_HOW_MANY_PROGRESS);
    }

    public static void printResult(){
        System.out.println(PRINT_RESULT);
    }
}
