class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>() ;
        for(int i = 0 ; i<s.length() ; i+=k){
            int to = Math.min(i+k,s.length()) ;
            String part = s.substring(i,to) ;
            while(part.length()<k){
                part+=fill ;
            }
            ans.add(part) ;
        }
        return ans.toArray(new String[0]) ;
    }
}