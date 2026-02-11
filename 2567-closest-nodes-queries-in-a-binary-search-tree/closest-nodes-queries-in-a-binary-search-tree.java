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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> l = new ArrayList<>() ;
        make(l,root) ;
        //for(int i : l)System.out.print(i+" ") ;
        for(int i : queries){
            int a = bs(i,-1,l) , b = bs(i,1,l) ;
            ans.add(Arrays.asList(a,b)) ;
        }
        return ans ;
    }
    public int bs(int element , int dir , List<Integer> l){
        int ans = -1 , i = 0 , j = l.size()-1 ;
        boolean what = dir<0 ? false : true ; 
        while(i<=j){
            int mid = i+(j-i)/2 ;
            if(l.get(mid)==element){
                return element ;
            } 
            else if(dir<0){
                if(l.get(mid)<element){
                    ans = l.get(mid) ;
                    i = mid + 1 ;
                }
                else{
                    j = mid - 1 ;
                }
            }
            else{
                if(l.get(mid)>element){
                    ans = l.get(mid) ;
                    j = mid - 1 ;
                }
                else{
                    i = mid + 1 ;
                }
            }
        }
        return ans ;
    }
    public void make(List<Integer> l, TreeNode root){
        if(root==null)return ;
        make(l,root.left) ;
        l.add(root.val) ;
        make(l,root.right) ;
    }
}