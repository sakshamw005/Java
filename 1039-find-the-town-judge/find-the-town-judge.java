class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] out = new int[n+1] ;
        int[] in = new int[n+1] ;
        for(int[] i : trust){
            out[i[0]]++ ;
            in[i[1]]++ ;
        }
        for(int i = 1 ; i<out.length ; i++){
            if(out[i]==0 && in[i]==n-1)return i ;
        }
        return -1 ;
    }
}