package top.mollysu.leetcode.solutions.largestPerimeterTriangle976;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-07 22:02
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * example
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        int result = 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i--) {
            if (i - 2 >= 0) {
                int a = A[i], b = A[i - 1], c = A[i - 2];
                if (a + c > b && a + b > c && c + b > a) {
                    result = a + b + c;
                    break;
                }
            } else {
                break;
            }

        }
        return result;
    }
}
