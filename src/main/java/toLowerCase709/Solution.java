package main.java.toLowerCase709;

/**
 * @author zmh
 * @date 2019-04-07 21:02
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * example:
 * 输入: "Hello"
 * 输出: "hello"
 * <p>
 * 输入: "here"
 * 输出: "here"
 * <p>
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class Solution {
    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < 97 && charArray[i] > 64) {
                charArray[i] = (char) (charArray[i] + 32);
            }
        }
        return new String(charArray);
    }
}
