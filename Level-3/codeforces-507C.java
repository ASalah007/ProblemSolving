import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

  static long n;
  public static void main(String[] args) throws Exception{
    long h = in.nextLong(), idx = in.nextLong();
    System.out.println(getNodes(h, idx, true));
  }

  static long getNodes(long h, long idx, boolean goLeft) {
    if(h == 0) {
      if(idx == 1l) return 0;
      else return 1l;
    }

    if(goLeft && idx <= (1l<<(h-1l))) { // less than half of leaf nodes
      return 1l + getNodes(h-1l, idx, !goLeft);
    }
    else if (goLeft) {
      return (1l << h) + getNodes(h-1l, idx - (1l<<(h-1l)), goLeft);
    }
    else if(!goLeft && idx <= (1l<<(h-1l))) {
      return (1l << h) + getNodes(h-1l, idx, goLeft);
    }
    else {
      return 1l + getNodes(h-1l, idx - (1l<<(h-1l)), !goLeft);
    }
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

