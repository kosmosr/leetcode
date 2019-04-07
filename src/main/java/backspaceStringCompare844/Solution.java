package main.java.backspaceStringCompare844;

import java.util.Stack;

/**
 * @author zmh
 * @date 2019-04-07 21:14
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * example
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s1.empty()) {
                    s1.pop();
                }
            } else {
                s1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!t1.empty()) {
                    t1.pop();
                }
            } else {
                t1.push(T.charAt(i));
            }
        }
        if (s1.size() != t1.size()) {
            return false;
        }
        while (!s1.empty()) {
            Character pop = s1.pop();
            Character pop1 = t1.pop();
            if (!pop.equals(pop1)) {
                return false;
            }
        }
        return true;
    }
}
