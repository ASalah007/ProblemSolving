#include <bits/stdc++.h>
using namespace std;

class UF{
public:

  vector<int> parent, rank;
  UF(int n){
    for (int i = 0 ; i < n+1; i++){
      parent.push_back(i);
      rank.push_back(0);
    }
  }

    int find(int a){ 
      if (parent[a] == a) return a;
      return parent[a] = find(parent[a]);
    }

    bool is_connected(int a, int b){
      return find(a) == find(b);
    }

    void union_set(int a, int b){
      if (is_connected(a,b)) return;

      int x = find(a); int y = find(b);

      if (rank[y] > rank[x]){ parent[x] = y; }
      else {
        parent[y] = x;
        if (rank[y] == rank[x]){
          rank[x]++;
        }
      }
    }
  };

int main(){
  int t; 
  cin>>t;
  while(t--){
    int n ; cin>>n;
    UF u(n);
    int s=0, uns=0;

    string str;
    getline(cin, str);
    while(getline(cin, str)){
      if(str.size() == 0){
        break;
      }
      stringstream ss(str);
      char c;
      int a, b;
      ss>>c>>a>>b;
      if(c == 'c'){
        u.union_set(a,b);
      }
      else {
        if (u.is_connected(a, b)) s++;
        else uns++;
      }

    }
    cout<<s<<","<<uns<<endl;
    if(t!= 0) cout<<endl;
  }

}

