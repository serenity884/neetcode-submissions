class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelsList = new ArrayList<>();
        if (root == null) return levelsList;   // handle null root

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();           // number of nodes at current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();  // always removes from front, no index issues
                level.add(node.val);
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levelsList.add(level);
        }
        return levelsList;
    }
}