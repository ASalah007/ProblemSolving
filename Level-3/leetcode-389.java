class Solution {
    public char findTheDifference(String s, String t) {
        var arr = new int[26];
        for(int i=0; i<26; i++){
            arr[i] = 0;
        }
        for(int i=0; i<s.length(); i++){
            arr[(int) s.charAt(i) - (int) 'a']++;
        }
        for(int i=0; i<t.length(); i++){
            arr[(int) t.charAt(i) - (int) 'a']--;
        }

        for(int i=0; i<26; i++){
            if(arr[i] !=0)
                return (char) ((int) 'a' + i);
        }
        
        return '0';
    }
}
