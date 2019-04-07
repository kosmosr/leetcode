package main.java.removeElement027;

/**
 * @author zmh
 * @date 2019-04-06 13:38
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * example:
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {

    /**
     * 遇到非val元素时，赋值sum++ = 当前迭代i元素
     * 时间复杂度为O(n)
     */
    public int removeElement(int[] nums, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[sum++] = nums[i];
        }
        return sum;
    }
}
