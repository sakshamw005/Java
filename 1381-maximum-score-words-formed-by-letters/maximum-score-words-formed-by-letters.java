class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26] ;
        for(char x : letters)freq[x-'a']++ ;
        return solve(freq,letters,words,score,0) ;
    }
    public int solve(int[] freq, char[] l, String[] w, int[] s, int i){
        if(i>=w.length)return 0 ;
        int ntak = solve(freq,l,w,s,i+1) ;
        int[] used = new int[26] ;
        boolean psbl = true ;
        int res = 0 ;
        for(char x : w[i].toCharArray()){
            int idx = x - 'a' ;
            used[idx]++ ;
            if(used[idx] > freq[idx]){
                psbl = false ;
            }
            res += s[idx] ;
        }
        int take = 0 ;
        if(psbl){
            for(int j = 0 ; j<26 ; j++){
                freq[j] -= used[j] ;
            }
            take = res + solve(freq,l,w,s,i+1) ;
            for(int j = 0 ; j<26 ; j++){
                freq[j] += used[j] ;
            }
        }
        return Math.max(take,ntak) ;
    }
}