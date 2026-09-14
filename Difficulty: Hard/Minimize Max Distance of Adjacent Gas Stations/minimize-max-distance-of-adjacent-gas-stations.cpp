class Solution {
    #define ld long double
  public:
  int noOfGSReq(ld dist,vector<int>arr){
      int count=0;
      for(int i=1;i<arr.size();i++){
          int noInBtw= ((arr[i]-arr[i-1])/dist);
          if((arr[i]-arr[i-1])/dist==noInBtw *dist)noInBtw--;
          count+=noInBtw;
      }
      return count;
  }
    double minMaxDist(vector<int> &arr, int k) {
        // Code here
        int n= arr.size();
        ld low=0;
        ld high=0;
        for(int i=0;i<n-1;i++)high=max(high,(ld)(arr[i+1]-arr[i]));
        ld diff= 1e-6;
        while(high-low>diff){
            ld mid=low+(high-low)/2.0;
            int count=noOfGSReq(mid,arr);
            if(count>k)low=mid;
            else high=mid;
        }
       return high;
    }
};