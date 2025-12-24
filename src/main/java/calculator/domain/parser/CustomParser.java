package calculator.domain.parser;

import static java.util.function.Predicate.not;

import calculator.domain.Numbers;
import calculator.domain.Parser;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CustomParser implements Parser {

    private static final String INVALID_DELIMITER_FORMAT_ERROR =
            "커스텀 구분자 형식이 올바르지 않습니다";

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final String OR = "|";

    private static final String REAL_NEW_LINE = "\n";
    private static final String ESCAPED_NEW_LINE = "\\n";
    private static final int ESCAPED_NEW_LINE_LENGTH = 2;
    private static final int REAL_NEW_LINE_LENGTH = 1;


    @Override
    public Numbers parse(String input) {
        int customDelimiterEndIndex = findDelimiterEndIndex(input);
        String CustomDelimiter = extractCustomDelimiter(input, customDelimiterEndIndex);
        String numbersString = extractNumbers(input, customDelimiterEndIndex);

        String delimiterPattern = DEFAULT_DELIMITER + OR + Pattern.quote(CustomDelimiter);

        String[] parts = Arrays.stream(numbersString.split(delimiterPattern))
                .map(String::trim)
                .filter(not(String::isEmpty))
                .toArray(String[]::new);

        return Numbers.from(parts);
    }

    private int findDelimiterEndIndex(String input) {
        int realNewLineIndex = input.indexOf(REAL_NEW_LINE);
        if (realNewLineIndex != -1) {
            return realNewLineIndex;
        }

        int escapedNewLineIndex = input.indexOf(ESCAPED_NEW_LINE);
        if (escapedNewLineIndex != -1) {
            return escapedNewLineIndex;
        }

        throw new IllegalArgumentException(INVALID_DELIMITER_FORMAT_ERROR);
    }

    private String extractCustomDelimiter(String input, int endIndex) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, endIndex);
    }

    private String extractNumbers(String input, int delimiterEndIndex) {
        int newLineLength = getNewLineLength(input, delimiterEndIndex);
        return input.substring(delimiterEndIndex + newLineLength);
    }

    private int getNewLineLength(String input, int index) {
        if (index + 1 < input.length() &&
                input.charAt(index) == ESCAPED_NEW_LINE.charAt(0) &&
                input.charAt(index + 1) == ESCAPED_NEW_LINE.charAt(1)) {
            return ESCAPED_NEW_LINE_LENGTH;
        }
        return REAL_NEW_LINE_LENGTH;
    }
}
