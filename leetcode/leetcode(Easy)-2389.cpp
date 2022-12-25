class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
      sort(nums.begin(), nums.end());
      vector<int> sq;
      sq.push_back(nums[0]);
      for(int i=1; i<nums.size(); i++){
        sq.push_back(nums[i] + sq[i-1]);
      }    
      vector<int> ans; 
      for(int i : queries){
        ans.push_back(std::distance(sq.begin(), upper_bound(sq.begin(), sq.end(), i)));
      }    

      return ans;
    }
};
