class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ll = new ArrayList<>() ;
        for(int i = 1 ; i<=9 ; i++){
            int curr = i ;
            int next = i+1 ;
            while(curr<=high && next<=9 ){
                curr = curr*10 + next ;
                if(low<=curr && curr<=high){
                    ll.add(curr) ;
                }
                next++ ;
            }
        }
        Collections.sort(ll) ;
        return ll ;
    }
}