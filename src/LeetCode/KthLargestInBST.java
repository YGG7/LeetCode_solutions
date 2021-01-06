package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Jianzhi 54. https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/submissions/
 */
public class KthLargestInBST {
    private int count = 0;
    private int target = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root==null) return 0;
        count = k;
        inorderDFS(root);
        return target;
    }

    private void inorderDFS(TreeNode r) {
        if (r==null || count==0) return;
        inorderDFS(r.right);
        if (--count==0) {
            target = r.val;
            return;
        }
        inorderDFS(r.left);
    }
}
