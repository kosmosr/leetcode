package top.mollysu.leetcode.solutions.nRepeatedElementInSize2nArray961;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zmh
 * @date 2019-04-07 21:41
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 * example:
 * 输入：[1,2,3,3]
 * 输出：3
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 */
public class Solution {

    /**
     * 根据题目描述，数组中只有一个元素会重复，所以直接用Set添加就行了，如果添加失败。则当前元素就是重复N次的那个元素
     */
    public int repeatedNTimes(int[] A) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            boolean result = set.add(A[i]);
            if (!result) {
                res = A[i];
                break;
            }
        }
        return res;
    }
}
