package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Jianzhi 68-II. https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class LowestCommonAncestor {
    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean inTree = isContain(root, p, q);
        return inTree?ancestor:null;
    }

    // if contains any one of p and q, return true
    private boolean isContain(TreeNode r, TreeNode p, TreeNode q) {
        if (r==null) return false;
        boolean inLeft = isContain(r.left, p, q);
        boolean inRight = isContain(r.right, p, q);
        if ((inLeft && inRight) || ((r==p || r==q) && (inLeft || inRight))) {
            ancestor = r;
        }
        return inLeft || inRight || (r==p) || (r==q);
    }
}
