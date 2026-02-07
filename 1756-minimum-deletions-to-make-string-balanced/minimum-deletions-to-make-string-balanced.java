class Solution {
    public int minimumDeletions(String s) {
        int n = s.length() ;
        if(n==1)return 0 ;
        char[] arr = s.toCharArray() ;
        int[] b = make(arr) ; //b's before i
        int[] a = good(arr) ; //a's after i
        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i<arr.length ; i++){
            ans = Math.min(ans,(a[i]+b[i])) ;
        }
        return ans ;
    }
    public int[] make(char[] s){
        int[] ans = new int[s.length] ;
        ans[0] = 0 ;
        int b = s[0]=='b' ? 1 : 0 ;
        for(int i = 1 ; i<s.length ; i++){
            ans[i] = b ;
            if(s[i]=='b')b++ ;
        }
        return ans ;
    }
     public int[] good(char[] s){
        int[] ans = new int[s.length] ;
        ans[s.length-1] = 0 ;
        int a = s[s.length-1]=='a' ? 1 : 0 ;
        for(int i = s.length-2 ; i>=0 ; i--){
            ans[i] = a ;
            if(s[i]=='a')a++ ;
        }
        return ans ;
    }
}