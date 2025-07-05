class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i : arr){
            m.put(i,m.getOrDefault(i,0)+1) ;
        }
        int max = -1 ;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key==value){
                max = Math.max(max,key) ;
            }
        }
        return max ;
    }
}