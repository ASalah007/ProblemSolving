import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int[] mn = new int[nums.length+1];
        Arrays.fill(mn, -1);

        mn[0] = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            
            int j=0;
            while(mn[j] != -1){
                if(mn[j] - i <= nums[i]){
                    mn[j+1] = i;
                    if(i == 0) return j+1;
                    break;
                }
                j++;
            }
        }
        return 0;
    }
}
