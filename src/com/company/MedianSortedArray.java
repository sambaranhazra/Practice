package com.company;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
public class MedianSortedArray {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = nums1.length;
        int right = nums2.length;
        int[] merged = new int[left + right];
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else
                merged[k++] = nums2[j++];
        }
        while (i < left) {
            merged[k++] = nums1[i++];
        }
        while (j < right) {
            merged[k++] = nums2[j++];
        }
        if (merged.length % 2 == 1) {
            return merged[merged.length / 2];
        } else {
            return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{1, 1}));
    }
}
