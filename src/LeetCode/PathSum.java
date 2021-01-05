package LeetCode;

import java.util.LinkedList;
import java.util.List;
import LeetCode.util.TreeNode;

/**
 * Jianzhi 34. https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class PathSum {
    private List<List<Integer>> res;
    private List<Integer> path;
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        this.sum = sum;
        backtracking(root, 0);
        return res;
    }

    private void backtracking(TreeNode currNode, int currSum) {
        if (currNode==null) return;
        currSum += currNode.val;
        path.add(currNode.val);
        if (currSum==sum && currNode.left==null && currNode.right==null) {
            res.add(new LinkedList<>(path)); // copy
        }
        backtracking(currNode.left, currSum);
        backtracking(currNode.right, currSum);
        path.remove(path.size()-1);
    }
}
