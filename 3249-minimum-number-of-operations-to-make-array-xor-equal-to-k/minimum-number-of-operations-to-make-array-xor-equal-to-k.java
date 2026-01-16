class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0 ;
        for(int i : nums)xor^=i ;
        String x = Integer.toBinaryString(xor) , y = Integer.toBinaryString(k) ;
        int max = Math.max(x.length(),y.length()) ;
        x = String.format("%" + max + "s", x).replace(' ', '0');
        y = String.format("%" + max + "s", y).replace(' ', '0');
        int ans = 0;
        for(int i = 0 ; i<x.length() ; i++){
            if(x.charAt(i)!=y.charAt(i))ans++ ;
        }
        return ans ;
    }
}