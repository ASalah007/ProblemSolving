#include <bits/stdc++.h>
using namespace std;

vector<int> skipp(string& a, int w, int i) {
  if (a[i] != 'p') return {i + 1, a[i] == 'f' ? w : 0};

  int lasti = i + 1;
  int black = 0;
  int neww = w / 4;
  for (int j = 0; j < 4; j++) {
    vector<int> temp = skipp(a, neww, lasti);
    lasti = temp[0];
    black += temp[1];
  }
  return {lasti, black};
}

vector<int> countBlack(string& a, string& b, int w, int i, int j) {
  // cout << i << " " << j << " " << w << endl;
  int newi = i + 1, newj = j + 1;
  int black = 0;
  char ai = a[i], bj = b[j];

  if (ai == 'p' && bj == 'p') {
    for (int k = 0; k < 4; k++) {
      vector<int> ans = countBlack(a, b, w / 4, newi, newj);
      black += ans[0];
      newi = ans[1];
      newj = ans[2];
    }
  }

  else if (ai == 'p' || bj == 'p') {
    vector<int> temp;
    if (ai == 'p') {
      temp = skipp(a, w, i);
      newi = temp[0];
    } else {
      temp = skipp(b, w, j);
      newj = temp[0];
    }
    if (ai == 'f' || bj == 'f')
      black += w;
    else
      black += temp[1];

  }

  else if (ai == 'f' || bj == 'f') {
    black += w;
  }

  return {black, newi, newj};
}

int main() {
  int n;
  cin >> n;
  while (n--) {
    string a, b;
    cin >> a >> b;
    vector<int> ans = countBlack(a, b, 1024, 0, 0);
    cout << "There are " << ans[0] << " black pixels.\n";
  }
}
