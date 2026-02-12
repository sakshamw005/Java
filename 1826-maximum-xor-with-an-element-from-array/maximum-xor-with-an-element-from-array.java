class Solution {
    public int[] maximizeXor(int[] arr, int[][] queries) {
        int[][] q = new int[queries.length][3] ;
        for(int i = 0 ; i < q.length ; i++){
            q[i][0] = queries[i][0] ; //xi 
            q[i][1] = queries[i][1] ; //mi
            q[i][2] = i ;//i
        }
        Arrays.sort(q,(a,b)->(a[1]-b[1])) ;
        Arrays.sort(arr) ;
        int[] ans = new int[q.length] ;
        Trie t = new Trie() ;
        int j = 0 ; // index
        for(int[] a : q){
            while(j<arr.length && arr[j]<=a[1]){
                t.add(arr[j]) ;
                j++ ;
            }
            if(j==0){
                ans[a[2]] = -1 ;
            }
            else {
                ans[a[2]] =t.getMaxXor(a[0]) ;
            }
        } 
        return ans ;
    }
    static class Trie {
        static class Node {
            Node zero;
            Node one;
        }
        Node root = new Node();
        public void add(int val) {
            Node curr = root;

            for(int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;

                if(bit == 0) {
                    if(curr.zero == null)
                        curr.zero = new Node();
                    curr = curr.zero;
                } else {
                    if(curr.one == null)
                        curr.one = new Node();
                    curr = curr.one;
                }
            }
        }
        public int getMaxXor(int x){
            Node curr = root;
            int ans = 0;

            for(int i = 31; i >= 0; i--){
                int bit = (x >> i) & 1;
                if(bit == 0){
                    if(curr.one != null){
                        ans |= (1 << i);
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if(curr.zero != null){
                        ans |= (1 << i);
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }
            return ans;
        }
    }
}