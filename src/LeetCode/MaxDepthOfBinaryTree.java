package LeetCode;

import LeetCode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currLevelNum = queue.size();
            for (int i=0; i<currLevelNum; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left!=null) queue.offer(currNode.left);
                if (currNode.right!=null) queue.offer(currNode.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
