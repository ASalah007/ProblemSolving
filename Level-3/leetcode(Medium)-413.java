class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length-1; i++){
            int j=i+1;
            int diff = nums[j] - nums[i];
            while(j<nums.length && nums[j]-nums[j-1] == diff){
                j++;
            }
            // System.out.println(i+ " " +j);
            ans += count(j-i);
            if(j>i+1){
                i = j-2;
            }
            else {
                i = j-1;
            }
        }
        return ans;
    }

    private int count(int len){
        len = len - 3 +1;
        return (len * (len+1))/2;
    }
}
