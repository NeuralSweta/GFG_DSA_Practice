// Problem: Binary Tree from Inorder and Postorder | Difficulty: Medium | Topic: Trees
// GFG: https://www.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/0
import java.util.*;
class Solution {
    Map<Integer, Integer> inMap = new HashMap<>();
    int postIdx;
    public Node buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return build(postorder, 0, inorder.length - 1);
    }
    private Node build(int[] post, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int val = post[postIdx--];
        Node root = new Node(val);
        int inIdx = inMap.get(val);
        root.right = build(post, inIdx + 1, inEnd);   // right first!
        root.left  = build(post, inStart, inIdx - 1);
        return root;
    }
}
