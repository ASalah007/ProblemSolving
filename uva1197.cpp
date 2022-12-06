#include <bits/stdc++.h>
using namespace std;

class UF {
 public:
  vector<int> parent, rank;
  UF(int n) {
    for (int i = 0; i < n; i++) {
      parent.push_back(i);
      rank.push_back(0);
    }
  }

  int find(int a) {
    if (parent[a] == a) return a;
    return parent[a] = find(parent[a]);
  }

  bool is_connected(int a, int b) { return find(a) == find(b); }

  void connect(int a, int b) {
    if (is_connected(a, b)) return;
    int x = find(a);
    int y = find(b);

    if (rank[y] > rank[x])
      parent[x] = y;
    else {
      parent[y] = x;
      if (rank[x] == rank[y]) rank[x]++;
    }
  }
};

int main() {
  int n, m;
  cin >> n >> m;
  while (n != 0 || m != 0) {
    UF s(n);
    while (m--) {
      int c;
      cin >> c;
      int a;
      cin >> a;

      for (int i = 1; i < c; i++) {
        int t;
        cin >> t;
        s.connect(a, t);
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (s.is_connected(0, i)) ans++;
    }
    cout << ans << endl;
    cin >> n >> m;
  }
}
