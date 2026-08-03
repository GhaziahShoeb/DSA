class Solution {
    public boolean isValid(String s) {
        int prevLength;
        do {
            prevLength = s.length();        // ❌ was == (comparison), should be = (assignment)
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        } while (s.length() != prevLength); // ❌ was prevLength() — it's a variable, not a function

        return s.isEmpty();                 // ❌ was s.isEmpty (missing parentheses)
    }                                        // ❌ closing brace was in wrong place (return was outside method)
}