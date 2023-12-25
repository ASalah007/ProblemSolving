import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> p = new PriorityQueue<>((Pair i, Pair j) -> {
            if(i.f < j.f ) return -1;
            if (i.f > j.f) return 1;
            return 0;
        });
        for(int i = 0; i<points.length; i++){ 
            p.offer(new Pair(Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]), points[i]));
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){ 
            ans[i] = p.poll().s;
        }
        return ans;
    }

}

class Pair  {
    double f;
    int[] s; 

    public Pair(double f, int[] s){ 
        this.f = f;
        this.s = s;
    }
}
