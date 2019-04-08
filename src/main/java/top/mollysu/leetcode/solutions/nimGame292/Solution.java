package top.mollysu.leetcode.solutions.nimGame292;

/**
 * @author zmh
 * @date 2019-04-06 21:26
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * <p>
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 */
public class Solution {

    /**
     * 小于4个时，总是你赢，否则判断是否能被4整除
     * O(1) 0ms
     */
    public boolean canWinNim(int n) {
        if (n < 4) {
            return true;
        } else {
            return (n % 4) != 0;
        }
    }
}
