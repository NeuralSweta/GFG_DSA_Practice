class Solution {
    public int maxValue(int[] arr) {
        // code here
        int n= arr.length;
        if(n==0)return 0;
        if(n==1)return arr[0];
        int[] dp1= new int[n];
        int[] dp2= new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(loot(0,arr,dp1,n-1),loot(1,arr,dp2,n));
        
    }
    public int loot(int i,int[] arr, int[] dp, int limit){
        if(i>=limit)return 0;
        if(dp[i]!=-1)return dp[i];
        
        int pick=arr[i]+ loot(i+2,arr,dp,limit);
        int skip= loot(i+1,arr,dp,limit);
        dp[i]= Math.max(pick,skip);
        return dp[i];
    }
}
