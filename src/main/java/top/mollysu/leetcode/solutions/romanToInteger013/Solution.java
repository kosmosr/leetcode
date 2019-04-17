package top.mollysu.leetcode.solutions.romanToInteger013;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zmh
 * @date 2019-04-16 22:09
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * example:
 * 输入: "III"
 * 输出: 3
 * <p>
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution {

    private static final Map<Character, Integer> maps = new HashMap<>(7);

    static {
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    // todo: 需要优化
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            if (i > 0) {
                char prev = chars[i - 1];
                if (prev == 'I' && (ch == 'V' || ch == 'X')) {
                    sum += maps.get(ch) - maps.get(prev);
                    i--;
                } else if (prev == 'X' && (ch == 'L' || ch == 'C')) {
                    sum += maps.get(ch) - maps.get(prev);
                    i--;
                } else if (prev == 'C' && (ch == 'D' || ch == 'M')) {
                    sum += maps.get(ch) - maps.get(prev);
                    i--;
                } else {
                    sum += maps.get(ch);
                }
            } else {
                sum += maps.get(ch);
            }
        }
        return sum;
    }
}
