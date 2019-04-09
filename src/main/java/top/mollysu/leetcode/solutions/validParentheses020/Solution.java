package top.mollysu.leetcode.solutions.validParentheses020;

import java.util.Stack;

/**
 * @author zmh
 * @date 2019-04-09 14:59
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution {
    /**
     * 括号
     */
    private static final char LEFT_PARENTHESIS = '(';

    private static final char RIGHT_PARENTHESIS = ')';

    /**
     * 方括号
     */
    private static final char LEFT_BRACKETS = '[';

    private static final char RIGHT_BRACKETS = ']';

    /**
     * 大括号
     */
    private static final char LEFT_CURLY_BRACES = '{';

    private static final char RIGHT_CURLY_BRACES = '}';


    public static void main(String[] args) {
        String str = "(";
        Solution solution = new Solution();
        System.out.println(solution.isValid(str));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!stack.isEmpty() && test(aChar, stack.peek())) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    private boolean test(char ch, char pop) {
        return (pop == LEFT_CURLY_BRACES && ch == RIGHT_CURLY_BRACES) ||
                (pop == LEFT_BRACKETS && ch == RIGHT_BRACKETS) ||
                (pop == LEFT_PARENTHESIS && ch == RIGHT_PARENTHESIS);
    }
}
