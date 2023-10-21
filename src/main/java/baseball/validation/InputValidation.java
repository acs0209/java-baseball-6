package baseball.validation;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 사용자의 숫자 입력값이 자연수로만 이루어져 있는지 검증한다.
     */
    public void validateNaturalNumber(String input) {
        Pattern pattern = Pattern.compile("^[1-9]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 문자열은 자연수로만 이루어져야 합니다.");
        }
    }

    public void validateLengthAtLeastFour(String input) {
        if (input.length() >= 4) {
            throw new IllegalArgumentException("입력값은 3 이하여야 합니다.");
        }
    }

    public void validateUniqueIntegers(String input) {
        String[] integers = input.split("");
        int integerCount = integers.length;
        long distinctIntegerCount = Arrays.stream(integers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();

        if (distinctIntegerCount != integerCount) {
            throw new IllegalArgumentException("입력값은 서로 다른 정수여야 합니다.");
        }
    }

    /**
     * 재입력된 값이 1 또는 2인지 검증한다.
     */
    public void validateOneOrTwo(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("재입력 값은 1 또는 2여야 합니다.");
        }
    }

    /**
     * 입력된 값이 null인지 검증한다.
     */
    public void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
        }
    }
}