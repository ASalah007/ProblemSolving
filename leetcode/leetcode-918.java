class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int linmax =  maxSubArray(nums);
        
        int rightSum = 0;
        for(int i=1; i<nums.length; i++){
            rightSum += nums[i];
        }

        int leftSum=nums[0];
        int leftMax=leftSum;
        int totalMax=leftMax + rightSum;
        for(int i=1; i<nums.length-1; i++){
            leftSum+=nums[i];
            rightSum-=nums[i];
            leftMax = Math.max(leftMax, leftSum);
            totalMax = Math.max(totalMax, leftMax + rightSum);
        }
        
        return Math.max(linmax, totalMax);
    }

    public int maxSubArray(int[] nums) {
        int mx=nums[0], prev=nums[0];

        for(int i=1; i<nums.length; i++){
            prev = Math.max(nums[i], prev + nums[i]);
            mx = Math.max(mx, prev);
        }

        return mx;

    }
}
