package top.mollysu.leetcode.solutions.findAllNumbersDisappearedInAnArray448;

import top.mollysu.leetcode.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zmh
 * @date 2019-04-16 20:32
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = ArrayUtil.constructorArray(1, 1);
        Solution solution = new Solution();
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(ints);
        System.out.println(disappearedNumbers);
    }

    // 所有数字均在[1..n]之间，所以把每个数字作为索引，把每个值变为负数，如果不是负数的则说明是不存在的
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
