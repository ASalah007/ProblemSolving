class Solution {
    public int climbStairs(int n) {
        int fn=1, f0=1, f1=1;
        
        for(int i=2; i<=n; i++){
            fn = f0+f1;
            f0=f1;
            f1=fn;
        }
        return fn;
    }
}
