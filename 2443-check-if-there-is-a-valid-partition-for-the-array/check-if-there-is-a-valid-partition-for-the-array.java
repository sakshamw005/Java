class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length+1] ;
        dp[0] = true ;
        for(int i = 2 ; i<=nums.length ; i++){
            if(nums[i-1]==nums[i-2] && dp[i-2])dp[i] = true ; //two
            if(i>=3 && nums[i-1]==nums[i-2] && nums[i-2]==nums[i-3] && dp[i-3])dp[i] = true ;
            if(i>=3 && nums[i-1]-1==nums[i-2] && nums[i-2]-1==nums[i-3] && dp[i-3])dp[i] = true ;
        }
        return dp[dp.length-1];
    }
}
//         return check(nums,0) ;
//     }
//     public boolean check(int[] nums , int i){
//         if(!(one(nums,i) || two(nums,i) || three(nums,i))){
//             return false ;
//         }
//         if(i==nums.length)return true ;
//         return check(nums,i+1) ;
//     }
//     public boolean one(int[] arr , int k){
//         Map<Integer,Integer> map = new HashMap<>() ;
//         for(int i = k ; i<arr.length ; i++)map.put(arr[i],map.getOrDefault(arr[i],0)+1) ;
//         for(int i : map.values())if(i==2)return true ;
//         return false ;
//     }
//     public boolean two(int[] arr , int k){
//         Map<Integer,Integer> map = new HashMap<>() ;
//         for(int i = k ; i<arr.length ; i++)map.put(arr[i],map.getOrDefault(arr[i],0)+1) ;
//         for(int i : map.values())if(i==3)return true ;
//         return false ;
//     }
//     public boolean three(int[] arr , int k){
//         if(arr.length-k<3)return false ;
//         for(int i = k ; i<=arr.length-3 ; i++){
//             if((arr[i+1]==arr[i]+1) && (arr[i+2]==arr[i+1]+1)){
//                 return true ;
//             }
//         }
//         return false ;
//     }
// }