package top.mollysu.leetcode.solutions.squaresOfSortedArray977;


import top.mollysu.leetcode.utils.ArrayUtil;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-07 22:06
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * example:
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = ArrayUtil.constructorArray(-7, -3, 2, 3, 11);
//        int[] a = ArrayUtil.constructorArray(-4, -1, 0, 3, 10);
        int[] ints = solution.sortedSquares2(a);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 时间复杂度: O(nlogn), 空间复杂度：O(n)
     */
    public int[] sortedSquares(int[] A) {
        int[] array = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            array[i] = A[i] * A[i];
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * 双指针解法， 时间复杂度O(n) 空间复杂度：O(n)
     */
    public int[] sortedSquares2(int[] A) {
        int length = A.length;
        int[] array = new int[length];
        int left = -1, right = 0;
        // 确定负、正指针指向的位置
        while (left + 1 < length && A[left + 1] < 0) {
            left++;
            right++;
        }
        int arrayIndex = 0;
        while (left >= 0 && right < length) {
            if (A[left] * A[left] > A[right] * A[right]) {
                array[arrayIndex++] = A[right] * A[right];
                right++;
            } else {
                array[arrayIndex++] = A[left] * A[left];
                left--;
            }
        }
        while (right < length) {
            array[arrayIndex++] = A[right] * A[right++];
        }
        while (left >= 0) {
            array[arrayIndex++] = A[left] * A[left--];
        }
        return array;
    }
}
