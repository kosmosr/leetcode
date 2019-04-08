package top.mollysu.leetcode.solutions.plusOne066;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-06 14:52
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * example
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution {

    /**
     * 主要处理数字为9时的情况，需要进行进位
     */
    public int[] plusOne(int[] digits) {
        for (int j = digits.length - 1; j >= 0; j--) {
            if (digits[j] < 9) {
                digits[j]++;
                return digits;
            }
            digits[j] = 0;
        }
        int[] result = Arrays.copyOf(digits, digits.length + 1);
        result[0] = 1;
        return result;
    }
}
