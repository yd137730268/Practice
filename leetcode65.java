package com.dy.leetcode65;

import java.util.Arrays;

public class Solution {
	public boolean isNumber(String s) {
		s = s.trim();
		int indexE = s.indexOf("e");
		if (indexE > 0) {
			String numberP = s.substring(0, indexE);
			String numberL = s.substring(indexE+1);
			return isDouble(numberP) && isInt(numberL);
		} else {
			return isDouble(s);
		}
	}

	private boolean isDouble(String s) {
		int indexD = s.indexOf(".");
		if (indexD > 0) {
			String num = s.substring(0, indexD);
			String num10 = s.substring(indexD+1);
			boolean numInt = isInt(num);
			boolean numDouble = isInt(num10);
			return numInt && numDouble;
		} else {
			return isInt(s);
		}
	}

	private boolean isInt(String s) {
		if(s.isEmpty())return false;
		for (char c : s.toCharArray()) {
			if (c < 48 || c > 57) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] inputs = { "0", " 0.1 ", "abc", "1 a", "2e10" ,"2e",".1","0.","133.231","1.2e5"};
		Arrays.asList(inputs).stream().forEach(s -> {
			System.out.println(new Solution().isNumber(s));
		});
	}
}
