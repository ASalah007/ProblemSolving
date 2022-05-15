class Solution {
    public int maxSubArray(int[] nums) {
        int mx=nums[0], prev=nums[0];

        for(int i=1; i<nums.length; i++){
            prev = Math.max(nums[i], prev + nums[i]);
            mx = Math.max(mx, prev);
        }

        return mx;

    }
}
