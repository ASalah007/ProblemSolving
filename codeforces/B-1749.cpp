#include <bits/stdc++.h>
#define ll long long
#define vi vector<ll>
using namespace std;
 
 

ll n;
 
int main(){
  ll t; cin>>t;
  while(t--){
    cin>>n;
    ll ans=  0;
    for (ll i=0; i<n; i++){
      int a; cin>>a;
      ans+=a;
    }
 
    ll mx = 0;
    for (ll i=0; i<n; i++){
      ll a; cin>>a;
      ans+=a;
      mx = max(a, mx);
    }
 
    ans-=mx;
    cout<<ans<<endl;
  }
}
