class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<int[]> l = new ArrayList<>() ;
        for(int i = 0 ; i<values.length ; i++){
            l.add(new int[]{values[i],labels[i]}) ;
        }

        l.sort((a,b)-> Integer.compare(b[0],a[0])) ;

        Map<Integer,Integer> m = new HashMap<>() ;
        int picked = 0 , ans = 0 ;
        for(int[] i : l){
            int lab = i[1] ;
            int val = i[0] ;

            if(picked==numWanted){
                break ;
            }
            
            int labcount = m.getOrDefault(lab,0) ;
            if(labcount<useLimit){
                ans+=val ;
                m.put(lab,labcount+1);
                picked++ ;
            }
        }
        return ans ;
    }
}