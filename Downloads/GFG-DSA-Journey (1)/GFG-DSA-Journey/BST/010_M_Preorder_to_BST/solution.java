// Problem: Preorder to BST | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/preorder-to-postorder4423/0
class Solution {
    int idx = 0;
    public Node preorderToBST(int[] arr) {
        return build(arr, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private Node build(int[] arr, long min, long max) {
        if (idx >= arr.length || arr[idx] < min || arr[idx] > max) return null;
        Node root = new Node(arr[idx++]);
        root.left = build(arr, min, root.data);
        root.right = build(arr, root.data, max);
        return root;
    }
}
