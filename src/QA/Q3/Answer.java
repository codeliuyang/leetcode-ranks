package QA.Q3;

import org.junit.Test;

/**
 * 3.无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Answer {

    @Test
    public void tst(){
        System.out.println(lengthOfLongestSubstring_Method1("bwf"));
    }

    // too long time to cost ...
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 616 ms
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗 :
     * 359.3 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     */
    public int lengthOfLongestSubstring_Method1(String s) {
        int result = 1;
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int maxlength = 1;
        String allStr = "";
        for(int i = 0; i < length; i++){
            String temp = s.charAt(i) + "";
            if(!allStr.contains(temp)){
                allStr += temp;
            }
        }
        System.out.println(allStr);
        maxlength = allStr.length();
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < i + maxlength; j++){
                int start = i, end = j;
                if(j >= length){
                    break;
                }
                String temp = s.charAt(start) + "";
                int offset = 0;
                while(start < end && (start+offset < length - 1)){
                    offset ++;
                    String next = s.charAt(start + offset) + "";
                    if(temp.contains(next)){
                        i = start + offset - 1;
                        break;
                    } else {
                        temp += next;
                        result = (temp.length() >= result) ? temp.length() : result;
                        if(result == maxlength){
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

}
