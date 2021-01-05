package LeetCode;

import LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeTopDown {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode!=null) {
                res.add(currNode.val);
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }
        int[] order = new int[res.size()];
        for (int i=0; i<order.length; i++) {
            order[i] = res.get(i);
        }
        return order;
    }
}
