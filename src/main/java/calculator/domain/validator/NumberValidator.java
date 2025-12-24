package calculator.domain.validator;

import java.math.BigInteger;

public class NumberValidator {

    private static final String NUMBER_EMPTY_ERROR = "숫자가 비어있습니다";
    private static final String NUMBER_NEGATIVE_ERROR = "음수는 허용되지 않습니다: ";
    private static final String NUMBER_FORMAT_ERROR = "숫자 형식이 올바르지 않습니다: ";


    public static BigInteger parseAndValidate(String numberStr) {
        validateNotEmpty(numberStr);

        try {
            BigInteger num = new BigInteger(numberStr.trim());
            validateNotNegative(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR + numberStr);
        }
    }

    private static void validateNotEmpty(String numberStr) {
        if (numberStr == null || numberStr.trim().isEmpty()) {
            throw new IllegalArgumentException(NUMBER_EMPTY_ERROR);
        }
    }

    private static void validateNotNegative(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException(NUMBER_NEGATIVE_ERROR + num);
        }
    }
}
