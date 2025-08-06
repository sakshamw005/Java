class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> m = new HashMap<>() ;
        for(char x : s.toCharArray()){
            m.put(x,m.getOrDefault(x,0)+1) ;
        }
        int mx = 0 ;
        char ma = 'a' ;
        for(char x : m.keySet()){
            if(m.get(x)>mx){
                mx = m.get(x) ;
                ma = x ;
            }
        }
        if(mx>(s.length()+1)/2){
            return "" ;
        }
        char[] result = new char[s.length()] ;
        int idx = 0 ;
        while(mx-->0){
            result[idx] = ma ;
            idx+=2 ;
        }
        m.remove(ma) ;
        for(Map.Entry<Character,Integer> temp : m.entrySet()){
            char c = temp.getKey() ;
            int va = temp.getValue() ;
            while(va-->0){
                if(idx>=s.length()){
                    idx = 1 ;
                }
                result[idx] = c ;
                idx+=2 ;
            }
        }
        return new String(result) ;
    }
}