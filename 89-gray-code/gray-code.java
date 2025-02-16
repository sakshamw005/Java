class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>() ;
        ans.add(0) ;
        for(int i = 1 ; i<=n ; i++){
            List<Integer> r = new ArrayList<>(ans) ;
            Collections.reverse(r);
            int temp = (int)Math.pow(2,i-1) ;
            for(int x : r){
                ans.add(x+temp) ;
            }
        }
        return ans ;
    }
}