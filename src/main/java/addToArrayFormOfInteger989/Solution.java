package main.java.addToArrayFormOfInteger989;

import main.java.utils.ArrayUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Integer> addToArrayForm(int[] A, int K) {
        int kLength = Integer.toString(K).length();
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int mod = kLength % A.length;
        List<int[]> ints = Collections.singletonList(A);

        while (K > 0) {
            queue.push(K % 10);
            K /= 10;
        }
        res.add(0, 1);
        for (int i = 0; i < A.length; i++) {
            if (i >= mod) {
                int sum = A[i] + queue.peek();
                if (sum > 9) {
                    sum -= 10;
                    if (i == 0) {
                        res.add(1);
                        continue;
                    } else {
                        queue.pop();
                        int integer = res.get(i - 1);
                        res.set(i - 1, ++integer);
                    }
                    A[i] = sum;
                } else {
                    A[i] = sum;
                }
            }
            res.add(A[i]);
        }
        return res;
    }
}
