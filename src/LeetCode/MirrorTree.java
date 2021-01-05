package LeetCode;

import LeetCode.util.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        recurMirror(root);
        return root;
    }

    private void recurMirror(TreeNode root) {
        if (root == null) return;
        recurMirror(root.left);
        recurMirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
