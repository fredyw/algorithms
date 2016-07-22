package algorithms;

import java.util.Stack;

public class MathExpressionParser {
    private Stack<Integer> operands = new Stack<>();
    private Stack<Character> operators = new Stack<>();

    public int evaluate(String exp) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (num.length() != 0) {
                    operands.push(Integer.valueOf(num.toString()));
                    num = new StringBuilder();
                }
                operators.push(c);
            } else if (Character.isDigit(c)) {
                num.append(c);
            } else if (c == ')') {
                if (num.length() != 0) {
                    operands.push(Integer.valueOf(num.toString()));
                    num = new StringBuilder();
                }
                int a = operands.pop();
                int b = operands.pop();
                char op = operators.pop();
                if (op == '+') {
                    operands.push(b + a);
                } else if (op == '-') {
                    operands.push(b - a);
                } else if (op == '*') {
                    operands.push(b * a);
                } else if (op == '/') {
                    operands.push(b / a);
                }
            }
        }
        return operands.pop();
    }
}
