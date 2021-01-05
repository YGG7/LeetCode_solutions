package LeetCode;

import LeetCode.util2.Node;

public class ConvertBinarySearchTree {
    private Node head;
    private Node pre;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node curr) {
        if(curr==null) return;
        dfs(curr.left);
        if(pre==null) head = curr;
        else pre.right = curr;
        curr.left = pre;
        pre = curr;
        dfs(curr.right);
    }
}
