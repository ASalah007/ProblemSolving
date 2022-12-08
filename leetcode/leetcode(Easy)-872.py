class Solution(object):
    def leafSimilar(self, root1, root2):
      leaf_1 = self.get_leaf_node(root1)
      leaf_2 = self.get_leaf_node(root2)
      return leaf_1 == leaf_2

    def get_leaf_node(self, tree):
      if not tree:
        return []
      
      if not tree.left and not tree.right:
        return [tree.val]

      return self.get_leaf_node(tree.left) + (self.get_leaf_node(tree.right))
