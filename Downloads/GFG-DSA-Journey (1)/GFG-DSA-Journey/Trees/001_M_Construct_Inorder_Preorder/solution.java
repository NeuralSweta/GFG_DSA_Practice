// Problem: Construct Tree from Inorder and Preorder | Difficulty: Medium | Topic: Trees
// GFG: https://www.geeksforgeeks.org/problems/construct-tree-1/0
import java.util.*;
class Solution {
    Map<Integer, Integer> inMap = new HashMap<>();
    int preIdx = 0;
    public Node buildTree(int[] inorder, int[] preorder) {
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }
    private Node build(int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int val = pre[preIdx++];
        Node root = new Node(val);
        int inIdx = inMap.get(val);
        root.left  = build(pre, inStart, inIdx - 1);
        root.right = build(pre, inIdx + 1, inEnd);
        return root;
    }
}
