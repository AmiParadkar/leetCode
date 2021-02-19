package com.leetcode;
import java.util.Arrays;
public class MedainOfTwoArray {

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double result = 0;
            int nums12[] = new int[nums1.length+nums2.length];
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            System.arraycopy(nums1,0,nums12,0,nums1.length);
            System.arraycopy(nums2,0,nums12,nums1.length, nums2.length);
            Arrays.sort(nums12);
            int medianIndex = 0;
            if((nums12.length) %2 != 0){
                medianIndex = Math.round(nums12.length/2);
                result = nums12[medianIndex];
            }else {
                medianIndex = (nums12.length / 2) - 1;
                double i = nums12[medianIndex] + nums12[medianIndex+1];
                result = (i / 2);
            }
            return result;


        }
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double result = 0;
        int nums12[] = new int[nums1.length+nums2.length];
        if((nums1 == null || nums1.length == 0) &&(nums2 == null || nums2.length == 0) ){
            return result;

        } else if((nums1 == null || nums1.length == 0) && (nums2 != null || nums2.length > 0)){
            if(nums2.length == 1){
                result = nums2[0];
                return result;
            }
            int i = 0;
            while(i < nums2.length){
                nums12[i] = nums2[i];
                i++;
            }
        } else if((nums2 == null || nums2.length == 0) && (nums1 != null || nums1.length > 0)){
            if(nums1.length == 1){
                result = nums1[0];
                return result;
            }
            int i = 0;
            while(i < nums1.length){
                nums12[i] = nums1[i];
                i++;
            }
        } else if(nums1.length == 1 && nums2.length == 1 && nums1[0] == nums2[0]){

                return result = nums1[0];
        } else {
            int i=0, j = 0, index =0;
            while(index <= (nums1.length+nums2.length)/2){
                if(i< nums1.length && j < nums2.length && (nums1[i] <= nums2[j])){
                    nums12[index] = nums1[i];
                    i++;
                } else if ((j< nums2.length) && i < nums1.length && nums2[j] <= nums1[i]){
                    nums12[index]= nums2[j];
                    j++;

                } else if(i< nums1.length && j >= nums2.length){
                    nums12[index]= nums1[i];
                    i++;
                } else if(j < nums2.length && i >= nums1.length){
                    nums12[index]= nums2[j];
                    j++;
                }
                index++;

            }
            if((nums1.length+nums2.length) %2 != 0){
                result = nums12[index - 1];
                return result;
            }else {
                result = ((float)nums12[index-2] + nums12[index-1]) / 2;
                return result;
            }
        }
        // System.arraycopy(nums1,0,nums12,0,nums1.length);
        // System.arraycopy(nums2,0,nums12,nums1.length, nums2.length);
        // if(nums12.length ==1){
        //     result = nums12[0];
        //     return result;
        // }
        // Arrays.sort(nums12);
        int medianIndex = 0;
        if((nums12.length) %2 != 0){
            medianIndex = Math.round(nums12.length/2);
            result = nums12[medianIndex];
        }else {
            medianIndex = (nums12.length / 2) - 1;
            result = ((float)nums12[medianIndex] + nums12[medianIndex+1]) / 2;
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println("Hello World!");
//        int[] nums1={1, 2};
//        int[] nums2 ={3,4};
//        int[] nums1={0, 0};
//        int[] nums2 ={0,0};
//        int[] nums1={};
//        int[] nums2 ={1};
//        int[] nums1={2};
//        int[] nums2 ={};
//        int[] nums1={1, 3};
//        int[] nums2 ={2};
//        int[] nums1={1};
//        int[] nums2 ={1};
        int[] nums1={1,1};
        int[] nums2 ={1,1};
        System.out.print(findMedianSortedArrays1(nums1,nums2));

    }
}
