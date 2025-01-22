class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>() ;
        List<Integer> one = new ArrayList<>() ;
        List<Integer> two = new ArrayList<>() ;
        for(int i = 0 ; i<nums2.length ; i++){
            boolean a = false ;
            for(int j = 0 ; j<nums1.length ; j++){
                if(nums2[i]==nums1[j]){
                    a = true ;
                    break; 
                }
            }
            if (!a && !one.contains(nums2[i])) {
                one.add(nums2[i]);
            }
        }
        for(int i = 0 ; i<nums1.length ; i++){
            boolean a = false ;
            for(int j = 0 ; j<nums2.length ; j++){
                if(nums1[i]==nums2[j]){
                    a = true ;
                    break ;
                }
            }
            if(!a && !two.contains(nums1[i])){
                two.add(nums1[i]) ;
            }
        }
        answer.add(two) ;
        answer.add(one) ;
        return answer ;
    }
}