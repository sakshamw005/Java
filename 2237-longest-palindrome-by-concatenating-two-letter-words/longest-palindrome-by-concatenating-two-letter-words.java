class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> m = new HashMap<>() ;
        for(int i = 0 ; i<words.length ; i++){
            m.put(words[i],m.getOrDefault(words[i],0)+1) ;
        }
        int ans = 0 ;
        boolean used = false ;
        for(String x : m.keySet()){
            int v = m.get(x) ;
            String n = new StringBuilder(x).reverse().toString() ;
            if(x.equals(n)){
                ans = ans + (v/2)*4 ;
                if(v % 2 == 1 && !used){
                    ans += 2;
                    used = true;
                }
            }
            else if(m.containsKey(n)){
                int val = Math.min(m.get(x),m.get(n)) ;
                ans+=val*4 ;
                m.put(x,m.get(x)-val) ;
                m.put(n,m.get(n)-val) ;
            }
        }
        return ans;
    }
}