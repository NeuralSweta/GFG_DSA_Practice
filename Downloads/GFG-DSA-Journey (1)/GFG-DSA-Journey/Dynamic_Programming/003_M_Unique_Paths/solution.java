// Problem: Unique Paths in a Grid
// Difficulty: Medium | Topic: Dynamic Programming
// GFG Link: https://www.geeksforgeeks.org/problems/unique-paths-in-a-grid--170647/1

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
