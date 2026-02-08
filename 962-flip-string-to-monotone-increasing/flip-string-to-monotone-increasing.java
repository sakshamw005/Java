class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length() ;
        int[] a = new int[n] ; //0s after i
        int[] b = new int[n] ; //1s before i
        a[n-1] = 0 ;
        int c = s.charAt(n-1) == '0' ? 1 : 0 ;
        for(int i = n-2 ; i>=0 ; i--){
            a[i] = c ;
            if(s.charAt(i)=='0')c++ ;
        }
        b[0] = 0 ;
        c = s.charAt(0) == '1' ? 1 : 0 ;
        for(int i = 1 ; i<n ; i++){
            b[i] = c; 
            if(s.charAt(i)=='1')c++ ;
        }
        // System.out.println("A") ;
        // for(int i : a)System.out.print(i+" ") ;
        // System.out.println() ;
        // System.out.println("B") ;
        // for(int i : b)System.out.print(i+" ") ;
        int ans = Integer.MAX_VALUE ;
        for(int i = 0 ; i<n ; i++){
            ans = Math.min(ans,(a[i]+b[i])) ;
        }
        return ans ;
    }
}