package QA.q6;

public class Solution {

    public static void main(String[] args){
        System.out.println(convertZ("AB", 1));
    }

    public static String convertZ(String s, int numRows) {
        int len = s.length();
        if(len <= numRows || numRows == 1){
            return s;
        }
        int[] rowNums = new int[len];
        int index = 0;
        boolean asc = true;
        for(int i = 0; i < len; i++){
            rowNums[i] = index;
            if(index == 0){
                asc = true;
            }
            if(index == numRows - 1){
                asc = false;
            }
            if(asc){
                index ++;
            } else {
                index --;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            int currentIndex = i;
            for(int j = 0; j < len; j++){
                if(rowNums[j] == currentIndex){
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }

}
