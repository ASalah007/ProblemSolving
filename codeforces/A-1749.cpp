
#include <bits/stdc++.h>

#define ll long long
#define vi vector<int>
using namespace std;
 
int main() {
  int t; cin>>t;
 
  while(t--){
    int n, m; cin>>n>>m;
    if (m > n){
      cout<<"NO\n";
      continue;
    }
    int rows[n+10];
    int cols[n+10];
    memset(rows, 0, sizeof(rows));
    memset(cols, 0, sizeof(cols));
 
    int no =0;
    for(int i=0; i<m; i++){
      int a, b;
      cin>>a>>b;
      rows[a]++;
      cols[b]++;
      if(rows[a] >= 2){
        no++;
      }
 
      if(cols[b] >= 2){
        no++;
      }
 
    }
    if(no > 1 || (no == 0 && n == m)){
      cout<<"NO\n";
    }
    else {
      cout<<"YES\n";
    }
  }
}
