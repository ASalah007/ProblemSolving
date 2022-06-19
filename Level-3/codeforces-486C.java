import java.io.*;
import java.util.*;

public class Main{
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args){
        int n = in.nextInt(), p = in.nextInt()-1;
        String str = in.next();

        int from,to;
        if(p >= n/2){
            from = n/2;
            to = n-1;
        }
        else{
            from = 0;
            to = n/2 -1;
        }


        int verans =0;
        int horans1=0, horans2=0;
        for(int i=p; i<=to; i++){
            int a = Math.abs(str.charAt(n-1-i) - str.charAt(i));
            if(a == 0) continue;
            verans += Math.min(a, 26-a);
            horans1 =i - p;
        }

        for(int i=p-1; i>=from; i--){
            int a = Math.abs(str.charAt(n-1-i) - str.charAt(i));
            if(a == 0) continue;
            verans += Math.min(a, 26-a);
            horans2 = p - i;
        }

        int ans = verans + horans1 + horans2 + Math.min(horans1, horans2);
        System.out.println(ans);
    }

}

