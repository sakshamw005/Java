class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> ll = new ArrayList<>() ;
        for(int i = 1 ; i<=n ; i++)ll.add(i) ;
        int curr = 0 ; 
        while(ll.size()>1){
            int remove = (curr+k-1)%ll.size() ;
            ll.remove(remove) ;
            curr = remove ;
        }
        return ll.get(0) ;
    }
}