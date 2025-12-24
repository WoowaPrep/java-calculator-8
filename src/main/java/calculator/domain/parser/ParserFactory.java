package calculator.domain.parser;

import calculator.domain.Parser;

public class ParserFactory {

    private static final String CUSTOM_DELIMITER_START_MARKER = "//";

    public static Parser createParser(String input) {
        if (hasCustomDelimiter(input)) {
            return new CustomParser();
        }
        return new DefaultParser();
    }

    private static boolean hasCustomDelimiter(String input){
        return input != null && input.startsWith(CUSTOM_DELIMITER_START_MARKER);
    }
}
