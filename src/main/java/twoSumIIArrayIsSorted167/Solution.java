package main.java.twoSumIIArrayIsSorted167;

import main.java.utils.ArrayUtil;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-05 21:29
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(ArrayUtil.constructorArray(1, 2, 3, 4, 4, 9, 56, 90), 8)));
    }

    /**
     * 我想到的第一个解题思路，既然给出的数组的是有序，那我们可以直接用二分查找来找到target - numbers[i]
     * 时间复杂度为O(nlogn)
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, key);
            if (index > -1) {
                return new int[]{i + 1, index + 1};
            }
        }
        return null;
    }

    /**
     * 使用双指针，即首尾指针，每次迭代中，获取首尾指针的相加的总和，如果小于target则调整首部指针，大于则调整尾部指针，如果相等则返回
     * 时间复杂度为O(n)
     */
    public int[] twoSumPoint(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v < target) {
                left++;
            } else if (v > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}
