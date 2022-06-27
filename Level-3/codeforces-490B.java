import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main{
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int[] cnt = new int[1000009];
    static int[] front = new int[1000009];
    static int[] back = new int[1000009];

    public static void main(String[] args){
        int n = in.nextInt();
        int[] arr = new int[n];

        Arrays.fill(cnt, 2);

        while(n-->0){
            int a = in.nextInt(), b = in.nextInt();
            front[a] = b;
            back[b] = a;
            cnt[a]--;
            cnt[b]++;
        }
        

        int start=0;
        for(int i=0; i<1000009; i++){
            if(cnt[i] == 1){
                start = i;
                break;
            }
        }
        int lst =0;
        for(int i =1; i<arr.length; i+=2){
            arr[i] = front[lst];
            lst = arr[i];
        }

        lst =0;
        if(arr.length%2 == 0)
        for(int i = arr.length-2; i>=0; i-=2){
            arr[i] = back[lst];
            lst = arr[i];
        }
        else{
            arr[0] = start;
            for(int i=2; i<arr.length; i+=2){
                arr[i] = front[start];
                start = arr[i];
            }
        }

        for(int ans : arr){
            out.print(ans+" ");
        }
        out.println();
        out.close();

    }
}

