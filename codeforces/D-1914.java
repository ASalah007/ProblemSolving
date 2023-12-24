import java.util.ArrayList;
import java.util.Scanner;
 
public class D_Three_Activities {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int tt = sc.nextInt();
        while(tt --> 0){
            int n = sc.nextInt();
            ArrayList<Pair> a = new ArrayList<>();
            ArrayList<Pair> b = new ArrayList<>();
            ArrayList<Pair> c = new ArrayList<>();
            for(int i = 0; i<n; i++){ 
                a.add(new Pair(i, sc.nextInt()));
            }
            for(int i = 0; i<n; i++){ 
                b.add(new Pair(i, sc.nextInt()));
            }
            for(int i = 0; i<n; i++){ 
                c.add(new Pair(i, sc.nextInt()));
            }
 
            a.sort((Pair f, Pair s) -> s.s - f.s);
            b.sort((Pair f, Pair s) -> s.s - f.s);
            c.sort((Pair f, Pair s) -> s.s - f.s);
 
            long mx = -1;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k<3; k++){
                        Pair ap = a.get(i);
                        Pair bp = b.get(j);
                        Pair cp = c.get(k);
                        if (ap.f == bp.f || ap.f == cp.f || bp.f == cp.f) continue;
                        mx = Math.max(ap.s + bp.s + cp.s, mx);
                    }
                }
            }
            ans.append(mx + "\n");
        }
        System.out.print(ans);
        sc.close();
    }
}
 
class Pair { 
    public int f;
    public int s;
 
    public Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}
