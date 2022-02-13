import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int t;
    public static void main(String[] args){
     
        t =sc.nextInt();
        while(t-->0){
            out.println("SOLN       COLUMN");
            out.println(" #      1 2 3 4 5 6 7 8\n");
            int i = sc.nextInt(); 
            int j = sc.nextInt();
            //System.out.println(i+" "+j);
            bt(i, j);
        }
       out.close();
    }

    static final int OFFSET = 100;
    static boolean[] diagonlas = new boolean[OFFSET+100];
    static boolean[] cols = new boolean[10];
    static boolean[] rows = new boolean[10];
    static ArrayList<String> sols = new ArrayList<>();
    
    public static void bt(int i , int j){
        
        mark(i, j, true);
        sols.clear();
    
        realbt(j, i, 1, new ArrayList<Integer>());
        
        mark(i, j, false);

        Collections.sort(sols);
        for(int s =1; s<=sols.size(); s++){
            out.println(((s>=10)?"":" ")+s+"      "+sols.get(s-1));
        }
        if(t != 0)
            out.println();

    }
    public static void realbt(int bcol, int brow, int col, ArrayList<Integer> sol){
        if(col == 9){
            StringBuilder out = new StringBuilder();
            for(int i =0; i<sol.size(); i++){
                out.append(sol.get(i)+ ((i!=sol.size()-1)?" ":""));
            }
            sols.add(out.toString());
        }

        if(bcol == col){
            sol.add(brow);
            realbt(bcol,brow, col+1, sol);
            sol.remove(sol.size()-1);
        }
        else
        for(int i=1; i<=8; i++){
            if(isValid(i, col)){
                mark(i, col, true);
                sol.add(i);
                
                realbt(bcol, brow, col+1, sol);

                sol.remove(sol.size() -1);
                mark(i, col, false);
            }
        }
    }

    static void mark(int i, int j, boolean b){
        cols[j] = b;
        rows[i] = b;
        diagonlas[OFFSET + j - i] = b;
        diagonlas[j + i] = b;
    }
    static boolean isValid(int i, int j){
        return cols[j] == false 
                &&
                rows[i] == false 
                &&
                diagonlas[OFFSET + j - i] == false 
                &&
                diagonlas[j + i] == false;
    }
}
