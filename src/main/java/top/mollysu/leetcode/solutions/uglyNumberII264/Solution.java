package top.mollysu.leetcode.solutions.uglyNumberII264;

/**
 * @author zmh
 * @date 2019-04-19 11:28
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }

    // 只要算出n个丑数，则n-1就是要返回的数字
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        // 包含n个丑数的数组
        int[] result = new int[n];
        // 第一个丑数就是1
        result[0] = 1;

        // 三指针
        int divisor2 = 0;
        int divisor3 = 0;
        int divisor5 = 0;

        for (int i = 1; i < n; i++) {
            int multiply2 = result[divisor2] * 2;
            int multiply3 = result[divisor3] * 3;
            int multiply5 = result[divisor5] * 5;
            int min = Math.min(multiply2, Math.min(multiply3, multiply5));
            result[i] = min;
            if (min == multiply2) {
                divisor2++;
            }
            if (min == multiply3) {
                divisor3++;
            }
            if (min == multiply5) {
                divisor5++;
            }
        }
        // 数组下标是从0算开始的，则第n个就是数组中n - 1的下标值
        return result[n - 1];
    }
}
