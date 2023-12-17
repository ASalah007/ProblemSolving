import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] LETTERS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> comps = letterCombinations(digits, 0);
        List<String> ans = new ArrayList<>();
        for(String comp : comps){ 
            ans.add(comp.toString());
        }
        return ans;
    }

    private List<String> letterCombinations(String digits, int currDigitIdx){ 
        if(currDigitIdx > digits.length() - 1) return new ArrayList<>();

        if (currDigitIdx == digits.length() - 1) { 
            List<String> comps = new ArrayList<>();
            String letters = LETTERS[digits.charAt(currDigitIdx) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                comps.add(Character.toString(letters.charAt(i)));
            }
            return comps;
        }

        List<String> rest = letterCombinations(digits, currDigitIdx + 1);
        List<String> comps = new ArrayList<>();
        for (String comp : rest){ 
            String letters = LETTERS[digits.charAt(currDigitIdx) - '0'];
            for(int i =0; i<letters.length(); i++) { 
                comps.add(Character.toString(letters.charAt(i)) + comp);
            }
        }
        return comps;
    }
}
