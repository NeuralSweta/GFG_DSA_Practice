class Solution {
  public:
  bool check(int count,int cows){
          if(count>=cows)return true;
          return false;
      }
    int aggressiveCows(vector<int> &position, int m) {
        // code here
                sort(position.begin(),position.end());
                int n=position.size();
                int low=1;
                int high= position[n-1]-position[0];
                while(low<=high){
                    int mid=low+(high-low)/2;
                    int count=1,lastPos=position[0];
                    for(int i=1;i<n;i++){
                        if(position[i]-lastPos>=mid){
                            count++;lastPos=position[i];
                        }
                    }
                    if(check(count,m))low=mid+1;
                    else high=mid-1; 
                }
                return high;
    }
};