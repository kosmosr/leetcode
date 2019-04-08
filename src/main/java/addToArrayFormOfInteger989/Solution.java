package main.java.addToArrayFormOfInteger989;

import main.java.utils.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zmh
 * @date 2019-04-06 15:14
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addToArrayForm(ArrayUtil.constructorArray(2, 1, 5), 806));
    }

    /**
     * 时间复杂度 O(n)
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
