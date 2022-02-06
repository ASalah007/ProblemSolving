class Solution {
    public int removeDuplicates(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            int j = i+2;
            while(j<nums.length && nums[j] == nums[i]){
                nums[j]=Integer.MIN_VALUE;
                j++;
            }
        }
        
        int j = 1;
        int i = 0;
        for(; i<nums.length; i++){

            if(nums[i] != Integer.MIN_VALUE)
                continue;

            if(j<=i)
                 j=i+1;

            while(j<nums.length && nums[j] == Integer.MIN_VALUE)
                j++;
            
            if(j >= nums.length)
                return i;
            
            swap(nums, i, j);
            
        }
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}
