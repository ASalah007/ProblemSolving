class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        int f1 = 1, f2= 1, f=1;
        for(int i=3; i<=n; i++){
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f; 
    }
}
