package com.dy.leetcode1;

public class Solution {
	public int[] twoSum(int[] inputs, int target) {
		int[] result = new int[] { 0, 0 };
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i =0;i<inputs.length;i++) {
			int val = inputs[i];
			if(map.containsKey(val) && target == val*2){
				result[0] = map.get(val);
				result[1] = i;
				break;
			} else if(map.containsKey(target-val)){
				result[0] = map.get(target-val);
				result[1] = i;
				break;
			}
			map.put(val, i);
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
