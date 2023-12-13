class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] fq = getFrequencyArray(s1);
        int[] watched = new int[26];
        int i=0, j=0, a=0;

        while (j<s2.length()){ 
            int jIndex = s2.charAt(j) - 'a';
            watched[jIndex]++;
            if (fq[jIndex] >= watched[jIndex]) a++;
            
            if (j - i + 1 > s1.length()){ 
                int iIndex = s2.charAt(i) - 'a';
                watched[iIndex]--;
                if(fq[iIndex] > watched[iIndex]) a--;
                i++;
            }

            if (j - i + 1 == s1.length() && a == s1.length()) return true;
            j++;
        }
        return false;

    }

    private int[] getFrequencyArray(String s1){ 
        int[] fq = new int[26];
        for (int i = 0; i<s1.length(); i++){ 
            fq[s1.charAt(i) - 'a']++;
        }
        return fq;
    }
}
