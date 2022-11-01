class Solution {
public:
  vector<int> findBall(vector<vector<int>>& grid) {
      if(grid[0].size()==1){
          return vector<int>{-1};
      }
    
    // mark dead cells
    for (int i=0; i<grid.size(); i++){
      for(int j =0; j<grid[i].size() - 1; j++){
        if(grid[i][j] == 1 && grid[i][j+1] == -1){
          grid[i][j] = 0; 
          grid[i][j+1] = 0;
        }

        if((j == 0 && grid[i][j] == -1)){
          grid[i][j] = 0;

        }
        if((j+1 == grid[i].size()-1 && grid[i][j+1] == 1)){
          grid[i][j+1] = 0;
        }
      }
    }
     
    vector<int> ans;
    for(int k=0; k<grid[0].size(); k++){
      bool finished = false;
      int i = 0;
      int j = k;
      cout<<k<<endl;
      while(!finished){
        cout<<grid[i][j]<<endl;
        cout<<i<< " "<< j<<endl;
        if(grid[i][j] == 0){
          ans.push_back(-1);
          finished = true;
        }
        else if(i==grid.size()-1 && grid[i][j] != 0){
          ans.push_back(j+grid[i][j]);
          finished = true;
        }
        else {
          i+= 1;
          j+= grid[i-1][j];
        }
         
         
         cout<<i<<" "<<j<<endl;
      }
        cout<<endl;
    }
    return ans;
  }
};
