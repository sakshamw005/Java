class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder() ;
        List<Integer> ll = new ArrayList<>() ;
        for(int i = 1 ; i<=n ; i++)ll.add(i) ;
        k-- ; 
        // [1 2 3]
        for(int i = 1 ; i<=n ; i++){
            int fact = fact(ll.size()-1) ;
            int idx = k / fact ;
            sb.append(ll.get(idx)) ;
            ll.remove(idx) ;
            k = k % fact ;
        }  
        return sb.toString() ;
    }
    public int fact(int n){
        if(n<=1)return 1 ;
        return n*fact(n-1) ;
    }
}