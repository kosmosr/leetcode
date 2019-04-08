package top.mollysu.leetcode.solutions.reverseInteger007;

/**
 * @author zmh
 * @date 2019-04-08 11:29
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int number = result * 10;
            int mod = x % 10;
            if ((number - mod) / 10 != result) {
                return 0;
            }
            result = number + mod;
            x /= 10;
        }
        return result;
    }
}
