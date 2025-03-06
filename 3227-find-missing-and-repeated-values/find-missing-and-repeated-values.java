class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length ;
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i = 1 ; i<=(int)Math.pow(n,2) ; i++){
            m.put(i,0) ;
        }
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                m.put(grid[i][j] , m.get(grid[i][j])+1) ;
            }
        }
        int[] ans = new int[2] ;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() > 1) {
                ans[0] = entry.getKey();
            }
            if (entry.getValue() == 0) {
                ans[1] = entry.getKey(); 
            }
        }
        return ans;
    }
}