// Problem: Stickler Thief (House Robber) | Difficulty: Medium | Topic: DP
// GFG: https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/0
class Solution {
    public int findMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int prev2 = arr[0], prev1 = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1; prev1 = curr;
        }
        return prev1;
    }
}
