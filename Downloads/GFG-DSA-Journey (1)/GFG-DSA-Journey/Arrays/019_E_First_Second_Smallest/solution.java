// Problem: First and Second Smallest | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/find-the-smallest-and-second-smallest-element-in-an-array3226/0
class Solution {
    public int[] minAnd2ndMin(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : arr) {
            if (x < first) { second = first; first = x; }
            else if (x < second && x != first) second = x;
        }
        return second == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{first, second};
    }
}
