package top.mollysu.leetcode.solutions.countPrimes204;

/**
 * @author zmh
 * @date 2019-04-19 9:45
 * 统计所有小于非负整数 n 的质数的数量。
 * example:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes2(3));
    }

    /**
     * 这题看了评论才知道原来可以用埃拉托斯特尼筛法解出
     *
     * @param n 非负整数 n
     * @return 所有小于非负整数 n 的质数的数量
     * @link <a>https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95</a>
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] array = new boolean[n];
        int count = 0;
        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (!array[i]) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = true;
                }
            }
        }
        for (int i = 2; i < array.length; i++) {
            if (!array[i]) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        boolean[] array = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!array[i]) {
                count++;
                array[i] = true;
                for (int j = 2; i * j < n; j++) {
                    array[i * j] = true;
                }
            }
        }
        return count;
    }
}
