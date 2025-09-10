class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer>[] arr = new HashSet[languages.length];
        for(int i=0;i<languages.length;i++){
            arr[i] = new HashSet<>();
            for(int x : languages[i]) arr[i].add(x);
        }
        List<int[]> bad = new ArrayList<>();
        for(int[] i : friendships){
            int c1 = i[0]-1 , c2 = i[1]-1 ;
            boolean x = false ;
            for(int l : arr[c1]){
                if(arr[c2].contains(l)){
                    x = true ;
                    break ;
                }
            }
            if(!x) bad.add(i) ;
        }
        if(bad.isEmpty()) return 0 ;
        Set<Integer> fin = new HashSet<>() ;
        for(int[] f : bad){
            fin.add(f[0]-1) ;
            fin.add(f[1]-1) ;
        }
        int ans = Integer.MAX_VALUE ;
        for(int i=1;i<=n;i++){
            int c = 0 ;
            for(int l : fin){
                if(!arr[l].contains(i)) c++ ;
            }
            ans = Math.min(ans,c) ;
        }
        return ans ;
    }
}