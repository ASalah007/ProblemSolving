class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
      vector<int> warm;
      warm.push_back(0);
      int mx = t.back();
      for(int i=t.size()-2; i>=0; i--){
        int a = 0;
        
        for(int j=i+1; j<t.size();){
          if(t[i] >= mx){
            mx = t[i];
            break;
          }
          if(t[j] > t[i]) {
            a = j-i;
            break;
          }
          else if(warm[t.size() -j -1] ==0){
            break;
          }
          else if (t[j + warm[t.size() - j - 1]] > t[i]){
            a = j - i +warm[t.size() - j - 1];
            break;
          }
          j += warm[t.size() -j -1];
        }
        warm.push_back(a);
      }
      reverse(warm.begin(), warm.end());
      return warm;
    }
};
