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
    Map<Integer,TreeNode> map = new HashMap<>() ;
    Set<Integer> set = new HashSet<>() ;
    public TreeNode canMerge(List<TreeNode> trees) {
        for(TreeNode t : trees){
            map.put(t.val,t) ;
            if(t.left!=null)set.add(t.left.val) ;
            if(t.right!=null)set.add(t.right.val) ;
        }
        //unique root
        TreeNode temp = null ;
        for(TreeNode i : trees){
            if(!set.contains(i.val)){
                temp = i ;
                break ;
            }
        }
        if(temp==null)return temp ;
        map.remove(temp.val) ;
        if(!make(temp,Integer.MIN_VALUE,Integer.MAX_VALUE))return null ;
        if(!map.isEmpty())return null ;
        return temp ;
    }
    public boolean make(TreeNode temp,int left , int right){
        if(temp==null)return true ;
        if(temp.val<=left || temp.val>=right)return false ;
        if(temp.left!=null && map.containsKey(temp.left.val)){
            temp.left = map.remove(temp.left.val) ;
        }
        if(temp.right!=null && map.containsKey(temp.right.val)){
            temp.right = map.remove(temp.right.val) ;
        }
        return make(temp.left,left,temp.val) && make(temp.right,temp.val,right) ;
    }
}