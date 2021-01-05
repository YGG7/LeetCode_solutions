package LeetCode;

import LeetCode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recurIsSymmetric(root.left, root.right);
    }

    // DFS-like solution
    private boolean recurIsSymmetric(TreeNode l, TreeNode r) {
        if(l==null && r==null) return true;
        if(l==null || r==null || l.val!=r.val) return false;
        return recurIsSymmetric(l.left, r.right) && recurIsSymmetric(l.right, r.left);
    }

    // BFS-like solution
    private boolean bfsIsSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        boolean isSym = true;
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if(n1==null && n2==null) ;
            else if (n1==null || n2==null || n1.val!=n2.val) {
                isSym = false;
                break;
            } else {
                // insert order is important
                queue.offer(n1.left);
                queue.offer(n2.right);
                queue.offer(n1.right);
                queue.offer(n2.left);
            }
        }
        return isSym;
    }
}
