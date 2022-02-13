class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
            
        int mx = 0;
        for(int i=0; i<nums.length; i++){
            mx = Math.max(mx-1, nums[i]);
            if(mx <= 0 && i != nums.length -1)
                return false;
        }
        return true;
    }
}
