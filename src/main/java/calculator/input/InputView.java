package calculator.input;

import camp.nextstep.edu.missionutils.Console;
public class InputView {

    private static final String ADDITION_STRING_INPUT_MESSAGE =
            "덧셈할 문자열을 입력해주세요.";

    public String readAdditionString() {
        System.out.println(ADDITION_STRING_INPUT_MESSAGE);
        return Console.readLine();
    }

}
