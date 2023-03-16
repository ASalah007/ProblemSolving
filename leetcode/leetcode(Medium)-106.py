class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
      self.search = {val: i for i, val in enumerate(inorder)}
      self.postorder = postorder
      return self._buildTree(0, len(inorder)-1)

    def _buildTree(self, st, ed):
      if ed < st:
        return None
      
      r = TreeNode()
      r.val = self.postorder.pop()
      if st == ed:
        return r
      
      r.right = self._buildTree(self.search.get(r.val)+1, ed)
      r.left = self._buildTree(st, self.search.get(r.val)-1)

      return r
      
