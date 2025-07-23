class Solution {
    public int maximumGain(String s, int x, int y) {
        String target = "";
        int first = 0 , second = 0 ,ans = 0 ;
        if(x>y){
            target+="ab" ;
            first = x ;
            second = y ;
        }
        else{
            target+="ba" ;
            first = y ;
            second = x ;
        }
        StringBuilder sb = new StringBuilder() ;
        for(char m : s.toCharArray()){
            sb.append(m) ;
            int len = sb.length() ;

            if(len>=2 && sb.substring(len-2,len).equals(target)){
                sb.delete(len-2,len) ;
                ans+=first ;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        String target2 = target.equals("ab") ? "ba" : "ab";

        for(char m : sb.toString().toCharArray()){
            sb2.append(m) ;
            int len = sb2.length() ;

            if(len>=2 && sb2.substring(len-2,len).equals(target2)){
                sb2.delete(len-2,len) ;
                ans+=second ;
            }
        }
        return ans ;
    }
}