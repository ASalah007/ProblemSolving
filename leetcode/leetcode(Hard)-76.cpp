class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> fq(200, 0);
        vector<int> seen(200, 0);
        
        for(char c : t)
            fq[c]++;   
    
        int ml = 0, mr = s.size()-1, cl = 0, cr = 0, req = t.size(), have = 0;
        
        for(int i=0; i<s.size(); i++){
            char c = s[i];
            if(fq[c] == 0) 
                continue; 
            cr = i;
            
            seen[c]++;
            if(seen[c] <= fq[c]) 
                have++;

            while((seen[s[cl]] > fq[s[cl]] || fq[s[cl]] <= 0) && have == req) 
                seen[s[cl++]]--;
            
            if(have == req && cr - cl < mr - ml){
                ml = cl;
                mr = cr;
            }
        }
        
        if(have < req) 
            return "";
        
        string ans;
        for (int i=ml; i<=mr; i++)
            ans.push_back(s[i]);
        
        return ans;
    }
       
};
