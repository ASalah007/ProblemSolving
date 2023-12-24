import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> memo; 
    public int numDecodings(String s) {
        memo = new HashMap<>();
        int ans = numDecodings(s, 0);
        if (ans < 0) return 0;
        return ans;
    }

    private int numDecodings(String s, int i){ 
        if(i >= s.length()) return 1;
        if (memo.containsKey(i)) return memo.get(i);
        int ans = 0;
        if(isValidNumber(s, i, i+1)) ans += numDecodings(s, i+1);
        if(isValidNumber(s, i, i+2)) ans += numDecodings(s, i+2);

        
        memo.put(i, ans);
        return ans;
    }

    private boolean isValidNumber(String s, int st, int ed) { 
        if (ed > s.length()) return false;
        int num = Integer.parseInt(s.substring(st, ed));
        if (num > 26 || num < 1) return false;
        if (ed == st + 2 && s.charAt(st) == '0') return false;
        return true;
    }
}
