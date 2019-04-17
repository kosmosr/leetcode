package top.mollysu.leetcode.solutions.intersectionOfTwoArraysII350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zmh
 * @date 2019-04-17 21:19
 * 给定两个数组，编写一个函数来计算它们的交集。
 * example:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        int maxLength = Math.max(nums1.length, nums2.length);
        Map<Integer, Integer> maps = new HashMap<>(maxLength);
        int[] result = new int[maxLength];
        int size = 0;
        for (int currentElement : nums1) {
            // 用哈希表记录每个nums1中的值出现次数，因为数组中的元素是重复的，则需要记录出现的次数
            maps.put(currentElement, maps.getOrDefault(currentElement, 0) + 1);
        }

        for (int key : nums2) {
            // 如果nums2中元素存在哈希表中，且次数大于0，则放入list中
            if (maps.getOrDefault(key, 0) > 0) {
                result[size++] = key;
                maps.put(key, maps.get(key) - 1);
            }
        }
        return Arrays.copyOf(result, size);
    }
}
