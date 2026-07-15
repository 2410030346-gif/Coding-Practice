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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        // Base case: no numbers left
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        // Try each number as root
        for (int i = start; i <= end; i++) {
            // All possible left subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            // All possible right subtrees
            List<TreeNode> rightTrees = buildTrees(i + 1, end);
            
            // Combine them with current root
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
