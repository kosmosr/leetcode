package top.mollysu.leetcode.solutions.intersectionOfTwoArrays349;


import top.mollysu.leetcode.utils.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zmh
 * @date 2019-04-07 20:05
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = ArrayUtil.constructorArray(1, 2, 2, 1);
        int[] nums2 = ArrayUtil.constructorArray(2, 2);
        Solution solution = new Solution();
        int[] res = solution.intersection2(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 二分+Set
     * 时间复杂度 O(nlogn)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int res = Arrays.binarySearch(nums2, nums1[i]);
            if (res > -1) {
                set.add(nums1[i]);
            }
        }
        int index = 0;
        int[] result = new int[set.size()];
        for (Integer i : set) {
            result[index++] = i;
        }
        return result;
    }

    /**
     * 使用两个Set
     * 时间复杂度 O(n)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        Set<Integer> nums2Set = new HashSet<>(nums2.length);

        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            nums1Set.add(n1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            if (nums1Set.contains(n2)) {
                nums2Set.add(n2);
            }
        }
        int index = 0;
        int[] result = new int[nums2Set.size()];
        for (Integer i : nums2Set) {
            result[index++] = i;
        }
        return result;
    }
}
