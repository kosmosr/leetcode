package top.mollysu.leetcode.solutions.containsDuplicate217;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-14 12:01
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * example:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
