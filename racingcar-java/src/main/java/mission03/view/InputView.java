package mission03.view;

import mission03.exception.FormatException;

import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    /**
     * InputView이기 때문에? Input 데이터도 여기서 꺼내는 게 맞다고 판단... 따로 저걸 RacingCourse로 빼야할 까 고민했음.
     * 아님 말구,, 피드백 부탁드릴게용
     */
    private int carCount;
    private int tryCount;

    public void announceRacingEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(REQUEST_CAR_MESSAGE);
        carCount = stringToNumber(scanner.next());
        System.out.println(REQUEST_COUNT_MESSAGE);
        tryCount = stringToNumber(scanner.next());
        System.out.println();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    /**
     * 질문: 받은 Number에 대한 예외처리를 따로 클래스를 빼서 만들어야 할까요?
     * 아니면 검증을 할 필요 없이 nextInt()로 받는게 좋을까요
     * 아니면 이렇게 단순한 검증은 그냥 같이 넣어도 될까요?
     */
    private int stringToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new FormatException();
        }
    }
}
