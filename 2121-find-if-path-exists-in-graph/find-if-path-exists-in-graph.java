class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i<n ; i++) map.put(i,new ArrayList<>()) ;
        for(int[] i : edges){
            int src = i[0] , des = i[1] ;
            map.get(src).add(des) ;
            map.get(des).add(src) ;
        }
        Set<Integer> set = new HashSet<>() ;
        return dfs(source,destination,map,set) ;
    }
    public boolean dfs(int source, int destination, Map<Integer,List<Integer>> map,Set<Integer> set){
        if(source==destination){
            return true ;
        }
        set.add(source) ;
        for(int i : map.getOrDefault(source,new ArrayList<>())){
            if(!set.contains(i)){
                if(dfs(i,destination,map,set)){
                    return true ;
                }
            }
        }
        return false ;
    }
}