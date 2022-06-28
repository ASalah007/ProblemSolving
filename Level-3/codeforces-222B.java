import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

import static java.lang.Math.*;

public class Main{
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    

    public static void main(String[] args){
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[][]arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int [] fixi = new int[1002];
        int [] fixj = new int[1002];

        for(int i=0; i<1002; i++){
            fixi[i] = i;
            fixj[i] = i;
        }
        while(k-->0){
            char c = in.next().charAt(0);
            int a=in.nextInt(), b = in.nextInt();

            if(c == 'c'){
                int temp = fixj[a];
                fixj[a] = fixj[b];
                fixj[b] = temp;
            }
            else if(c == 'r'){
                int temp = fixi[a];
                fixi[a] = fixi[b];
                fixi[b] = temp;
            }           
            else{
                out.println(arr[fixi[a]][fixj[b]]);
            }
        }
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOExceptLevelion e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

