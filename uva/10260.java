import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.lang.model.util.ElementScanner6;

import static java.lang.Math.*;

public class Main{
    static FastReader in = new FastReader();
    static Scanner sin = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args){
        Map<Character, Character> hm  = new HashMap<>();
        hm.put('B', '1');
        hm.put('F', '1');
        hm.put('P', '1');
        hm.put('V', '1');
        hm.put('C', '2');
        hm.put('G', '2');
        hm.put('J', '2');
        hm.put('K', '2');
        hm.put('Q', '2');
        hm.put('S', '2');
        hm.put('X', '2');
        hm.put('Z', '2');
        hm.put('D', '3');
        hm.put('T', '3');
        hm.put('L', '4');
        hm.put('M', '5');
        hm.put('N', '5');
        hm.put('R', '6');
        hm.put('A', '\0');
        hm.put('E', '\0');
        hm.put('I', '\0');
        hm.put('O', '\0');
        hm.put('U', '\0');
        hm.put('H', '\0');
        hm.put('W', '\0');
        hm.put('Y', '\0');

        StringBuilder sb = new StringBuilder();
        while(sin.hasNext()){
            String s = sin.next();
            char last = '\0';
            for(int i=0; i<s.length(); i++){
                char b = hm.get(s.charAt(i));
                if(b == last) continue;
                last = b;
                if(b == '\0') continue; 
                sb.append(b);
            }
            sb.append("\n");
        }
        System.out.print(sb);
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

