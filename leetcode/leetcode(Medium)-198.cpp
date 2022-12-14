class Solution {
public:
    int rob(vector<int>& nums) {
        int a = nums[0];
        int b = 0, c = nums[0];
        for(int i=1; i<nums.size(); i++){
          c = max(a, b+nums[i]);
          b = a;
          a = c;
        }
        return c;
    }
};
