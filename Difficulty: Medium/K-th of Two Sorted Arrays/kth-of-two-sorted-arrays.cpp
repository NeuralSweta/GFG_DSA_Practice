class Solution {
  public:
  bool check(int mid,vector<int> &a, vector<int> &b,int k){
      int ub1= upper_bound(a.begin(),a.end(),mid)-a.begin();
      int ub2= upper_bound(b.begin(),b.end(),mid)-b.begin();
      if(ub1+ub2<k)return true;
      return false;
      
  }
    int kthElement(vector<int> &a, vector<int> &b, int k) {
        // code here
        int low= min(a[0],b[0]);
        int high= max(a[a.size()-1],b[b.size()-1]);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,a,b,k)){
                low=mid+1;
            }
            else high= mid-1;
        }
        return low;
    }
};