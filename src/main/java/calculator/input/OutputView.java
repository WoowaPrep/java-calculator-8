package calculator.input;

import java.math.BigInteger;

public class OutputView {

    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(BigInteger sum) {
        System.out.println(RESULT_MESSAGE + sum);
    }
}
