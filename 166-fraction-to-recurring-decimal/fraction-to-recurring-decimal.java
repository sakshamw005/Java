class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0" ;
        }
        StringBuilder ans = new StringBuilder() ;
        if((numerator<0)^(denominator<0)){
            ans.append("-") ;
        }

        long n = Math.abs((long)numerator) ;
        long d = Math.abs((long)denominator) ;

        ans.append(n/d) ;
        long rem = n%d ;
        if(rem==0){
            return ans.toString() ;
        }
        else{
            ans.append(".") ;
        }
        Map<Long,Integer> map = new HashMap<>() ;
        while(rem!=0){
            if(map.containsKey(rem)){
                int pos = map.get(rem) ;
                ans.insert(pos,'(') ;
                ans.append(')') ;
                break ;
            }
            map.put(rem,ans.length()) ;
            rem*=10 ;
            ans.append(rem/d) ;
            rem = rem%d ;
        }
        return ans.toString() ;
    }
}