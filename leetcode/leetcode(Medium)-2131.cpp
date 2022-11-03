
class Solution {
 public:
  int longestPalindrome(vector<string>& words) {
    map<string, int> fq;
    int ans = 0;
    for (string a : words) {
      fq[a]++;
    }

    bool odd = false;
    for (pair<string, int> i : fq) {
      cout << i.first << " " << i.second << endl;

      string temp(i.first);
      reverse(temp.begin(), temp.end());
      if (temp == i.first) {
        if (i.second % 2 == 0) {
          ans += 2 * i.second;
        } else {
          ans += 2 * (i.second - 1);
          odd = true;
        }
      } else {
        int mn = min(i.second, fq[temp]);
        ans += 4 * mn;
        fq[i.first] -= mn;
        fq[temp] -= mn;
      }
    }
      
    if (odd) ans += 2;
    return ans;
  }
};
