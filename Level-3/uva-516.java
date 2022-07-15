import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static HashMap<Integer, Integer> getpf(int n) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        int i = 2;
        for(; i*i<=n; i++) {
            while(n%i ==0) {
                ans.put(i, ans.getOrDefault(i, 0)+1);
                n/=i;
            }
        }

        if(n>1) {
            ans.put(n, ans.getOrDefault(n, 0)+1);
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
        String input = in.nextLine();
        String[] nums = input.split(" ");
        while(Integer.parseInt(nums[0]) != 0){
            int n=1;
            for(int i=0; i<nums.length; i+=2){
                int b = Integer.parseInt(nums[i]);
                int p = Integer.parseInt(nums[i+1]);
                while(p-->0){
                    n *= b;
                }
            }
            n-=1;
            // System.out.println(n);
            HashMap<Integer, Integer> hm = getpf(n);
            // System.out.println(hm.keySet());
            ArrayList<Integer> arr = new ArrayList<>(hm.keySet());
            arr.sort((f,s) -> s.compareTo(f));
            for(int i=0; i<arr.size() -1; i++) {
                out.print(arr.get(i) + " " + hm.get(arr.get(i)) + " ");
            }
            out.println(arr.get(arr.size()-1) + " " +hm.get(arr.get(arr.size()-1)));
            input = in.nextLine();
            nums = input.split(" ");
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

