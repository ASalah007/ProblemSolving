import java.io.PrintWriter;
import java.util.*;

public class Main {
    static int n,m;
    static PriorityQueue<Range> availRangeQueue = new PriorityQueue<>(10000, Comparator.comparingInt(ele -> ele.rank));

    public static void main(String... args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();

        var rangeArr = new ArrayList<Range>(n+1);
        var ans = new int[n+1];

        int a,b,c,lastWin;
        for(int i=1; i<=m; i++){
            a= in.nextInt();
            b= in.nextInt();
            c= in.nextInt();
            rangeArr.add(new Range(a,b,c,i));
        }
        lastWin = rangeArr.get(rangeArr.size()-1).winner;
        
        // sort the ranges according to the starting position in a descending order
        Collections.sort(rangeArr, (first, second) -> Integer.compare(second.start, first.start));
        
        var currRange = rangeArr.get(rangeArr.size()-1);
        rangeArr.remove(rangeArr.size() -1);
        for(int i=1; i<=n; i++){
            if(i == lastWin)
                continue;
            
            // get the ranges that started and put it in the priority queue
            while(!rangeArr.isEmpty() && rangeArr.get(rangeArr.size()-1).start <= i){
                availRangeQueue.add(rangeArr.get(rangeArr.size()-1));
                rangeArr.remove(rangeArr.size()-1);
            }
            
            // check if the current range ended and get a new range
            while(currRange.end < i)
                currRange = availRangeQueue.poll();
            clear(i);
            
            // make sure that the current range is the range with minimum rank
            if(!availRangeQueue.isEmpty() && availRangeQueue.peek().rank < currRange.rank){
                availRangeQueue.add(currRange);
                currRange = availRangeQueue.poll();
            }
            clear(i);
            
            
            if(currRange.winner == i){
                var temp = new ArrayList<Range>();
                while(availRangeQueue.peek().winner == i){
                    temp.add(availRangeQueue.poll());
                    clear(i);
                }
                ans[i] = availRangeQueue.peek().winner;
                for(Range r : temp){
                    availRangeQueue.add(r);
                }
            }
            else{
                ans[i] = currRange.winner;
            }
        }
        ans[lastWin] = 0;

        for(int i=1; i<=n; i++){
            out.print(ans[i] +" ");
        }
        out.close();
    }
    
    // this function preserves that the top of the queue is a valid range 
    public static void clear(int currPosition){
        while(!availRangeQueue.isEmpty() && availRangeQueue.peek().end < currPosition)
            availRangeQueue.poll();
    }
    
    public static class Range{
        public int start;
        public int end;
        public int winner;
        public int rank;
        public Range(int s, int e, int w, int r){
            start =s;
            end =e;
            winner =w;
            rank = r;
        }
    }
}
