class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>() ;
        print(s,ans,0,0,"") ;
        return ans ;
    }
    public void print(String s ,List<String> ans , int si , int count , String var){
        if(count==4 && si==s.length()){
            ans.add(var.substring(0,var.length()-1)) ;
            return ;
        }
        if (count >= 4 || si >= s.length()) return;

        for(int i = 1 ; i<=3 ; i++){
            if (si + i > s.length()) break;
            String curr = s.substring(si,si+i) ;
            if((curr.startsWith("0") && curr.length() > 1 ) || Integer.parseInt(curr)>255)continue ;
            print(s,ans,si+i,count+1,var+curr+".") ;
        }
    }
}