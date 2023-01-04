class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
      unordered_map<int, int> fq;
      for(int t : tasks){
        fq[t]++;
      }
      int ans = 0;
      for(auto& it : fq){
        if(it.second % 3 == 0){
          ans += it.second/3;
          continue;
        } 
        
        if(it.second % 2 == 1){
          if(it.second < 3) return -1;
          ans++;
          it.second -= 3;
        }
        // from here the number is even and bigger than 0
        ans += (it.second / 6)*2;
        ans += (it.second%6) / 2;
      }
      return ans;
    }
};
