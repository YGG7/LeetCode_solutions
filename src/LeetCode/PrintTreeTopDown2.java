package LeetCode;

import LeetCode.util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeTopDown2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int len = queue.size();
            for (int i=0; i<len; i++) {
                TreeNode currNode = queue.poll();
                if (currNode!=null) {
                    tmp.add(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                }
            }
            // avoid adding empty linked list if all nodes in the last level are null
            if (tmp.size()>0) {
                res.add(tmp);
            }
        }
        return res;
    }
}
