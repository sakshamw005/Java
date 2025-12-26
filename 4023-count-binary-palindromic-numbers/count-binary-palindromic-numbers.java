class Solution {
    public int countBinaryPalindromes(long n) {
        if(n==0)return 1 ;
        if(n==1)return 2 ;
        int len = Long.toBinaryString(n).length() ;
        int ans = 0 ;
        for(int i = 1 ; i<len ; i++){
            if (i == 1) {
                ans += 2;
            }
            else{
                ans += (int) Math.pow(2, ((i + 1) / 2 - 1));
            }
        }
        int hlen = (len + 1) / 2;
        String half = Long.toBinaryString(n).substring(0, hlen) ;

        long first = Long.parseLong(half, 2);
        long base = (long) Math.pow(2, hlen - 1);

        ans += (int) (first - base);

        String shalf = new StringBuilder(half.substring(0, len / 2)).reverse().toString();
        String full = half + shalf ;
        if(Long.parseLong(full, 2)<=n)ans+=1 ;
        return ans ;
    }
}