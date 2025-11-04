class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length ;
        int[] ans = new int[Math.max(0,n-k+1)] ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i = 0 ; i<k ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1) ;
        }
        ans[0] = xsum(map,x) ;
        for(int i = k ; i<nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1) ;
            map.put(nums[i-k],map.get(nums[i-k])-1) ;
            if(map.get(nums[i-k])==0){
                map.remove(nums[i-k]) ;
            }
            ans[i-k+1] = xsum(map,x) ;
        }
        return ans ;
    }
    public int xsum(Map<Integer,Integer> map, int x){
        List<int[]> ll = new ArrayList<>() ;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            ll.add(new int[]{e.getKey(), e.getValue()}) ;
        }
        ll.sort((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0];
        });
        int sum = 0 ;
        for(int i = 0 ; i<Math.min(x,ll.size()) ; i++){
            sum+=ll.get(i)[0]*ll.get(i)[1] ;
        }
        return sum ;
    }
}