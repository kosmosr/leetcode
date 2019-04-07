package main.java.rotateArray189;

import main.java.utils.ArrayUtil;

import java.util.Arrays;

/**
 * @author zmh
 * @date 2019-04-06 20:18
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * example:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = ArrayUtil.constructorArray(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 循环k次，每次保存最后一个元素然后把剩下元素右移
     * 时间复杂度：O(k)
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        for (int i = 0; i < k; i++) {
            int last = nums[length - 1];
            System.arraycopy(nums, 0, nums, 1, length - 1);
            nums[0] = last;
        }
    }

    /**
     * 参考leetcode讨论区的题解
     * https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 循环交换lo hi 的位置
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}
