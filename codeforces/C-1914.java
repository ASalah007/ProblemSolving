import java.util.Scanner;
 
public class C_Quests {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int tt = sc.nextInt();
        while(tt --> 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i=0;i<n;i++){ a[i] = sc.nextInt(); }
            for (int i=0;i<n;i++){ b[i] = sc.nextInt(); }
            ans.append(solve(a, b, 0, 0 , k, 0, 0) + "\n"); 
        }
 
        System.out.println(ans);
        sc.close();
    }
    private static int solve(int [] a, int[] b, int i, int acc,  int k, int mx, int mxb){ 
        if (i == a.length || k == 0) return mx;
        int currMax = acc + a[i] + (k-1) * Math.max(b[i], mxb);
        return solve(a, b, i+1, acc+a[i], k - 1, Math.max(mx, currMax), Math.max(mxb, b[i]));
    }
}
