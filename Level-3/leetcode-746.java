class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2)
            return Math.min(cost[0], cost[1]);
        int p1 = cost[0], p2=cost[1];
        int curr;
        for(int i=2; i<cost.length; i++){
            curr=cost[i] + Math.min(p1,p2);
            p1=p2;
            p2=curr;
        }
        return Math.min(p2,p1);
    }
}
