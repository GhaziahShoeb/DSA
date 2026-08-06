class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLen = 0; // variable size
         
        for(int right = 0; right < n ; right ++){
            char c = s.charAt(right);

            while(window.contains(c)){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}