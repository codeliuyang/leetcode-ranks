package Q4;

import org.junit.Test;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void tst(){
        findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int start = 0;
        boolean oneMore = false;
        if(length % 2 != 0){
            start = (length-1) / 2;
        } else {
            start = length / 2 - 1;
            oneMore = true;
        }
        int i1 = 0, i2 = 0;
        for(int i = 0; i < length; i++){
            int n1 = nums1[i1], n2 = nums2[i2];
            int rightNum = 0;
            if(n1 <= n2){
                i1 ++;
                rightNum = n1;
            } else {
                i2 ++;
                rightNum = n2;
            }
            if(start == i ) {
                if(!oneMore){
                    return rightNum;
                } else {
                    return (rightNum + (nums1[i1] <= nums2[i2] ? nums1[i1] : nums2[i2])) / 2.0;
                }
            }
        }
        return 0.0;
    }

}
