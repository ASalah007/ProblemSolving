import java.util.Scanner;
 
public class B_Preparing_for_the_Contest {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int tt = sc.nextInt();
        while(tt --> 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            for(int i = 1; i<=k; i++) {
                ans.append(i+" ");
            }
            ans.append(n + " ");
            for(int i=n-1; i>k; i--){ 
                ans.append(i+" ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
        sc.close();
    }
}
