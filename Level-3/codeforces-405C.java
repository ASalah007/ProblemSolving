import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.lang.model.util.ElementScanner6;

import static java.lang.Math.*;

public class Main{
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    
    public static void main(String[] args){
        int n = in.nextInt();
        int[][] arr =new int[n][n];
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int prod = 0;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                prod += arr[i][j]* arr[j][i];
            }
        }
        prod %=2;
        int t= in.nextInt();
        while(t-->0){
            int temp = in.nextInt();
            if(temp == 1 || temp == 2){
                prod = (prod==1)? 0 : 1;
                in.nextInt();
            }
            else{
                out.print(prod);
            }
        }
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble() { return Double.parseDouble(next()); }

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

