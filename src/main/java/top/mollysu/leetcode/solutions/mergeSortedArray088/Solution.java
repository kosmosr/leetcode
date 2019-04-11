package top.mollysu.leetcode.solutions.mergeSortedArray088;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-10 17:39
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * example:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Solution {

    /**
     * 参考归并操作，时间复杂度O(m), 空间复杂度O(m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        int[] res = new int[nums1.length];
        System.arraycopy(nums1, 0, res, 0, nums1.length);
        int i = 0, j = m;
        for (int k = 0; k <= nums1.length - 1; k++) {
            if (i > m - 1) {
                nums1[k] = res[j++];
            } else if (j > nums1.length - 1) {
                nums1[k] = res[i++];
            } else if (res[i] <= res[j]) {
                nums1[k] = res[i++];
            } else {
                nums1[k] = res[j++];
            }
        }
    }

    /**
     * 先合并数组，然后直接对nums1进行快排，时间复杂度O(mlogm)
     */
    public void mergeQuick(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
