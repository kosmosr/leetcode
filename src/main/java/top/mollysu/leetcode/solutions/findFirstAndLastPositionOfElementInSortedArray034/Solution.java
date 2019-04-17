package top.mollysu.leetcode.solutions.findFirstAndLastPositionOfElementInSortedArray034;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-12 10:29
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * example:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2};
        System.out.println(Arrays.toString(solution.searchRange(nums, 2)));

    }

    // 主要是二分的lower_bound操作，获取target在nums中的起始位置，利用这一点就可以解决
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return new int[]{start, start};
        }
        int end = lowerBound(nums, target + 1);
        if (nums[end] == target) {
            return new int[]{start, end};
        } else {
            return new int[]{start, end - 1};
        }
    }

    private int lowerBound(int[] array, int target) {
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > array[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
