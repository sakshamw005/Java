class Solution {
    public boolean reorderedPowerOf2(int n) {
        Map<Character,Integer> m = new HashMap<>() ;
        String a = Integer.toString(n) ;
        for(int i = 0 ; i<a.length() ; i++){
            m.put(a.charAt(i),m.getOrDefault(a.charAt(i),0)+1) ;
        }
        for(int i = 0 ; i<=30 ; i++){
            int pow = (int)Math.pow(2,i) ;
            String temp = Integer.toString(pow) ;
            Map<Character,Integer> map = new HashMap<>() ;
            for(int j = 0 ; j<temp.length() ;j++){
                map.put(temp.charAt(j),map.getOrDefault(temp.charAt(j),0)+1) ;
            }
            if(map.equals(m)){
                return true ;
            }
        }
        return false ;
    }
}