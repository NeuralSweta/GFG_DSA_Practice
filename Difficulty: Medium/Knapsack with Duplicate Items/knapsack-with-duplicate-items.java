class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
            Integer[][] dp = new Integer[n][capacity + 1];
            for (Integer[] row : dp) Arrays.fill(row, -1);
            return helper(0, capacity, val, wt, dp);
        }

        public static int helper(int i, int capacity, int[] val, int[] wt, Integer[][] dp) {
            if (i == val.length || capacity == 0) return 0;

            if (dp[i][capacity] != -1) return dp[i][capacity];

            int skip = helper(i + 1, capacity, val, wt, dp);
            int pick = Integer.MIN_VALUE;
            if (wt[i] <= capacity) {
                pick = val[i] + helper(i, capacity - wt[i], val, wt, dp);
            }

            return dp[i][capacity] = Math.max(pick, skip);
        }
}