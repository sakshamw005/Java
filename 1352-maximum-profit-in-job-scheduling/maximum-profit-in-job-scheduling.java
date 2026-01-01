class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Pair[] arr = new Pair[startTime.length] ;
        for(int i = 0 ; i<startTime.length ; i++){
            arr[i] = new Pair(startTime[i],endTime[i],profit[i]) ; 
        }
        // for(Pair i : arr){
        //     System.out.println(i.st+" "+i.et+" "+i.pr) ;
        // }
        Arrays.sort(arr,(a,b)->a.et-b.et) ;
        int[] prv = new int[arr.length] ;
        prv[0] = arr[0].pr ;
        for(int i = 1 ; i<arr.length ; i++){
            int take = arr[i].pr , j = bs(arr,i) ;
            if(j!=-1)take+=prv[j] ;
            prv[i] = Math.max(prv[i-1],take) ;
        }
        return prv[prv.length-1] ;
    }
    public int bs(Pair[] arr , int i){
        int l = 0 , r = i-1 , ans = -1 ;
        while(l<=r){
            int mid = (l+r)/2 ;
            if(arr[mid].et<=arr[i].st){
                l = mid+1 ;
                ans = mid ;
            }
            else{
                r = mid - 1 ;
            }
        }
        return ans ;
    }
}
class Pair{
    int st ;
    int et ;
    int pr ;
    Pair(int st ,int et ,int pr ){
        this.st = st ;
        this.et = et ;
        this.pr = pr ;
    }
}