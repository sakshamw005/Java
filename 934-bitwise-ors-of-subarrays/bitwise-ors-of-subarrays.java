class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>() ;
        Set<Integer> temp = new HashSet<>() ;
        for(int i = 0 ; i<arr.length ; i++){
            Set<Integer> s = new HashSet<>() ;
            s.add(arr[i]) ;
            for(int x : temp){
                s.add(x|arr[i]) ;
            }
            ans.addAll(s) ;
            temp = s ;
        }
        return ans.size() ;
    }
}