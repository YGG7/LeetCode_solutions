package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import LeetCode.util.TreeNode;


public class RebuildTree {
    private Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursiveBuild(preorder, inorder, 0, 0, inorder.length-1);
    }

    public TreeNode buildTreeHash(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursiveBuildHash(preorder, inorder, 0, 0, inorder.length-1);
    }

    // stack based
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int preIdx = 0, inIdx = 0, len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode currRoot = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (preIdx=1; preIdx<len; preIdx++) {
            int currPreVal = preorder[preIdx];
            if (currRoot.val != inorder[inIdx]) {
                currRoot.left = new TreeNode(currPreVal);
                currRoot = currRoot.left;
                stack.push(currRoot);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
                    currRoot = stack.pop();
                    inIdx++;
                }
                currRoot.right = new TreeNode(currPreVal);
                currRoot = currRoot.right;
                stack.push(currRoot);
            }
        }
        return root;
    }

    // using linear search
    // Time Complexity O(n^2)
    private TreeNode recursiveBuild(int[] preorder, int[] inorder, int preRootIdx, int inStartIdx, int inEndIdx) {
        // preRootIdx>preorder.length can be omitted
        // since when it happens, inStartIdx must be greater than inEndIdx
        if(preRootIdx>preorder.length || inStartIdx>inEndIdx) return null;

        TreeNode root = new TreeNode(preorder[preRootIdx]);
        int inRootIdx = 0;
        for(inRootIdx =inStartIdx; inRootIdx<=inEndIdx; inRootIdx++) {
            if(inorder[inRootIdx]==preorder[preRootIdx]) break;
        }

        root.left = recursiveBuild(preorder, inorder, preRootIdx+1, inStartIdx, inRootIdx-1);
        root.right = recursiveBuild(preorder, inorder, preRootIdx+1+(inRootIdx-inStartIdx), inRootIdx+1, inEndIdx);
        return root;
    }

    // using hash map
    // Time Complexity O(n)
    private TreeNode recursiveBuildHash(int[] preorder, int[] inorder, int preRootIdx, int inStartIdx, int inEndIdx) {
        // preRootIdx>preorder.length can be omitted
        // since when it happens, inStartIdx must be greater than inEndIdx
        if(preRootIdx>preorder.length || inStartIdx>inEndIdx) return null;

        TreeNode root = new TreeNode(preorder[preRootIdx]);
        int inRootIdx = map.get(preorder[preRootIdx]);

        root.left = recursiveBuildHash(preorder, inorder, preRootIdx+1, inStartIdx, inRootIdx-1);
        root.right = recursiveBuildHash(preorder, inorder, preRootIdx+1+(inRootIdx-inStartIdx), inRootIdx+1, inEndIdx);
        return root;
    }
}
