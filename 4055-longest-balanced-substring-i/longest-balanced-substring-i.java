class Solution {
    public int longestBalanced(String s) {
        int ans = 0 ;
        for(int i = 0 ;i<s.length() ;i++){
            int freq[] = new int[26] ;
            for(int j = i ; j<s.length() ; j++){
                freq[s.charAt(j) - 'a']++ ;
                if(check(freq)){
                    ans = Math.max(ans,j-i+1) ;
                }
            }
        }
        return ans ;
    }
    public boolean check(int freq[]){
        int last = 0;
        for(int i : freq){
            if(i!=0){
                if(last==0){
                    last = i ;
                }
                else if(i!=last){
                    return false ;
                }
            }
        }
        return true ;
    }
}