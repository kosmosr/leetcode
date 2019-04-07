package main.java.reverseStringII541;

/**
 * @author zmh
 * @date 2019-04-06 21:40
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * <p>
 * example
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += k * 2) {
            int lo = Math.min(i + k - 1, chars.length - 1);
            swap(chars, i, lo);
        }
        return new String(chars);
    }

    private void swap(char[] str, int lo, int hi) {
        while (lo < hi) {
            char temp = str[lo];
            str[lo++] = str[hi];
            str[hi--] = temp;
        }
    }
}
