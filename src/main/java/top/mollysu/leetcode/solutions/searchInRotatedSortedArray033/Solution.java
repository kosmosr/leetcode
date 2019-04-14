package top.mollysu.leetcode.solutions.searchInRotatedSortedArray033;

import top.mollysu.leetcode.utils.ArrayUtil;

/**
 * @author zmh
 * @date 2019-04-12 9:25
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * example:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = ArrayUtil.constructorArray(4, 5, 6, 7, 0, 1, 2);
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 3));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        int left = binarySearch(nums, target, lo, mid - 1);
        int right = binarySearch(nums, target, mid + 1, hi);
        if (left == -1 && right == -1) {
            return -1;
        } else {
            return left >= 0 ? left : right;
        }
    }
}
