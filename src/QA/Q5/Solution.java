package QA.Q5;

public class Solution {

    public static void main(String[] args){
        System.out.println(longestPalindrome("edabagh"));
    }

    public static String longestPalindrome(String s){
        if("".equalsIgnoreCase(s)){
            return "";
        }
        int len = 0, start = 0, end = 0;
        for(int i = 0; i < s.length(); i ++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            if (len1 <= len2)
                len1 = len2;
            if (len1 >= len){
                len = len1;
                start = i - (len - 1 ) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        int len = s.length();
        while(left >= 0 && right < len && (s.charAt(left) == s.charAt(right))){
            left --;
            right ++;
        }
        return right - left - 1;
    }



}
