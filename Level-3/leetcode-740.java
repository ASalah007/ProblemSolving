import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] cost = new int[11000];
        Arrays.fill(cost, 0);
        int mx =-1;

        for(int i=0; i<nums.length; i++){
            cost[nums[i]]+=nums[i];
            mx=Math.max(mx, nums[i]);
        }
        
        
        int pre=0, curr=0;
        for(int i =1; i<=mx; i++){
            //System.out.println(i + " " + pre +" "+ curr+" "+ cost.get(i));
            cost[i] = Math.max(pre+cost[i], curr);
            //System.out.println(cost.get(i));
            pre = curr;
            curr=cost[i];   
        }
        return curr;
    }
}
