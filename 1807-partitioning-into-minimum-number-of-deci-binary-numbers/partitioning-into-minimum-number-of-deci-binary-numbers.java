class Solution {
    public int minPartitions(String n) {
        int ans = 0 ;
        for(char x : n.toCharArray()){
            ans = Math.max(ans,x-'0') ;
        }
        return ans ;
    }
}