class Solution {
    public boolean doesValidArrayExist(int[] arr) {
        int xor = 0 ;
        for(int v : arr){
            xor^=v ;
        }
        return xor==0 ;
    }
}