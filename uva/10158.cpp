#include <bits/stdc++.h>
using namespace std;

class War {
 public:
  vector<int> p, r;
  vector<set<int>> e;
  War(int n) {
    for (int i = 0; i < n + 1; i++) {
      p.push_back(i);
      r.push_back(0);
      e.push_back(set<int>());
    }
  }

  int find(int a) {
    if (p[a] == a) return a;
    return p[a] = find(p[a]);
  }

  bool is_friends(int a, int b) { return find(a) == find(b); }
  bool is_enemies(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (std::find(e[x].begin(), e[x].end(), y) != e[x].end()) {
      return true;
    }
    return false;
  }

  void set_friends(int a, int b) {
    if (is_friends(a, b)) return;

    if (is_enemies(a, b)) {
      cout << "-1\n";
      return;
    }

    int x = find(a);
    int y = find(b);

    set<int> *s1, *s2;

    if (r[x] > r[y]) {
      p[y] = x;
      s2 = &e[y];
    } else {
      p[x] = y;
      s2 = &e[x];
      if (r[x] == r[y]) r[y]++;
    }

    for (int i : *s2) {
      set_enemies(x, i);
    }
  }

  void set_enemies(int a, int b) {
    if (is_enemies(a, b)) return;

    if (is_friends(a, b)) {
      cout << "-1\n";
      return;
    }

    int x = find(a);
    int y = find(b);

    set<int> &s1 = e[x], &s2 = e[y];

    for (int i : s1) {
      set_friends(y, i);
    }
    for (int i : s2) {
      set_friends(x, i);
    }
    s1.insert(y);
    s2.insert(x);
  }
};

int main() {
  int n;
  cin >> n;
  War *w = new War(n);
  int c, x, y;

  while (cin >> c >> x >> y && (x != 0 || y != 0 || c != 0)) {
    switch (c) {
      case 1:
        w->set_friends(x, y);
        break;
      case 2:
        w->set_enemies(x, y);
        break;
      case 3:
        cout << w->is_friends(x, y) << endl;
        break;
      case 4:
        cout << w->is_enemies(x, y) << endl;
        break;
    }
  }
}
