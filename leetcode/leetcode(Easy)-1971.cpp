class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
      vector<bool> visited(n, false);
      vector<vector<int>> graph(n);
      for(vector<int> edge: edges){
        graph[edge[0]].push_back(edge[1]);
        graph[edge[1]].push_back(edge[0]);
      }

      return dfs(graph,visited, source, destination);        
    }

    bool dfs(vector<vector<int>>& graph, vector<bool>& vis, int i, int d){
      if(i == d) return true;
      vis[i] = true;
      for(int child: graph[i]){
        bool a = false;
        if(!vis[child] && dfs(graph, vis, child, d)) return true;
      }
      return false;
    }
};
