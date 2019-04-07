package main.java.searchInsertPosition035;

/**
 * @author zmh
 * @date 2019-04-06 13:44
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * example:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class Solution {

    /**
     * 直接使用二分查找，当找到target时，返回其索引，若不存在，则直接返回lo的值
     * 时间复杂度O(logN)
     */
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
