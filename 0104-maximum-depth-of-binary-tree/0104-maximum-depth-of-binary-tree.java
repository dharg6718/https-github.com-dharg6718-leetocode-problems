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

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> depths = new ArrayDeque<>();

        queue.add(root);
        depths.add(1);

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int currentDepth = depths.remove();

            maxDepth = Math.max(maxDepth, currentDepth);

            if (node.left != null) {
                queue.add(node.left);
                depths.add(currentDepth + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                depths.add(currentDepth + 1);
            }
        }

        return maxDepth;
    }
}