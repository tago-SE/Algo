package f_03_stack;

/**
 *
 * @author tiago
 */
public class PostfixEvaluator {
    private StackArray<Integer> stack = new StackArray<>();
   
    private boolean isOperator(char ch) {
        return ("+-/*").contains("" + ch);
    }
    private int evaluate(char operator, int a, int b) {
        switch(operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '/': return a/b;
            case '*': return a*b;
            default: throw new IllegalStateException();
        }
    }
    public int evaluateString(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else if (isOperator(ch)) {
                int a = (int) stack.pop();
                int b = (int) stack.pop();
                stack.push(evaluate(ch, b, a));
            } else {
                // ignore
            }
        }
        if (stack.size() == 1) 
            return (int) stack.pop();
        throw new IllegalStateException("");
    }
}
