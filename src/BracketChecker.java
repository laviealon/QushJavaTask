import java.util.Stack;

public class BracketChecker {
    public BracketChecker(){}

    public static boolean isOpenBracket(Character c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static boolean isClosedBracket(Character c) {
        return c == '}' || c == ']' || c == ')';
    }

    public static boolean stackTopMatchesChar(Character c, Stack<Character> s) {
        return ((s.lastElement() == '{' && c == '}')
                || (s.lastElement() == '[' && c == ']')
                || (s.lastElement() == '(' && c == ')'));
    }

    public static Boolean BracketCheck(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && stackTopMatchesChar(c, stack)) {
                stack.pop();
            } else if (isClosedBracket(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}