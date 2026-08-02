class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];

        for(int i = 0; i< s.length();i++){
            freq[Character.toUpperCase(s.charAt(i)) - 'A']++;
            
            
        }
        for(int j = 0 ; j<t.length();j++){
            freq[Character.toUpperCase(t.charAt(j))-'A']--;
        }
        for(int i= 0; i<26;i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
}