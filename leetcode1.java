package com.dy.leetcode1;

public class Solution {
	public int[] twoSum(int[] inputs, int target) {
		int[] result = new int[] { 0, 0 };
		if (inputs == null || inputs.length == 0)
			return result;

		long[] sums = new long[inputs.length];
		sums[0] = inputs[0];
		for (int i = 1; i < inputs.length; i++) {
			sums[i] = sums[i - 1] + inputs[i];
		}
		forA: for (int i = sums.length - 1; i > 0; i--) {
			if (target == sums[i]) {
				result[0] = 0;
				result[1] = i;
				break forA;
			}
			for (int j = 0; j < i; j++) {
				if (target == (sums[i] - sums[j])) {
					result[0] = j + 1;
					result[1] = i;
					break forA;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 2, 7, 11, 15 };
		int target = 20;
		int[] result = new Solution().twoSum(input, target);
		System.out.println("result : [" + result[0] + ", " + result[1] + "]");
	}
}
