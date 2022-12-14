#include <bits/stdc++.h>
using namespace std;

int main() {
  // freopen("in.txt", "r", stdin);
  int n;
  while (cin >> n) {
    int m;
    cin >> m;
    string wake;
    cin >> wake;

    vector<vector<int>> graph(200);
    vector<int> woke(200, 0);

    while (m--) {
      char a, b;
      cin >> a >> b;
      graph[a].push_back(b);
      graph[b].push_back(a);
    }

    queue<int> q;
    for (char c : wake) {
      for (int i : graph[c]) {
        q.push(i);
      }
      woke[c] = 4;
    }

    q.push(0);

    int ans = 0;
    int count = 3;
    bool finished = true;
    while (true) {
      int top = q.front();
      // cout << "(" << (char)top << ")" << endl;
      q.pop();
      if (top == 0) {
        if (finished) break;
        finished = true;
        ans++;

        q.push(0);
        continue;
      }

      if (woke[top] == 4) continue;

      if (woke[top] == 2) {
        count++;
        woke[top]++;
        for (int i : graph[top]) {
          if (woke[i] < 3) q.push(i);
        }
        finished = false;
        continue;
      }

      woke[top]++;
      finished = false;
    }
    if (count == n) {
      cout << "WAKE UP IN, " << ans << ", YEARS" << endl;
    } else {
      cout << "THIS BRAIN NEVER WAKES UP" << endl;
    }
  }
}
