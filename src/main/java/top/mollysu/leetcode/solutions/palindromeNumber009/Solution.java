package top.mollysu.leetcode.solutions.palindromeNumber009;

/**
 * @author zmh
 * @date 2019-04-16 21:58
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * example:
 * 输入: 121
 * 输出: true
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {
    // 首先负数一定不是回文数，且10以内的数字本身就是回文数，接着再通过逐位相加即可判断
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int sum = 0;
        int temp = x;
        while (temp != 0) {
            sum = sum * 10 + temp % 10;
            temp /= 10;
        }
        return sum == x;
    }
}
