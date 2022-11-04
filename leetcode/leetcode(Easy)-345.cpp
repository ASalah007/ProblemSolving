class Solution {
public:
    string reverseVowels(string s) {
        int i=0, j=s.size()-1;
        string vowels = "aeiouAEIOU";
        while(i<j)
            if(std::find(vowels.begin(), vowels.end(), s[i]) == vowels.end())
                i++;
            else if(std::find(vowels.begin(), vowels.end(), s[j]) == vowels.end())
                j--;
            else
                swap(s[i++], s[j--]);
        return s;
    }
};
