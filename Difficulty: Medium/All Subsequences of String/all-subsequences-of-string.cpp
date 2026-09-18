class Solution {
  public:
   void set(int i,string &s,vector<string>&ds, string &str ){
       int n= s.size();
       if(i==n){
           ds.push_back(str);
           return;
       }
       str.push_back(s[i]);
       set(i+1,s,ds,str);
       str.pop_back();
       set(i+1,s,ds,str);
   }
    vector<string> powerSet(string &s) {
        // Code here
         vector<string>ds;
         string str;
         set(0,s,ds,str);
         sort(ds.begin(),ds.end());
         return ds;
    }
};