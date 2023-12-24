import java.util.Scanner;
 
public class A_Problemsolving_Log { 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int tt = sc.nextInt();
        while(tt --> 0){
            int m = sc.nextInt();
            String p = sc.next();
            int[] time = new int[26];
            for(int i =0; i<p.length(); i++) {
                char problem = p.charAt(i);
                time[problem - 'A']++;
            }
            int solvedCount = 0;
            for(int i=0; i<26; i++){ 
                if (time[i] >= i + 1) solvedCount ++;
            }
 
            ans.append(solvedCount + "\n");
        }
        System.out.println(ans);
        sc.close();
    }
}
