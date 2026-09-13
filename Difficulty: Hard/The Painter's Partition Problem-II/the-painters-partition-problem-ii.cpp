class Solution {
     #define ll long long
  public:
   ll studentsCount(vector<int> &arr, ll pages){
        ll stu=1;
        ll pageStu=0;
        for(int i=0;i<arr.size();i++){
            if(pageStu+arr[i]<=pages)pageStu += arr[i];
            else{
                stu +=1;
                pageStu= arr[i];
            }
        }
        return stu;
    }
    int minTime(vector<int>& arr, int k) {
        // code here
          ll n= arr.size();
        if(k>n)return-1;
        ll low= *max_element(arr.begin(),arr.end());
        ll high= accumulate(arr.begin(),arr.end(),0LL);
        while(low<=high){
            ll mid=low+(high-low)/2;
            ll students= studentsCount(arr,mid);
            if(students<=k)high=mid-1;
            else low=mid+1; 
        }
        return (int)low;
        
    }
};

