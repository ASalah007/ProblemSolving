class Solution {
    public int getMaxLen(int[] nums) {

        int firstNeg = -1;
        int lastNeg = -1;
        int negCount= 0;
        boolean foundFirst =false;

        int mx = 0;
        int lastZero = -1;

        for(int i=0;i<nums.length; i++){
            if(nums[i] < 0){
                lastNeg = i;
                negCount++;
                if(!foundFirst){
                    firstNeg = i;
                    foundFirst =true;
                }   
            }

            if(nums[i] == 0){
                mx = Math.max(mx, maxLength(nums,lastZero + 1, i-1, firstNeg, lastNeg, negCount));
                lastZero = i;
                firstNeg = -1;
                lastNeg = -1;
                negCount = 0;
                foundFirst = false;
            }
        }

        return  Math.max(mx, maxLength(nums, lastZero +1, nums.length-1, firstNeg, lastNeg, negCount));

    }

    public int maxLength(int[] nums,int i, int j, int firstNeg, int lastNeg, int negCount) {
        if(negCount %2 == 0){
            return j-i+1;
        }
        else{
            return Math.max(lastNeg - i, j-firstNeg);
        }

    }
    
}
