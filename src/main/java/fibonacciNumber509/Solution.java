package main.java.fibonacciNumber509;

/**
 * @author zmh
 * @date 2019-04-07 20:50
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * example
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Solution {

    /**
     * 使用数组来保存每次执行的结果
     */
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int[] array = new int[N + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= N; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[N];
    }


}
