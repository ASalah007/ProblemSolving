class Solution {
public:
    int maxLength(vector<string>& arr) {
        vector<bool> vis(200, false);
        return solve(arr, vis, 0, 0);
    }
    
    int can_be_taken (vector<bool>& vis, string s) {
        int fq[200] = {0};
        for (char c : s) {
            fq[c]++;
            if(vis[c] == true || fq[c] > 1){
                return false;
            }
        }
        return true;
    }
    
    void take (vector<bool>& vis, string s) {
        for (char c : s){
            vis[c] = true;
        }
    }
    
    void untake(vector<bool>& vis, string s){
        for (char c : s) {
            vis[c] = false;
        }
    }
    
    int solve(vector<string>& arr, vector<bool>& vis,  int i, int acc){
        if (i == arr.size()) {
            return acc;
        }
    
        int mx = 0;
        if (can_be_taken(vis, arr[i])) {
            take(vis, arr[i]);
            mx = max(mx, solve(arr, vis, i+1, acc+arr[i].size()));
            untake(vis, arr[i]);
        }
        mx = max(mx, solve(arr, vis, i+1, acc));
        return mx;
    }
};
