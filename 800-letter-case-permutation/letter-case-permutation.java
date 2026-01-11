class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] arr = s.toCharArray() ;
        List<String> ans = new ArrayList<>() ;
        bt(arr,ans,0) ;
        return ans;
    }
    public void bt(char[] arr , List<String> ans , int i){
        if(i==arr.length){
            ans.add(new String(arr)) ;
            return ;
        }
        if(Character.isLetter(arr[i])){
            if(Character.isUpperCase(arr[i])){
                arr[i] = Character.toLowerCase(arr[i]) ;
                bt(arr,ans,i+1) ;
                arr[i] = Character.toUpperCase(arr[i]) ;
            }
            else{
                arr[i] = Character.toUpperCase(arr[i]) ;
                bt(arr,ans,i+1) ;
                arr[i] = Character.toLowerCase(arr[i]) ;
            }
        }
        bt(arr,ans,i+1) ;
    }
}