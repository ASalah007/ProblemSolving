#include <bits/stdc++.h>
#include <deque>

using namespace std;

deque<int> timeline;
int cnt[300009];
int oldcnt[300009];
int total;

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);

    int n,q; 
    cin>>n>>q;

    int tp, x;
    timeline.push_back(0);
    while(q--){
        cin>>tp>>x; 

        if(tp == 1){
            timeline.push_front(x);
            cnt[x]++;
            total++;
            cout<<total<<"\n";
        }
        else if(tp ==2){
            total-=cnt[x];
            oldcnt[x] += cnt[x];
            cnt[x] = 0;

            cout<<total<<"\n";
        }
        else{


            int t = timeline.back();
            timeline.pop_back();

            if(t >= x){
                cout<<total<<"\n";
                timeline.push_back(t);
                continue;
            }

            x-=t;
            t+=x;

            for(int j=0; j<x; j++){
                int top = timeline.back();
                timeline.pop_back();

                if(oldcnt[top]>0){
                    oldcnt[top]--;
                }
                else{
                    cnt[top]--;
                    total--;
                }
            }   
            cout<<total<<"\n";
            timeline.push_back(t);
        }
    }
}
