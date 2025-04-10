class Solution{
    public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> l = new ArrayList<>() ;
            boolean[] used = new boolean[nums.length] ;
            permu(nums,l,new ArrayList<>() , used) ;
            return l ;
        }
    public static void permu(int[] nums , List<List<Integer>> l, List<Integer> temp , boolean[] used){
            if(temp.size()==nums.length){
                l.add(new ArrayList<>(temp)) ;
                return ;
            }
            for(int i = 0 ; i<nums.length ; i++){
                if (!used[i]) {
                    used[i] = true;
                    temp.add(nums[i]);
                    permu(nums,l,temp,used);
                    temp.remove(temp.size() - 1);
                    used[i] = false;
                }
            }
        }
}