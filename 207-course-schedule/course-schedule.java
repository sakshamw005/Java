class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for(int i = 0 ; i<n ; i++)map.put(i,new ArrayList<>()) ;
        for(int[] i : prerequisites){
            map.get(i[1]).add(i[0]);
        }
        Set<Integer> visiting = new HashSet<>() ;
        Set<Integer> visited = new HashSet<>() ;
        for(int i = 0 ; i<n ; i++){
            if(!visited.contains(i)){
                if(dfs(i,map,visiting,visited)){
                    return false ;
                }
            }
        }
        return true ;
    }
    public boolean dfs(int src,Map<Integer,List<Integer>> map,Set<Integer> visiting,Set<Integer> visited){
        if (visiting.contains(src)) return true;
        if (visited.contains(src)) return false;

        visiting.add(src);

        for (int nei : map.get(src)) {
            if (dfs(nei, map, visiting, visited)) return true;
        }

        visiting.remove(src);
        visited.add(src);
        return false;
    }
}