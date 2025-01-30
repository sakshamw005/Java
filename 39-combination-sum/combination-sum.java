class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l = new ArrayList<>() ;
        List<List<Integer>> ans = new ArrayList<>() ;
        Combination(candidates,target,l,0,ans);
        return ans ;
    }
    public static void Combination(int[] coins ,int amount, List<Integer> l,
                                   int idx ,List<List<Integer>> ans){
        if(amount==0){
            ans.add(new ArrayList<>(l));
            return ;
        }
        for (int i = idx; i < coins.length; i++) {
            if (amount >= coins[i]) {
                l.add(coins[i]) ;
                Combination(coins,amount-coins[i],l,i,ans);
                l.remove(l.size()-1) ;
            }
        }
                                   }
}