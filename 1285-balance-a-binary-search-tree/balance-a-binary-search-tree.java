/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(isBalanced(root))return root; 
        List<Integer> l = new ArrayList<>();
        inorder(root,l) ;
        // System.out.println(l) ;
        return construct(l,0,l.size()-1) ;
    }
    public TreeNode construct(List<Integer> l , int i , int j){
        if(i>j)return null ;
        int mid = i + (j-i)/2 ;
        TreeNode lst = construct(l,i,mid-1) ;
        TreeNode rst = construct(l,mid+1,j) ;
        return new TreeNode(l.get(mid),lst,rst) ;
    }
    public void inorder(TreeNode root , List<Integer> l){
        if(root==null)return ;
        inorder(root.left,l) ;
        l.add(root.val) ;
        inorder(root.right,l) ;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true ;
        return dfsheight(root) != -1 ;
    }
    public int dfsheight(TreeNode root){
        if(root==null)return 0 ;
        int left = dfsheight(root.left) ;
        if(left==-1)return -1 ;

        int right = dfsheight(root.right) ;
        if(right==-1)return -1 ;

        if(Math.abs(right-left)>1)return -1 ;

        return 1 + Math.max(right,left) ;
    }
}