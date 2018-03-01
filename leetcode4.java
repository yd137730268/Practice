package com.dy.leetcode4;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * Solution: 
 * 	   	1. 转换成求两个有序数组中的第n小的数或者2个数，即可得到中位数
 *   	2. 求两个有序数组中nth小的数（多个有序数组同理）: 
 *   		Step1 ： 如果有一个数组为空返回另一个数组的nth值；如果n = 1， 直接比较两个数组的头元素，step3, 否则step2；
 *   		Step2 ： 比较2个数组的skip(skip = min(n/2,nums1.length-s1,nums2.length-s2) 位置上的数字，
 *   			小的一组前序必定小于nth的数，舍去，移动该数组的下标s1+skip 或者 s2+skip，n -= skip 继续step1； 
 *   		Step3: 返回值
 * @author dy83694
 *
 */
public class Solution2 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalSize = nums1.length + nums2.length;
		double median = -1;
		if (totalSize % 2 == 1)
			median = findNth(nums2, nums1, 0, 0,
					(nums1.length + nums2.length) / 2 + 1);
		else {
			double nth1 = findNth(nums2, nums1, 0, 0,
					(nums1.length + nums2.length) / 2);
			double nth2 = findNth(nums2, nums1, 0, 0,
					(nums1.length + nums2.length) / 2 + 1);
			median = (nth1 + nth2) / 2;
		}
		return median;
	}

	public double findNth(int[] nums1, int[] nums2, int startIndex1,
			int startIndex2, int nth) {
		int s1 = startIndex1;
		int s2 = startIndex2;
		if (s1 == nums1.length) {
			return nums2[s2 + nth - 1];
		}
		if (s2 == nums2.length) {
			return nums1[s1 + nth - 1];
		}
		int skip = Math.min(nth / 2, nums1.length - s1);
		skip = Math.min(skip, nums2.length - s2);
		if (skip == 0) {
			return Math.min(nums1[s1], nums2[s2]);
		}
		int nthNum1 = nums1[s1 + skip - 1];
		int nthNum2 = nums2[s2 + skip - 1];
		if (nthNum1 <= nthNum2) {
			return findNth(nums1, nums2, s1 + skip, s2, nth - skip);
		} else {
			return findNth(nums1, nums2, s1, s2 + skip, nth - skip);
		}
	}

	public static void main(String[] args) {
		int a[], b[];

		a = new int[] { 1, 2 };
		b = new int[] { 1, 2, 3 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 2);

		a = new int[] { 1, 2, 6 };
		b = new int[] { 6, 7, 8, 9, 10 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 6.5);

		a = new int[] { 1, 2, 6, 7 };
		b = new int[] { 3, 4, 5, 8 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 4.5);

		a = new int[] { 1, 2, 6 };
		b = new int[] { 3, 4, 5 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 3.5);

		a = new int[] { 1, 2, 6 };
		b = new int[] { 3, 4, 5 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 3.5);

		a = new int[] { 1, 2 };
		b = new int[] { 3, 4 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 2.5);

		a = new int[] { 1, 2, 5 };
		b = new int[] { 3, 4, 6 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 3.5);

		a = new int[] { 3 };
		b = new int[] { 1, 2 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 2);

		a = new int[] { 1, 3 };
		b = new int[] { 2 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 2);

		a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		b = new int[] { 5, 6, 7, 8, 9 };
		System.out.print(new Solution2().findMedianSortedArrays(a, b));
		System.out.println(" " + 5.5);
	}
}
