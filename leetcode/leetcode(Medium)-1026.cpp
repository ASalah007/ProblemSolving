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

class Node{ 
public: 
  int mn;
  int mx; 
  Node* left;
  Node* right;
  int val;
};

class Solution {
public:
    int maxAncestorDiff(TreeNode* root) {
      Node* tree = new Node();
      build(root, tree);
      int mx = 0;
      maxRange(tree, mx);
      return mx;
    }

    void build(TreeNode* root, Node* tree){
      if(!root) return;
      tree->val = root->val;
      if(!root->left && !root->right){
        tree->mn = root->val;
        tree->mx = root->val;  
        return ;
      }


      if (root->left){
        tree->left = new Node();
        build(root->left, tree->left);
      }
      if(root->right){
        tree->right = new Node();
        build(root->right, tree->right);
      }

      if(!tree->right){
        tree->mn = min(tree->val, tree->left->mn);
        tree->mx = max(tree->val, tree->left->mx);
      }
      else if (!tree->left){
        tree->mn = min(tree->val, tree->right->mn);
        tree->mx = max(tree->val, tree->right->mx);
      }
      else {
        tree->mn = min(tree->left->mn, tree->right->mn);
        tree->mn = min(tree->val, tree->mn);

        tree->mx = max(tree->left->mx, tree->right->mx);
        tree->mx = max(tree->val, tree->mx);

      }
      
    }

    void maxRange(Node* tree, int& mx){
      if(!tree) return;
      mx = max(mx, abs(tree->val - tree->mn));
      mx = max(mx, abs(tree->val- tree->mx));
      maxRange(tree->left, mx);
      maxRange(tree->right, mx);
    }

};
