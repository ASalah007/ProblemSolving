import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        var out = new PrintWriter(System.out);
        var in = new Scanner(System.in);
        int n=in.nextInt();
        var isprime = new boolean[n+10];
        var ans = new HashSet<Integer>(n+1);

        for(int i=0; i<n+1; i++){
            isprime[i] = true;
        }
        for(int i=2; i<=n; i++){
            if(isprime[i]){
                ans.add(i);
                for(int j = i; j<=n; j+=i){
                    isprime[j] = false;
                }
                int x =i*i;
                while(x <= n){
                    ans.add(x);
                    x*=i;
                }
            }
        }
        out.println(ans.size());
        for(var i : ans){
            out.print(i);
            out.print(" ");
        }
        out.close();
    }
}
