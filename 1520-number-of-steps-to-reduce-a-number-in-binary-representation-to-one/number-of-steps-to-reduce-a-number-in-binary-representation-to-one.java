class Solution {
    public int numSteps(String s) {
        int ans = 0 , c = 0 ;
        for(int i = s.length()-1 ; i>0 ; i--){
            int cnt = (s.charAt(i)-'0') + c ;
            if(cnt==1){
                ans+=2 ;
                c = 1 ;
            }
            else {
                ans++ ;
            }
        }
        return ans+c ;
    }
}
//         int num = 0 ;
//         for(int i = 0 ; i<s.length() ; i++){
//             num = num*2 + (s.charAt(i)-'0') ;
//         }
//         System.out.println(num) ;
//         int ans = 0 ;
//         while(num>1){
//             if(num%2==0){
//                 num/=2 ;
//             }
//             else{
//                 num++ ;
//             }
//             ans++ ;
//         }
//         return ans ;
//     }
// }