package f_03_stack;

/**
 *
 * @author tiago
 */
public class Palindrome {
    public static boolean validateStrAsPalindrome(String str) {
        
        str = str.toLowerCase();
        
        StackArray<Character> stack = new StackArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder("");
        while (stack.peek() != null) {
            sb.append(stack.pop());
        }
        
        System.out.println("");
        return str.equals(sb.toString());
    }
}
