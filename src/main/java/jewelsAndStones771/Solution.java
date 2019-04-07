package main.java.jewelsAndStones771;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zmh
 * @date 2019-04-07 21:07
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * example:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
public class Solution {

    // 时间复杂度 O(n)
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        Set<Character> sets = new HashSet<>(J.length());

        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();
        for (int i = 0; i < jChars.length; i++) {
            sets.add(jChars[i]);
        }

        for (int j = 0; j < sChars.length; j++) {
            if (sets.contains(sChars[j])) {
                num++;
            }
        }
        return num;
    }
}
