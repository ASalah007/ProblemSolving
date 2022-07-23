import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception{
      int n = in.nextInt();
      char arr[] = in.next().toCharArray();
      int idx = -1, count = 0;
      if(n <= 2) {
        System.out.println(n);
        return;
      }

      if(arr[0] == arr[1]) {
        idx = 0;
        count++;
      }

      if(arr[arr.length-1] == arr[arr.length-2]) {
        idx = arr.length-1;
        count++;
      }

      int ans =1;
      boolean zerolst;
      if(arr[0] == '0')
        zerolst = true;
      else 
        zerolst = false;

      for(int i=1; i<n; i++) {
        if(arr[i] == '1') {
          if(zerolst) ans++;
          zerolst = false;
        }
        else if(arr[i] == '0') {
          if(!zerolst) ans++;
          zerolst = true;
        }
      }

      for(int i=2; i<n-1; i++) {
        if(arr[i] == arr[i-1]) {
          count++;
        }
      }

      if(ans == n) {
        System.out.println(n);
      }
      else if (count == 1 && (idx == 0 || idx == n-1)) {
        System.out.println(Math.min(ans + 1, n));
      }
      else {
        System.out.println(Math.min(n, ans + 2));
      }
      
      out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { 
            try {
                br = new BufferedReader(new InputStreamReader(System.in)); 
            }
            catch(Exception e){

            }
        }

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

