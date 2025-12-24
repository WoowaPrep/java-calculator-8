package calculator.domain;

import calculator.domain.validator.NumberValidator;
import java.math.BigInteger;

public class Number {

    private final BigInteger value;

    public Number(String value) {
        this.value = NumberValidator.parseAndValidate(value);
    }

    public BigInteger getValue() {
        return value;
    }
}
