class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int start[] = new int[flowers.length] ;
        int end[] = new int[flowers.length] ;
        int ans[] = new int[people.length] ;
        for(int i = 0 ; i<flowers.length ; i++){
            start[i] = flowers[i][0] ;
            end[i] = flowers[i][1] ;
        }
        Arrays.sort(start) ;
        Arrays.sort(end) ;

        for(int i = 0  ; i<people.length ; i++){
            int num = people[i] ;
            int si = ub(num,start) ;
            int ei = lb(num,end) ;
            ans[i] = si-ei ;
        }
        return ans ;
    }
    public int ub(int i , int[] arr){
        int l = 0 , r = arr.length ;
        while(l<r){
            int mid = l + (r-l)/2 ;
            if(arr[mid]<=i){
                l = mid + 1 ;
            }
            else{
                r = mid ;
            }
        }
        return l ;
    }
    public int lb(int i , int[] arr){
        int l = 0 , r = arr.length ;
        while(l<r){
            int mid = l + (r-l)/2 ;
            if(arr[mid]<i){
                l = mid + 1 ;
            }
            else{
                r = mid ;
            }
        }
        return l ;
    }
}