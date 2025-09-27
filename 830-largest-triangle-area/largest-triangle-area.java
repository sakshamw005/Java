class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0 ;
        for(int i = 0 ;  i<points.length-2 ; i++){
            for(int j = i+1 ; j<points.length-1 ; j++){
                for(int k = j+1 ; k<points.length ; k++){
                    if(check(points[i],points[j],points[k])){
                        ans = Math.max(ans,calculate(points[i],points[j],points[k])) ;
                    }
                }
            }
        }
        return ans ;
    }
    public boolean check(int[] one , int[] two , int[] three){
        int x1 = one[0] , x2 = one[1] ;
        int y1 = two[0] , y2 = two[1] ;
        int x3 = three[0] , y3 = three[1] ;
        return Math.abs((y2-y1)*(x3-x1) - (x2-x1)*(y3-y1)) !=0 ;
    }
    public double calculate(int[] a , int[] b , int[] c){
        return 0.5 * Math.abs( //shoelace formula
            a[0] * (b[1] - c[1]) +
            b[0] * (c[1] - a[1]) +
            c[0] * (a[1] - b[1])
        );
    }
}