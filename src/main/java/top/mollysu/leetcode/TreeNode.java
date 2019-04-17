package top.mollysu.leetcode;

/**
 * @author zmh
 * @date 2019-04-11 13:02
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode constructor(int i, int... nums) {
        if (i >= nums.length || nums[i] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(nums[i]);
        root.left = constructor(2 * i + 1, nums);
        root.right = constructor(2 * i + 2, nums);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = constructor(0, 1, 2, 3, 4, 5, -1, 6, -1, -1, 7, 8, -1, -1);
        System.out.println(treeNode);
    }
}
