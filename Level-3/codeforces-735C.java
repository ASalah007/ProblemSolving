import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

  static long n;
  public static void main(String[] args) throws Exception{
    n = in.nextLong();
    if(n < 4) {
      System.out.println(n-1);
      return;
    }

    long a = 2, b =3;
    long ans = 2;

    while(n>=a+b) {

      ans++;
      long temp = a;
      a = b;
      b = temp + b;

    }
    System.out.println(ans);

  }



  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
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

