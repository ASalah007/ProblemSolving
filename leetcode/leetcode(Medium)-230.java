class Solution {
    private int ans; 
    public int kthSmallest(TreeNode root, int k) {
        getCount(root, 0, k);
        return ans;
    }

    private int getCount(TreeNode root, int lst, int k){ 
        if (root == null) return lst; 
        int left = getCount(root.left, lst, k);
        int self = left + 1;
        if (self == k) this.ans = root.val;
        int right = getCount(root.right, self, k);
        return right;
    }
}
