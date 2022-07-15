import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Main{
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static List<Long> getpf(long n) {
        List<Long> ans = new LinkedList<Long>();
        long i = 2;
        for(; i*i<=n; i++) {
            while(n%i ==0) {
                ans.add(i);
                n/=i;
            }
        }

        if(n>1) {
            ans.add(i);
        }
        return ans;
    }
    public static List<Long> getDivisors(long n) {
        List<Long> ans = new LinkedList<Long>();
        long i = 2;
        for(; i*i<n; i++) {
            if(n%i ==0) {
                ans.add(i);
                ans.add(n/i);
            }
        }

        ans.add(1l);
        if(i*i == n) {
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args){
        long k = in.nextLong();
        while(k != 0){
            boolean neg = false;
            if (k <0) {
                neg = true;
                k = Math.abs(k);
            }
            List<Long> divs = getDivisors(k);
            long ans= 1l;
            for(int j = 0; j<divs.size(); j++) {
                long i = divs.get(j);
                long p = 0;
                long n = k;
                if(i == 1) continue;
                while((n%i) == 0 && n>0) {
                    n/=i;
                    p++;
                }
                if(n==1) {
                    if(neg && p % 2 == 0) continue;
                    ans = p;
                    break;
                }
            }
            out.println(ans);
            k = in.nextLong();
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

