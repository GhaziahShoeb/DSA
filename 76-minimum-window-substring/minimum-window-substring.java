class Solution {
    public String minWindow(String s, String t) {
        // Edge case: if s is shorter than t, no valid window possible
        if (s.length() < t.length()) return "";

        // Step 1: count how many of each character we NEED (from t)
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Step 2: tracks counts of characters currently in our window
        HashMap<Character, Integer> window = new HashMap<>();

        int required = need.size();   // unique chars we need to fully match
        int formed = 0;               // unique chars currently fully matched

        int left = 0;
        int minLen = Integer.MAX_VALUE;  // smallest valid window length found
        int minStart = 0;                // starting index of smallest window

        // Step 3: expand window using 'right'
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // if this character's count now matches what's needed, one more requirement satisfied
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Step 4: window is valid (contains all of t) -> try shrinking from left
            while (formed == required) {
                // update answer if current window is smaller than best found so far
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // remove leftmost character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // if removing it breaks a requirement, window becomes invalid
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;  // shrink window
            }
        }

        // Step 5: return smallest valid window found, or "" if none
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}