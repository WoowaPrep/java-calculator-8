package calculator;

import calculator.input.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            new StringCalculator().calculate();
        } finally {
            Console.close();
        }
    }
}
