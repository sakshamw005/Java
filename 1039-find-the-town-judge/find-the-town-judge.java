class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1] ;
        int[] ou = new int[n+1] ;
        for(int[] i : trust){
            in[i[1]]++ ;
            ou[i[0]]++ ;
        }
        for(int i = 1 ; i<=n ; i++){
            if(in[i]==n-1 && ou[i]==0){
                return i ;
            }
        }
        return -1; 
    }
}