class Solution {
 public:
  int minMutation(string start, string end, vector<string>& bank) {
    vector<bool> vis(bank.size(), false);
    int ans = bt(start, end, bank, vis, 0);
    return ans > 10 ? -1 : ans;
  }

  int bt(string start, string end, vector<string>& bank, vector<bool>& vis,
         int i) {
    if (start == end) return 0;
    if (i == bank.size()) return 99999999;

    int mn = 999999999;
    for (int i = 0; i < bank.size(); i++) {
      if (vis[i] || get_mutations(start, bank[i]) != 1) continue;
      cout << get_mutations(start, bank[i]) << endl;
      cout << start << " " << bank[i] << endl;
      vis[i] = true;
      mn = min(mn, bt(bank[i], end, bank, vis, i + 1) + 1);
      vis[i] = false;
    }
    return mn;
  }
  int get_mutations(string st, string ed) {
    int mut = 0;
    for (int i = 0; i < st.size(); i++) {
      if (st[i] != ed[i]) mut++;
    }
    return mut;
  }
};
