import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] cuts;
    static int n;
    static int mem[][];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int l = in.nextInt();
        while(l != 0){
            n = in.nextInt();
            cuts = new int[n];
            mem = new int[n+1][n+1];
            for(int i=0; i<n; i++){
                cuts[i] = in.nextInt();
            }

            for(int i=0; i<n+1; i++){
                Arrays.fill(mem[i], -1);
            }

            int mincost = price(0, n-1, 0, l);
            out.println("The minimum cutting is "+mincost+".");
            l=in.nextInt();
        }
        out.close();

    }
    static int price(int st, int ed, int le, int re){
        if(st == ed)
            return re - le;
        if(ed<st || ed >= n)
            return 0;
        if(mem[st][ed] != -1)
            return mem[st][ed];
        int min = Integer.MAX_VALUE;

        for(int i=st; i<=ed; i++){
           int p = price(st, i-1, le, cuts[i]) + price(i+1, ed, cuts[i], re);
           min = Math.min(min, p);
        }
        return mem[st][ed] = min + re - le;
    }
}
