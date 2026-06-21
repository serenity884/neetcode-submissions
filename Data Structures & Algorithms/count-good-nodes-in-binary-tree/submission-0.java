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
    int countLeft = 0;
    int countRight = 0;
    public int goodNodes(TreeNode root) {
        return countGood(root, root.val);
    }

    public int countGood(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }
        int count = (root.val >= maxSoFar) ? 1 : 0;
        int newMax = Math.max(maxSoFar, root.val);

        count += countGood(root.left, newMax);
        count += countGood(root.right, newMax);

        return count;
    }
}
