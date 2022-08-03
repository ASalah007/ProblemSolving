#include <bits/stdc++.h>
#include <cmath>

#define ll long long
#define vi vector<int>
using namespace std;



int arr[(int)5e4 +10];
int rad[(int)5e4 +10];
int hit[(int)5e4 +10];
int cen[(int)5e4 +10];

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);

    int n;
    cin>>n;
    memset(arr, -1, sizeof arr);
    memset(hit, -1, sizeof hit);
    for (int i = 0; i < n; i++) {
      int c, r;
      cin>>c>>r;
      c += 30000;
      rad[c] = r;
      cen[i] = c;
      for (int j = c-r; j <= c+r; j++) {
        if(arr[j]  != -1) arr[j] = -2; else arr[j] = c; 
      }
    }


    int m;
    cin>>m;
    int ans = 0;
    for( int i=1; i<=m; i++){
      int x, y;
      cin>>x>>y;
      x+= 30000;
      if(arr[x] == -1) continue;

      if(arr[x] == -2 && y == 0) {

        if(hit[arr[x-1]] == -1) {
          hit[arr[x-1]] = i;
          ans++;
        }
        if(hit[arr[x+1]] == -1) {
          hit[arr[x+1]] = i;
          ans++;
        }
        
      }
      else {
        int c = arr[x], r= rad[c];
        if((x-c)*(x-c) + y*y <= r*r) {
          if(hit[c] == -1) {
            ans++;
            hit[c] = i;
          }
        }

      }
    }
    cout<<ans<<"\n";
    for(int i=0; i<n; i++){
      cout<<hit[cen[i]]<< " ";
    }
    cout<<endl;

}


