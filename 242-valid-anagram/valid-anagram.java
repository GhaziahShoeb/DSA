class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;

        }   
        int[] freq = new int[26];

        for(int i = 0 ; i< str1.length(); i++){
            freq[Character.toUpperCase(str1.charAt(i)) - 'A' ]++; // Increment frequency for each character in str1
        }
        for(int i = 0 ; i < str2.length(); i++){
            freq[Character.toUpperCase(str2.charAt(i)) - 'A' ]--; // Decrement frequency for each character in str2

        }   
        for(int i = 0 ; i< 26; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;  
    }
}