package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Jianzhi 55-II. https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class IsBalanceTree {
    public boolean isBalanced(TreeNode root) {
        return heightDFS(root)!=-1;
    }

    private int heightDFS(TreeNode r) {
        if (r==null) return 0;
        int height_left = heightDFS(r.left);
        int height_right = heightDFS(r.right);
        if (height_left==-1 || height_right==-1 || Math.abs(height_left-height_right)>1) return -1;
        return Math.max(height_left, height_right)+1;
    }
}
