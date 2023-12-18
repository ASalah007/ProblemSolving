import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    private Map<Integer, Map<Integer, Boolean>> memo;
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) return false;

        Arrays.sort(nums);
        for(int i=0; i<nums.length - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i+1] = temp;
        }

        memo = new HashMap<>();
        for(int i=0; i<nums.length; i++){ 
            memo.put(i, new HashMap<>());
        }

        return canPartition(nums, sum/2, 0);
    }

    private boolean canPartition(int[] nums, int value, int i) { 
        if (value < 0 || i >= nums.length) return false;
        if (value == 0) return true;
        if (memo.get(i).get(value) != null) return memo.get(i).get(value);

        boolean ans = canPartition(nums, value - nums[i], i + 1) || canPartition(nums, value, i + 1);
        memo.get(i).put(value, ans);
        return ans;
    }
}
