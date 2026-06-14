// Problem: Min Cost Climbing Stairs | Difficulty: Medium | Topic: DP
// GFG: https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/0
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0], prev1 = cost[1];
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1; prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
