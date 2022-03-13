import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> openParentheses = new HashSet<>(List.of('(', '{','['));
        
        for(int i=0; i<s.length(); i++){

            if(openParentheses.contains(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }
            else if(stack.isEmpty()){
                return false;
            }

            switch(stack.pop()){
                case '(': 
                    if(s.charAt(i) != ')') return false;
                    break;
                case '{':
                    if(s.charAt(i) != '}') return false;
                    break;
                case '[':
                    if(s.charAt(i) != ']') return false;
                    break;
            }
        }
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}
