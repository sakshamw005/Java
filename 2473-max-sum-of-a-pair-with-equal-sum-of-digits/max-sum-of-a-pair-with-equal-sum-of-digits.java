class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1 ;
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i : nums){
            int sum = sumOD(i) ;
            if(!m.containsKey(sum)){
                m.put(sum,i) ;
            }
            else{
                ans = Math.max(ans,m.get(sum)+i) ;
                m.put(sum,Math.max(m.get(sum),i)) ;
            }
        }
        return ans ;
    }
    public int sumOD(int n){
        int sum = 0 ;
        while(n>0){
            sum+=n%10 ;
            n/=10 ;
        }
        return sum ;
    }
}