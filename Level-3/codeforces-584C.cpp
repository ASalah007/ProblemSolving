#include <bits/stdc++.h>
#include <cmath>
 
#define ll long long
#define vi vector<int>
using namespace std;
 
 
bool st[(int)1e5 + 10];
bool done[(int)1e5 + 10];
string a,b,ans;
int n, t, originT;
 
void change(int num){
  bool f = true;
  for(int i=0; i<n; i++) {
    if(done[i] || st[i]) continue;
    if(num == 0) break;
    if(f) ans[i] = a[i];
    else ans[i] = b[i];
    f = !f;
    num--;
    done[i] = true;
  }
}
 
char getDiff(char a, char b){
  if('a' != a && b != 'a'){
    return 'a';
  }
  if('b'!=a && b != 'b') {
    return 'b';
  }
  return 'c';
}
void changeBoth(int num){
  for (int i=0; i<n; i++) {
    if(st[i] || done[i]) continue;
    if(num == 0) return;
    ans[i] = getDiff(a[i], b[i]);
    num--;
    done[i] = true;
  }
 
  for (int i=0; i<n; i++) {
    if(done[i]) continue;
    if(num == 0) return;
    ans[i] = getDiff(a[i], b[i]);
    num--;
    done[i] = true;
  }
}
 
bool check(){
  int t1 =0, t2=0;
  for(int i=0; i<n; i++) {
    if(ans[i] != a[i]) t1++;
    if(ans[i] != b[i]) t2++;
  }
  if(t1!=originT || t2!=originT) {
    return false;
  }
  return true;
}
 
int main(){
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(0);
 
  cin>>n>>t;
  cin>>a>>b;
  originT = t;
  ans = a;
 
  /* memset(st, false, sizeof st); */
  /* memset(done, false, sizeof done); */
 
  int diff = 0;
  int sim = 0;
 
  for(int i=0; i<n; i++) {
    if(a[i] == b[i]) {
      st[i] = true;
      sim++;
    }
    else
      diff++;
  }
 
 
  if(diff > 2*t) {
    cout<<-1;
  }
  else if(t >= diff) {
    changeBoth(t);
    cout<<ans<<endl;
  }
  else { // <= 2t
    /* cout<<"diff: "<<diff<<endl; */
    /* cout<<"sim: "<<sim<<endl; */
 
    if(diff % 2 == 1) {
      changeBoth(1);
      diff--;
      t--;
    }
    /* cout<<"after odd:" <<ans<<endl; */
 
    while(sim + diff/2 < t){
      changeBoth(2);
      diff -=2;
      t -=2;
    }
    /* cout<<"after while:" <<ans<<endl; */
 
    change(diff);
    /* cout<<"after change:"<<ans<<endl; */
    changeBoth(t - diff/2);
    /* cout<<"after change both: "<<ans<<endl; */
    if(check()){
      cout<<ans<<endl;
    }
    else {
      cout<<-1<<endl;
    }
 
  }
}
