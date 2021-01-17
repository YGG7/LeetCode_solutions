package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Jianzhi 68-I. https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class LowestCommonAncestorInBST {
    // top-down
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val>p.val && root.val>q.val) {
                root = root.left;
            } else if (root.val<p.val && root.val<q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
