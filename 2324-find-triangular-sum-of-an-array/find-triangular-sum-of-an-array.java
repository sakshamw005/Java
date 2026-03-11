class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int n : nums) temp.add(n);
        //System.out.println(temp.size()+"-->"+temp) ;
        while(temp.size()>1){
            List<Integer> arr = new ArrayList<>() ;
            for(int i = 0 ; i<temp.size()-1 ; i++){
                arr.add((temp.get(i)+temp.get(i+1))%10) ;
            }
            temp = arr ;
            //System.out.println(temp.size()+"-->"+temp) ;
        }
        return temp.get(0) ;
    }
}