import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] hasCat;
    static int m;
    static boolean[] vis;
    public static void main(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(n+1);
        vis = new boolean[n+1];
        hasCat = new int[n+1];
        for(int i=0; i<=n+1; i++) graph.add(new ArrayList<>(5));

        for(int i=1; i<=n; i++){
            hasCat[i] = in.nextInt();
            vis[i] = false;
        }

        int a,b;
        for(int i=1; i<n; i++){
            a= in.nextInt();
            b= in.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(dfs(1, 0));
    }
    static int dfs(int ind, int cc){
        vis[ind] = true;
        if(hasCat[ind] + cc > m) {
            // System.out.println("(" + ind + " " + hasCat[ind] + " " + cc + ")" + "0");
            return 0;
        }
        if(graph.get(ind).size() == 1 && vis[graph.get(ind).get(0)]){
            // System.out.println("("+ind + " " + hasCat[ind] + " " + cc+")");
            return 1;
        }
        int ans = 0;
        var newcc = hasCat[ind] == 1? cc+1:0;
        for(var i : graph.get(ind)){
            //System.out.println("[" + i +"]" + "{" +vis[i]+ "}");
            if(!vis[i]){
                ans += dfs(i, newcc);
            }
        }
        return ans;
    }

    public static class Pair<T>{
        private T first;
        private T second;
        public Pair(){
            first = null;
            second = null;
        }
        public Pair(T first, T second){
            this.first = first;
            this.second = second;
        }
        public T getFirst(){
            return first;
        }
        public T getSecond(){
            return second;
        }

        public void setFirst(T first){
            this.first = first;
        }
        public void setSecond(T second){
            this.second= second;
        }


    }

}
