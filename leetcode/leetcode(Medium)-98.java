 
class Solution {
    public boolean isValidBST(TreeNode root) {
        int[] temp = new int[2];
        return isValidBST(root, temp);
    }

    private boolean isValidBST(TreeNode root, int[] maxmin){ 
        if (root.left == null && root.right == null) { 
            maxmin[0] = root.val;
            maxmin[1] = root.val;
            return true;
        }
        int[] maxminLeft = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] maxminRight = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        if (root.left != null) if(!isValidBST(root.left, maxminLeft) || root.val <= maxminLeft[0]) return false;
        if (root.right != null) if(!isValidBST(root.right, maxminRight) || root.val >= maxminRight[1]) return false;

        maxmin[0] = Math.max(maxminRight[0], root.val);
        maxmin[1] = Math.min(root.val, maxminLeft[1]);
        return true;
    }
}
