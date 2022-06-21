import java.io.*;
import java.util.*;

public class Main{
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static boolean[] done = new boolean[110];
    static char[][] words = new char[101][101];
    static int n, m;

    public static void main(String[] args){
        n = in.nextInt(); m = in.nextInt();

        for(int i=0; i<n; i++) words[i] = in.next().toCharArray(); 

        int ans = 0;
        for(int i=0; i<m; i++){

            // check if this column is illegal 
            boolean skip = false;
            for(int j = 0; j<n-1; j++){
                if(done[j]) continue;
                if(words[j][i] > words[j+1][i]){
                    ans++;
                    skip = true;
                    break;
                }
            }

            // skip if this column is illegal
            if(skip) continue;

            // now remove the good rows from the upcomming checks 
            for(int j=0; j<n-1; j++){
                if(done[j]) continue;

                if(words[j][i] < words[j+1][i])
                    done[j] = true;
            }
        }
        System.out.println(ans);
    }

}

