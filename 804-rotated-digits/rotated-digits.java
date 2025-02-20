class Solution {
    public int rotatedDigits(int n) {
        int ans = 0 ;
        for(int i = 0 ; i<=n ; i++){    
            if(count(i)>0)ans++ ;
        }
        return ans ;
    }
    public static int count(int n){
        int count = 0 ;
        while(n>0){
            int r = n%10 ;
            if (r == 3 || r == 4 || r == 7) return 0;
            if (r == 2 || r == 5 || r == 6 || r == 9) count++;
            n/=10 ;
        }
        return count ;
    }
}