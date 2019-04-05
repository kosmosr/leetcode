package main.java.twoSum001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zmh
 * @date 2019-04-05 21:00
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * example:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    /**
     * 暴力解法，使用两个for循环即可。时间复杂度为O(n²)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用哈希表，每次迭代时，放入每个元素的值及其索引，并判断target-nums[i]是否存在于哈希表中，如果存在则将其返回
     * 时间复杂度为O(n)，空间复杂度O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (maps.containsKey(key)) {
                return new int[]{maps.get(key), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }
}
