class Solution {
    public int derangeCount(int n) {
        // code here
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return derangementMR(n,dp);
    }
    public static int derangementMR(int n, int[] dp){
       if(n==0)return 1;
       if(n==1)return 0;
       if(dp[n]!=-1)return dp[n];
       return dp[n]= (n-1)*(derangementMR(n-1,dp)+derangementMR(n-2,dp));
        //derangementMR(n-2,dp)- if swapping between 2 nos.
        //derangementMR(n-1,dp)- if no swapping between 2 nos.
    }
};