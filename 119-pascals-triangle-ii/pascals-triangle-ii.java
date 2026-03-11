class Solution {
    public List<Integer> getRow(int ri) {
        int lvl = 1 ;
        List<Integer> l = new ArrayList<>() ;
        l.add(1) ;
        while(lvl<=ri){
            List<Integer> ans = new ArrayList<>() ;
            ans.add(1) ;
            for(int i = 1 ; i<lvl ; i++){
                ans.add((l.get(i-1)+l.get(i))) ;
            }
            ans.add(1) ;
            l = ans ;
            lvl++ ;
        } 
        return l ;
    }
}