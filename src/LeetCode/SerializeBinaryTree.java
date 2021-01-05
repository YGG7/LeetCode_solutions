package LeetCode;
import LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Jianzhi 37. https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class SerializeBinaryTree {
    private int start = 0;

    public String serializeBFS(TreeNode root) {
        if (root==null) return "*";

        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr==null) builder.append("*,");
            else {
                builder.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        // delete the last ","
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public TreeNode deserializeBFS(String data) {
        if (data.equals("*")) return null;

        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) { // nodes to be set their children are in queue
            TreeNode node = queue.poll();
            if (node==null) continue;
            if (nodes[index].equals("*")) {
                node.left = null;
            }
            else {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
            }

            index++;

            if (nodes[index].equals("*")) {
                node.right = null;
            }
            else {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
            }
            index++;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return root;
    }

    public String serializeDFS(TreeNode root) {
        if (root==null) return "*";
        return root.val+","+serializeDFS(root.left)+","+serializeDFS(root.right);
    }


    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        start = 0;
        return buildTree(nodes);
    }

    public TreeNode buildTree(String[] nodes) {
        if (nodes[start].equals("*")) {
            start++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[start]));
        start++;
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    public TreeNode deserializeArrayList(String data) {
        String[] nodes = data.split(",");
        ArrayList<String> nodesList = new ArrayList<>(Arrays.asList(nodes));
        return buildTreeArrayList(nodesList);
    }

    public TreeNode buildTreeArrayList(ArrayList<String> nodes) {
        if (nodes.get(0).equals("*")) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = buildTreeArrayList(nodes);
        root.right = buildTreeArrayList(nodes);
        return root;
    }
}
