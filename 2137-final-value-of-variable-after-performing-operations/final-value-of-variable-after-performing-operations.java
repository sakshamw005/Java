class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0 ;
        for(String i : operations){
            if(i.charAt(0)=='-' || i.charAt(2)=='-'){
                ans-- ;
            }
            else{
                ans++ ;
            }
        }
        return ans ;
    }
}