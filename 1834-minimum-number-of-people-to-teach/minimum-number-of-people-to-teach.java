class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<int[]> bad = new ArrayList<>() ;
        for(int[] i : friendships){
            Map<Integer,Integer> map = new HashMap<>() ;
            int c1 = i[0] , c2 = i[1] ;
            for(int j = 0 ; j<languages[c1-1].length ; j++){
                map.put(languages[c1-1][j],map.getOrDefault(languages[c1-1][j],0)+1) ;
            }
            for(int j = 0 ; j<languages[c2-1].length ; j++){
                map.put(languages[c2-1][j],map.getOrDefault(languages[c2-1][j],0)+1) ;
            }
            boolean x = false ;
            for(int k : map.values()){
                if(k>1)x = true ;
            }
            if(!x){
                bad.add(i) ;
            }
        }
        if(bad.isEmpty())return 0 ;
        Set<Integer> fin = new HashSet<>() ;
        for(int[] f : bad){
            fin.add(f[0]) ;
            fin.add(f[1]) ;
        }
        int ans = Integer.MAX_VALUE ;
        for(int i = 1 ; i<=n ; i++){
            int c = 0 ;
            for(int l : fin){
                boolean check = false ;
                for(int k : languages[l-1]){
                    if(k==i){
                        check = true ;
                        break ;
                    }
                }
                if(!check){
                    c++ ;
                }
            }
            ans = Math.min(c,ans) ;
        }
        return ans ;
    }
}