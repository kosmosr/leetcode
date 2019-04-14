package top.mollysu.leetcode.solutions.searchInRotatedSortedArrayII081;

import top.mollysu.leetcode.utils.ArrayUtil;

/**
 * @author zmh
 * @date 2019-04-13 11:29
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * example:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = ArrayUtil.constructorArray(2, 5, 6, 0, 0, 1, 2);

    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private boolean binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        if (target == nums[mid]) {
            return true;
        }
        boolean left = binarySearch(nums, target, lo, mid - 1);
        boolean right = binarySearch(nums, target, mid + 1, hi);
        return left || right;
    }
}
