/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxPathSum(TreeNode* root) {
      maxPathSum2(root, true);
      return mx;
    }
    int mx = -2000;
    int maxPathSum2(TreeNode* root, bool is_root) {
      if (!root) return -2000;

      int m1 = maxPathSum2(root->left, false);
      int m2 = maxPathSum2(root->right, false);
      
      int ans = max(root->val, root->val + max(m1, m2));

      
      mx = max(mx, root->val + m1 + m2);
      mx = max(mx, ans);

      return ans;
    }
};
