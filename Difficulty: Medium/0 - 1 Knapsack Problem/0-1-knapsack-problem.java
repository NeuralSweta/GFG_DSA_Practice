class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n= val.length;
        int[][] dp= new int[n][W+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return helper(0,W,val,wt,dp);
        
    }
    public int helper(int i,int W, int[] val, int[] wt, int[][] dp){
        if(i==val.length || W==0)return 0;
        if(dp[i][W]!=-1)return dp[i][W];
        int skip= helper(i+1,W,val,wt,dp);
        int pick= Integer.MIN_VALUE;
        if(wt[i]<=W){
            pick= val[i]+helper(i+1,W-wt[i],val,wt,dp);
        }
        return dp[i][W]= Math.max(pick,skip);
    }
}
