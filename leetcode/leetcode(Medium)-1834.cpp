class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
      vector<pair<int, int>> a, b;
      for(int i=0; i<tasks.size(); i++){
        b.push_back(make_pair(-tasks[i][0], -i));
        push_heap(b.begin(), b.end());
      }

      long long time = -b.front().first;
      vector<int> ans;

      while((!b.empty() || !a.empty())){

        long long last_time = 0;
        while((!b.empty()) && (-b.front().first <= time || a.empty())){
          a.push_back(make_pair(-tasks[-b.front().second][1], b.front().second));
          push_heap(a.begin(), a.end());

          time = max(time, (long long)-b.front().first);
          pop_heap(b.begin(), b.end());
          b.pop_back();
        }
       

        ans.push_back(-a.front().second);

        time+=-a.front().first;

        pop_heap(a.begin(), a.end());
        a.pop_back();        
      }
      return ans;
    }
};
