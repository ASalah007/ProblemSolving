class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxPair = 0;
        int lastMax= values[0]-1;
        
        for(int i=1; i<values.length; i++){
            maxPair = Math.max(lastMax+values[i], maxPair);
            lastMax = Math.max(lastMax, values[i]) -1;
        }
        return maxPair;
    }
}
