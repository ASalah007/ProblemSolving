class Solution {
public:
    string frequencySort(string s) {
        
        unordered_map<char, int> fq;
        for (char c : s){
            fq[c] ++;
        }
        
        vector<pair<char, int>> vec;
        
        for (auto&i : fq){
            vec.push_back(make_pair(i.first, i.second));
        }
        
        sort(vec.begin(), vec.end(), [](auto f, auto s){return f.second > s.second;});
        
        string ans;
        for (pair<char, int> p : vec){
            for (int i = 0; i<p.second; i++){
                ans.push_back(p.first);
            }
        }
        return ans;
        
        
    }
};
