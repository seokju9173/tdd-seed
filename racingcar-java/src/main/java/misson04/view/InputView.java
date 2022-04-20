package misson04.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static misson04.utils.Validator.stringToNumber;

public class InputView {

    private static final String REQUEST_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String REQUEST_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분), 자동차당 최대 5글자 제한입니다";
    private static final String REGEX = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestInputNames() {
        System.out.println(REQUEST_NAMES_MESSAGE);
        return Arrays.asList(scanner.next().split(REGEX));
    }

    public int requestTryCount() {
        System.out.println(REQUEST_COUNT_MESSAGE);
        return stringToNumber(scanner.next());
    }
}
