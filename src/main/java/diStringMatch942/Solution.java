package main.java.diStringMatch942;

/**
 * @author zmh
 * @date 2019-04-07 21:39
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 * <p>
 * example:
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * <p>
 * 输出："III"
 * 输出：[0,1,2,3]
 * <p>
 * 输出："DDI"
 * 输出：[3,2,0,1]
 */
public class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] array = new int[N + 1];
        int lo = 0, hi = N;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                array[i] = lo++;
            } else {
                array[i] = hi--;
            }
        }
        array[N] = lo;
        return array;
    }
}
