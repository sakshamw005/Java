class Solution {
    public boolean hasAllCodes(String s, int k) {
        int l = 0 , r = 0 ;
        Map<String,Integer> map = new HashMap<>() ;
        while(r<s.length()){
            if((r-l+1)==k){
                map.put(s.substring(l,r+1),map.getOrDefault(s.substring(l,r+1),0)+1) ;
                l++ ;
            }
            r++;
        }
        return map.size() == Math.pow(2,k); 
    }
}