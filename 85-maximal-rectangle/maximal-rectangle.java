class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0 ;
        int[] arr = new int[matrix[0].length] ;
        for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]=='0'){
                    arr[j] = 0 ;
                }
                else{
                    arr[j]++ ;
                }
            }
            ans = Math.max(ans,Largest_Histogram(arr)) ;
        }
        return ans ;
    }
    public static int Largest_Histogram(int[] arr){
        Stack<Integer> st = new Stack<>() ;
        int ans = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int h = arr[st.pop()] ;
                int r = i ;
                if(st.isEmpty()){
                    ans = Math.max(h*r , ans) ;
                }
                else{
                    int l = st.peek() ;
                    int area = h * (r-l-1) ;
                    ans = Math.max(area,ans) ;
                }
            }
            st.push(i) ;
        }
        int r = arr.length ;
        while(!st.isEmpty()){
            int h = arr[st.pop()] ;
            if(st.isEmpty()){
                ans = Math.max(h*r,ans) ;
            }
            else{
                int l = st.peek() ;
                int area = h * (r-l-1) ;
                ans = Math.max(area,ans) ;
            }
        }
        return ans ;
    }
}