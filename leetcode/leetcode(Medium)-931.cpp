class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
      vector<int>* n = &matrix[0];
      for (int i = 1; i < matrix.size(); i++){
        vector<int>* m = new vector<int>;
        for (int j=0; j<matrix[0].size(); j++){
          int mn = n->at(j);
          if(j > 0) 
            mn = min(mn, n->at(j-1));

          if(j < matrix[0].size()-1) 
            mn = min(mn, n->at(j+1));

          m->push_back(mn+matrix[i][j]);
        }
        n = m;
      }
      return *min_element(n->begin(), n->end());
    }
};
