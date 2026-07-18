class Solution {
    public boolean isPalindrome(int n) {
        int revNum = 0;
        int dup = n;
        while(n>0){
            int ld = n% 10;
            revNum = revNum * 10 + ld;
            n = n/10;
        }return  dup == revNum;
    }

}