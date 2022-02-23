// this is kind of brute force solution, simpler one is in the discussion of the problem on leetcode website using dynamic programming.

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int firstNeg = -1;
        int lastNeg = -1;
        int negCount= 0;
        boolean foundFirst =false;

        int mx = Integer.MIN_VALUE;
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
                mx = Math.max(mx, maxProduct(nums,lastZero + 1, i, firstNeg, lastNeg, negCount));
                lastZero = i;
                firstNeg = -1;
                lastNeg = -1;
                negCount = 0;
                foundFirst = false;
            }
        }

        return  Math.max(mx, maxProduct(nums, lastZero +1, nums.length, firstNeg, lastNeg, negCount));

    }

    public int maxProduct(int[] nums,int i, int j, int firstNeg, int lastNeg, int negCount) {
        if(negCount %2 == 0){
            return product(nums, i, j);
        }
        else{
            return Math.max(product(nums, i, lastNeg), product(nums, firstNeg+1, j));
        }

    }
    
    private int product(int[] nums, int i, int j){
        if(i == j) return 0;
        int prod = 1;
        for(; i<j; i++){
            prod *= nums[i];
        }
        return prod;
    }
}
