public class Calculator {

    public int getResult(int operand1, int operand2, String operation) {
        int result;
        switch (operation) {
            case "+":
                result = sum(operand1, operand2);
                break;
            case "-":
                result = dif(operand1, operand2);
                break;
            case "*":
                result = mult(operand1, operand2);
                break;
            case "/":
                result = div(operand1, operand2);
                break;
            default:
                throw new IllegalStateException("Incorrect operation name.");
        }
        return result;
    }

    private int sum(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int dif(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int mult(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int div(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
