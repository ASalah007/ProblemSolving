class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int st = 1, ed = 1_000_000_001;
        while (st < ed) {
            int md = (st + ed) / 2;
            if (canEatBeforeGuardComes(piles, md, h)) ed = md;
            else st = md + 1;
        }
        return ed;
    }

    private boolean canEatBeforeGuardComes(int[] piles, int k, int h) { 
        for (int pile : piles) {
            h -= (int)Math.ceil((double) pile / k);
        }
        return h >= 0;
    }
}
