/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode build(int[] preorder, int pStartIdx, int pEndIdx, int inStartIdx, int inEndIdx,
        Map<Integer, Integer> inorderMap) {
        if (pStartIdx > pEndIdx)
            return null;
        int rootVal = preorder[pStartIdx];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        int leftLength = mid - inStartIdx;
        root.left =
            build(preorder, pStartIdx + 1, pStartIdx + leftLength, inStartIdx, mid - 1, inorderMap);
        root.right =
            build(preorder, pStartIdx + leftLength + 1, pEndIdx, mid + 1, inEndIdx, inorderMap);
        return root;
    }
}
