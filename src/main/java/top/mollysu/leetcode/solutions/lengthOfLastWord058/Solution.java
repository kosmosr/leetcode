package top.mollysu.leetcode.solutions.lengthOfLastWord058;

/**
 * @author zmh
 * @date 2019-04-12 10:55
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * example:
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 输入: "a "
 * 输出: 1
 * <p>
 * 输入: "a"
 * 输出: 1
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord2("a"));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int length = 0;
        boolean isSpace = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            length++;
            if (chars[i] == ' ') {
                isSpace = true;
                break;
            }
        }
        return isSpace ? length - 1 : length;
    }

    public int lengthOfLastWord2(String s) {
        String str = s.trim();
        int index = str.lastIndexOf(" ");
        return index != -1 ? str.length() - index - 1 : str.length();
    }
}
