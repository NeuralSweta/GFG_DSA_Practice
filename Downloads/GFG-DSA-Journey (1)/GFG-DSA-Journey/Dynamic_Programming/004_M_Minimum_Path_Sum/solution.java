// Problem: Minimum Path Sum in Grid
// Difficulty: Medium | Topic: Dynamic Programming
// GFG Link: https://www.geeksforgeeks.org/problems/minimum-sum-path-in-a-triangle/1

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) { dp[i][j] = grid[0][0]; continue; }
                int fromTop  = (i > 1) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int fromLeft = (j > 1) ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = grid[i - 1][j - 1] + Math.min(fromTop, fromLeft);
            }
        }
        return dp[m][n];
    }
}
