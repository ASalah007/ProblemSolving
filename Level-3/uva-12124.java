import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    static Scanner in = new Scanner(System.in);
    static StringBuilder out = new StringBuilder();
    
    public static void main(String[] args){
        int t= in.nextInt();

        for(int i=1; i<=t; i++){
            int n = in.nextInt(), b=in.nextInt();
            HashMap<String, LinkedList<Pair<Integer, Integer>>> hm = new HashMap<>();
            
            for(int j=0; j<n;  j++){
                String type = in.next();
                in.next();
                int p = in.nextInt();
                int q = in.nextInt();
                if(hm.get(type) == null){
                    hm.put(type, new LinkedList<>());
                }
                hm.get(type).addLast(new Pair<>(q, p));
            }
           
            PriorityQueue<Pair<String, Pair<Integer, Integer>>> ans = new PriorityQueue<>(Comparator.comparingInt(p-> p.second.first));
            int ansp = 0;
            for(String key : hm.keySet()){
                Collections.sort(hm.get(key), Comparator.comparingInt(p -> p.second));
                Pair<Integer, Integer> f = hm.get(key).removeFirst();
                ans.add(new Pair<>(key, f));
                ansp+=f.second;
            }

            while(true){
                Pair<String, Pair<Integer, Integer>> lq = ans.peek();
                if(hm.get(lq.first).isEmpty())
                    break;

                Pair<Integer, Integer> next = hm.get(lq.first).removeFirst();
                
                if(b - (ansp + next.second - lq.second.second) <0)
                    break;

                if(next.first <= lq.second.first)
                    continue;
                
                ansp += next.second;
                ansp -=lq.second.second;
                ans.poll();
                ans.add(new Pair<>(lq.first, next));
            }

            out.append(ans.peek().second.first + "\n");
        }
        System.out.print(out);
    }

    static class Pair<T,K>{
        
        public Pair(T f, K s){
            first = f;
            second = s;
        }
        public T first;
        public K second;
    }
}
