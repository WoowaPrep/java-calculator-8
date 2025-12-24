package calculator.domain;

import calculator.domain.parser.ParserFactory;
import java.math.BigInteger;

public class Calculator {

    public BigInteger calculate(String numberString) {
        if (isEmpty(numberString)) {
            return BigInteger.ZERO;
        }

        Parser parser = ParserFactory.createParser(numberString);
        Numbers numbers = parser.parse(numberString);

        if (numbers.isEmpty()) {
            return BigInteger.ZERO;
        }

        return numbers.sum();
    }

    private static boolean isEmpty(String numberString) {
        return numberString == null ||
                numberString.isEmpty() ||
                numberString.trim().isEmpty();
    }
}
