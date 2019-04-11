package top.mollysu.leetcode.solutions.sameTree100;

import top.mollysu.leetcode.TreeNode;

/**
 * @author zmh
 * @date 2019-04-11 13:00
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * {@link <a>https://leetcode-cn.com/problems/same-tree/</a>}
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
//        q.right = new TreeNode(3);

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean a = isSameTree(p.left, q.left);
        boolean b = isSameTree(p.right, q.right);
        return a && b;
    }

    /**
     * 代码更简洁 参考评论区
     */
    public boolean isSameTreeSimple(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
