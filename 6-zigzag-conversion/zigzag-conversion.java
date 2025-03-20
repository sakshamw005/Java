class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; 
        }
        HashMap<Integer,String> m = new HashMap<>() ;
        int row = 1 ;
        boolean inc = true ;
        int index = 0 ;
        while(index < s.length()){
            String temp = m.getOrDefault(row,"") ;
            m.put(row,temp+s.charAt(index)) ;
            index++ ;
            if(inc){
                row++ ;
                if(row==numRows){
                    inc = false ;
                }
            }
            else{
                row-- ;
                if(row==1){
                    inc = true ;
                }
            }
        }
        String ans = "" ;
        for(String x : m.values()){
            ans+=x ;
        }
        return ans ;
    }
}