package LeetCode;

/**
 * Jianzhi 33. https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyBSTPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder==null || postorder.length==0) return true;
        return verifyRecur(postorder, 0, postorder.length-1);
    }

    private boolean verifyRecur(int[] postorder, int start, int end) {
        // empty tree or a tree only containing root
        if (start>=end) return true;

        int root = postorder[end];
        int leftRootIdx = start-1;
        for (int i=start; i<end; i++) {
            if (postorder[i]<root) leftRootIdx = i;
            else break;
        }
        boolean isRootValid = true;
        for (int i=leftRootIdx+1; i<end; i++) {
            if (postorder[i] <= root) {
                isRootValid = false;
                break;
            }
        }
        return isRootValid && verifyRecur(postorder, start, leftRootIdx) && verifyRecur(postorder, leftRootIdx+1, end-1);
    }
}
