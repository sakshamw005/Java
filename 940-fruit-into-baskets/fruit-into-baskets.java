class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0 , r = 0 ,max = 0 ;
        Map<Integer,Integer> m = new HashMap<>() ;
        while(r!=fruits.length){
            m.put(fruits[r],m.getOrDefault(fruits[r],0)+1) ;
            while (m.size() > 2) {
                m.put(fruits[l], m.get(fruits[l]) - 1);
                if (m.get(fruits[l]) == 0) {
                    m.remove(fruits[l]);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max ;
    }
}