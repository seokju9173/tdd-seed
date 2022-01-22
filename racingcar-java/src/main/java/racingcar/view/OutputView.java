package racingcar.view;

import racingcar.Car;

public class OutputView {
    private static final String PRINT_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String PRINT_HOW_MANY_PROGRESS = "시도할 회수는 몇 회 인가요?";
    private static final String PRINT_RESULT = "\n실행 결과";
    private static final String PROGRESS_STRING = "-";

    public static void printHowManyCars(){
        System.out.println(PRINT_HOW_MANY_CARS);
    }

    public static void printHowManyProgress(){
        System.out.println(PRINT_HOW_MANY_PROGRESS);
    }

    public static void printResult(){
        System.out.println(PRINT_RESULT);
    }

    public static void printCurrentCarsPosition(Car[] cars){
        StringBuilder sb = new StringBuilder();

        for (Car car : cars){
            for (int i = 0; i< car.getProgress(); i++){
                sb.append(PROGRESS_STRING);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
