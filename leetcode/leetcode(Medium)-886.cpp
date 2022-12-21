class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
      vector<vector<int>> graph(2001);
      vector<int> colors(2001, 0);
      for(vector<int> pair : dislikes){
        graph[pair[0]].push_back(pair[1]);
        graph[pair[1]].push_back(pair[0]);
      }
      bool ans = true;
      for(int i=0; i<graph.size(); i++){
        if(graph[i].size() > 0 && colors[i] == 0){
          ans = ans&& dfs(i, -1, graph, colors);
        }
      }
      return ans;
    }

    bool dfs(int i, int prevcolor, vector<vector<int>>& graph, vector<int>& colors){
      colors[i] = (prevcolor == 1)? 2 : 1;
      for(int j = 0; j<graph[i].size(); j++){
        if(colors[graph[i][j]] == colors[i]) return false;
        if(colors[graph[i][j]] == 0) dfs(graph[i][j], colors[i], graph, colors);
      }
    
      return true;
    }
};
