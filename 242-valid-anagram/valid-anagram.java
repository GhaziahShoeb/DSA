class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        for(int i = 0 ; i< str1.length();i++){
            if(charArray1[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }
}