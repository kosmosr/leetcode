package main.java.squaresOfSortedArray977;

import main.java.utils.ArrayUtil;

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
        int[] ints = solution.sortedSquares(a);
        System.out.println(ints);
    }

    public int[] sortedSquares(int[] A) {
        int[] array = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            array[i] = A[i] * A[i];
        }
        Arrays.sort(array);
        return array;
    }
}
