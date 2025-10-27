class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length ;
        int[] arr = new int[n] ;
        for(int i = 0 ; i<bank.length ; i++){
            String s = bank[i] ;
            arr[i] = s.length() - s.replace("1", "").length();
        }
        int ans = 0 , prev = 0 ;
        for(int i = 0 ; i<n ; i++){
            if(arr[i]>0){
                ans+=prev*arr[i];
                prev = arr[i] ;
            }
        }
        return ans ;
    }
}