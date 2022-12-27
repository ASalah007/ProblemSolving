#include <bits/stdc++.h>
using namespace std;

class ST {
 public:
  vector<int> st, val;
  int left(int p) { return p << 1; }
  int right(int p) { return (p << 1) + 1; }
  int overlap(int l, int r, int i, int j) {
    if (i > r || j < l) return 0;
    if (i <= l && j >= r) return 1;
    return 2;
  }
  int n;
  ST(vector<int> arr) {
    val = arr;
    n = (int)arr.size();
    st.assign(4 * n, 0);
    build(1, 0, n - 1);
  }

  int build(int p, int l, int r) {
    if (l == r) {
      st[p] = val[l];
      return val[l];
    }
    int v1 = build(left(p), l, (r + l) / 2);
    int v2 = build(right(p), (r + l) / 2 + 1, r);
    st[p] = v1 + v2;
    return st[p];
  }
  int rsq(int p, int l, int r, int i, int j) {
    if (overlap(l, r, i, j) == 0) return 0;
    if (overlap(l, r, i, j) == 1) return st[p];

    int v1 = rsq(left(p), l, (l + r) / 2, i, j);
    int v2 = rsq(right(p), (l + r) / 2 + 1, r, i, j);
    return v1 + v2;
  }

  int update(int p, int l, int r, int i, int v) {
    if (i > r || i < l) return st[p];
    if (l == r) {
      if (l == i) st[p] = v;
      return st[p];
    }
    int v1 = update(left(p), l, (r + l) / 2, i, v);
    int v2 = update(right(p), (r + l) / 2 + 1, r, i, v);
    st[p] = v1 + v2;
    return v1 + v2;
  }

  int update(int i, int v) { return update(1, 0, n - 1, i, v); }
  int rsq(int i, int j) { return rsq(1, 0, n - 1, i, j); }
};

int main() {
  std::ios_base::sync_with_stdio(false);
  //freopen("in.txt", "r", stdin);

  int n;
  int i = 1;
  cin >> n;
  while (n != 0) {
    cout << "Case " << i << ":\n";
    vector<int> arr;
    for (int i = 0; i < n; i++) {
      int a;
      cin >> a;
      arr.push_back(a);
    }
    ST* st = new ST(arr);

    char command;
    while (cin >> command && command != 'E') {
      int a, b;
      cin >> a >> b;
      if (command == 'M') {
        cout << st->rsq(a - 1, b - 1) << "\n";
      } else {
        st->update(a - 1, b);
      }
    }
    cin >> command >> command;

    cin >> n;
    if (n != 0) cout << endl;
    i++;
  }
}
