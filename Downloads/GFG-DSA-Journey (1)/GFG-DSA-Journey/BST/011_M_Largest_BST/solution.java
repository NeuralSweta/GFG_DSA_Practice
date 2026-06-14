// Problem: Largest BST in Binary Tree | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/largest-bst/0
class Solution {
    int maxSize = 0;
    public int largestBst(Node root) {
        postOrder(root);
        return maxSize;
    }
    // returns int[]{size, min, max, isBST(1/0)}
    private int[] postOrder(Node node) {
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 1};
        int[] left  = postOrder(node.left);
        int[] right = postOrder(node.right);
        if (left[3] == 1 && right[3] == 1 && node.data > left[2] && node.data < right[1]) {
            int size = left[0] + right[0] + 1;
            maxSize = Math.max(maxSize, size);
            return new int[]{size, Math.min(left[1], node.data), Math.max(right[2], node.data), 1};
        }
        return new int[]{0, 0, 0, 0};
    }
}
