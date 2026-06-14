// Problem: Tree Boundary Traversal | Difficulty: Medium | Topic: Trees
// GFG: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/0
import java.util.*;
class Solution {
    public List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.data);
        addLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result);
        return result;
    }
    private void addLeftBoundary(Node node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null)) return;
        res.add(node.data);
        if (node.left != null) addLeftBoundary(node.left, res);
        else addLeftBoundary(node.right, res);
    }
    private void addRightBoundary(Node node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right != null) addRightBoundary(node.right, res);
        else addRightBoundary(node.left, res);
        res.add(node.data);  // add after recursion (bottom-up)
    }
    private void addLeaves(Node node, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) { res.add(node.data); return; }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
}
