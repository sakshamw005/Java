class Solution {
    public String generateTag(String caption) {
        caption = caption.trim() ;
        StringBuilder ans = new StringBuilder() ;
        ans.append('#') ;
        boolean y = false ;
        for(int i = 0 ; i<caption.length() ; i++){
            if(ans.length()==100)break ;
            char x = caption.charAt(i) ;
            if(x==' '){
                y = true ;
            }
            else{
                if (ans.length() == 1) { 
                    ans.append(Character.toLowerCase(x));
                    y = false;
                } 
                else if(y){
                    ans.append(Character.toUpperCase(x)) ;
                    y = false ;
                }
                else{
                    ans.append(Character.toLowerCase(x)) ;
                }
            }

        } 
        return ans.toString() ;
    }
}