class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
       int arr1=0,arr2=0,s1=0, s2=0;
        int sz1 =0, sz2=0;
        while(arr1 < word1.size() && arr2 < word2.size()){
            if(s1 >= word1[arr1].size()){
                s1 = 0; 
                arr1++;
                
                continue;
            }
            
            if(s2 >= word2[arr2].size()){
                s2 = 0; 
                arr2++;
                continue;
            }
            
            if(word1[arr1][s1] != word2[arr2][s2]){
                return false;
            }
            s1++;
            s2++;
        }
     
        if(arr2 == word2.size()) return false;
        return s2>=word2[arr2].size() && arr2+1 == word2.size();
    }
};
