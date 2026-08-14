class Solution {
  public:
    int minCost(vector<int>& height) {
        // Code here
        int n= height.size();
        vector<int>dp(n+1,-1);
        return cost(n-1,height,dp);
        
    
    }
    public:
      int cost(int idx,vector<int>&height,vector<int>&dp){
          if(idx==0)return 0;
          if(dp[idx]!=-1)return dp[idx];
          int left= cost(idx-1,height,dp)+abs(height[idx]-height[idx-1]);
          int right=INT_MAX;
          if(idx>1)right= cost(idx-2,height,dp)+abs(height[idx]-height[idx-2]);
          return dp[idx]=min(left,right);
      }
};