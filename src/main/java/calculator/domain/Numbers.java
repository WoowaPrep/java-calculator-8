package calculator.domain;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> values;

    public static Numbers from(String[] numberStrings) {
        List<Number> numbers = Arrays.stream(numberStrings)
                .map(Number::new)
                .collect(toList());
        return new Numbers(numbers);
    }

    public Numbers(List<Number> values) {
        this.values = new ArrayList<>(values);
    }

    public BigInteger sum() {
        return values.stream()
                .map(Number::getValue)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }
}
