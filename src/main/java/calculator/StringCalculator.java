package calculator;

import calculator.domain.Calculator;
import calculator.input.InputView;
import calculator.input.OutputView;
import java.math.BigInteger;

public class StringCalculator {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public StringCalculator() {
        this(new InputView(), new OutputView(), new Calculator());
    }

    public StringCalculator(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void calculate() {
        String numbersInput = readAdditionString();
        BigInteger sum = calculator.calculate(numbersInput);
        printResult(sum);
    }

    private String readAdditionString() {
        return inputView.readAdditionString();
    }

    private void printResult(BigInteger sum) {
        outputView.printResult(sum);
    }
}
