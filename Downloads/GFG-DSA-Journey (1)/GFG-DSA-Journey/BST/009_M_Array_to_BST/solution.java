// Problem: Array to BST | Difficulty: Medium | Topic: BST
// GFG: https://www.geeksforgeeks.org/problems/array-to-bst4443/0
import java.util.Arrays;
class Solution {
    public Node arrayToBST(int[] arr) {
        Arrays.sort(arr);
        return buildBST(arr, 0, arr.length - 1);
    }
    private Node buildBST(int[] arr, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        Node root = new Node(arr[mid]);
        root.left = buildBST(arr, lo, mid - 1);
        root.right = buildBST(arr, mid + 1, hi);
        return root;
    }
}
