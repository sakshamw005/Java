class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length] ;
        for(int i = 0 ; i<nums.length ; i++){
            str[i] = Integer.toString(nums[i]) ;
        }
        int n = nums.length ;
        for(int i = 0 ; i<n-1 ; i++){
            for(int j = 0 ; j<n-i-1 ; j++){
               if((str[j] + str[j + 1]).compareTo(str[j + 1] + str[j]) < 0){
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
               }
            }
        }
        String ans = "" ;
        for(String x : str){
            ans+=x ;
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans ;
    }
}