#include <bits/stdc++.h>
#include <functional>

using namespace std;

char maze[505][505];
bool visited[505][505];
int n,m,k,s;

bool isvalid(int i, int j){
    return i>=0 && j>=0 && i<n && j<m;
}

int di[] {1,-1,0,0};
int dj[] {0,0,-1,1};


void dfs(int i, int j){
    if(visited[i][j] || maze[i][j] == '#') return;
    visited[i][j] = true;
    if(s ==0)
        maze[i][j] = 'X';
    else
        s--;

    for(int k = 0; k<4; k++){
        int newi = i+di[k];
        int newj = j+dj[k];
        if(isvalid(newi, newj))
            dfs(newi, newj);
    }
}
int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);

    cin>>n>>m>>k;

    int sti,stj;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            visited[i][j] = false;
            cin>>maze[i][j];
            if(maze[i][j] == '.'){
                s++;
                sti=i;
                stj=j;
            }
        }
    }
    s-=k;
    dfs(sti, stj);

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cout<<maze[i][j];
        }
        cout<<endl;
    }
}
