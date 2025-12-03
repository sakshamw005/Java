class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if(n<0)return 1.0/find(x,-exp) ;
        return find(x,exp) ;
    }
    public double find(double x , long n){
        if(n==0)return 1.0 ;
        if(x==1.0)return x ;
        if(n%2==0)return find(x*x,n/2) ;
        return x*find(x,n-1) ;
    }
}