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

    set<int> *s2;

    if (r[x] > r[y]) {
      p[y] = x;
      s2 = &e[y];
    } else {
      p[x] = y;
      s2 = &e[x];
      if (r[x] == r[y]) r[y]++;
    }

    // your enemeies are my enemies
    // and your enemeis are just one set
    if (!s2->empty()) set_enemies(x, *(s2->begin()));
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

    // your enemies are my friends
    // all of your enemies are just one big set of friends
    if (!s1.empty()) set_friends(y, *(s1.begin()));
    if (!s2.empty()) set_friends(x, *(s2.begin()));

    s1.insert(y);
    s2.insert(x);
  }
};

int main() {
  // freopen("in.txt", "r", stdin);
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
        cout << w->is_friends(x, y) << "\n";
        break;
      case 4:
        cout << w->is_enemies(x, y) << "\n";
        break;
    }
  }
}
