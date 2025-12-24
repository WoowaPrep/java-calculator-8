package calculator.domain.parser;

import static java.util.function.Predicate.not;

import calculator.domain.Numbers;
import calculator.domain.Parser;
import java.util.Arrays;

public class DefaultParser implements Parser {

    private static final String DELIMITERS = "[,:]";

    @Override
    public Numbers parse(String input) {
        String[] parts = Arrays.stream(input.split(DELIMITERS))
                .map(String::trim)
                .filter(not(String::isEmpty))
                .toArray(String[]::new);

        return Numbers.from(parts);
    }
}
