class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>() ;
        boolean[] set = new boolean[friends.length] ;
        q.add(id) ;
        set[id] = true ;
        while(level!=0){
            int size = q.size() ;
            for(int i = 0 ; i<size ; i++){
                int nd = q.poll() ;
                for(int m : friends[nd]){
                    if(!set[m]){
                        q.add(m) ;
                        set[m] = true ;
                    }
                }
            }
            level-- ;
        }
        Map<String,Integer> map = new HashMap<>() ;
        for(int m : q){
            for(String d : watchedVideos.get(m)){
                map.put(d,map.getOrDefault(d,0)+1) ;
            }
        }
        List<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, (a, b) -> {
            if (!map.get(a).equals(map.get(b)))
                return map.get(a) - map.get(b);
            return a.compareTo(b);
        });
        return ans ;
    }
}