package com.dy.leetcode5;

public class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String subString = null;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			String subStringTemp = getPalidromeLength(s, i);
			if (subStringTemp.length() > length) {
				subString = subStringTemp;
				length = subString.length();
			}
		}
		return subString;
	}

	private String getPalidromeLength(String s, int mid) {
		char[] chars = s.toCharArray();
		int length = 1;
		int start = 0, end = 1;
		int i = 0;
		// case "bab"
		for (i = 1; i + mid < chars.length && mid - i >= 0; i++) {
			if (chars[i + mid] != chars[mid - i]) {
				break;
			}
		}
		length = i * 2 - 1;
		start = mid - i + 1;
		end = i + mid;
		
		// case "baab"
		for (i = 1; i + mid <= chars.length && mid - i >= 0; i++) {
			if (chars[i + mid - 1] != chars[mid - i]) {
				break;
			}
		}
		int length2 = i * 2 - 1;
		if (length2 > length) {
			length = length2;
			start = mid - i +1;
			end = i + mid -1;
		}
		return s.substring(start, end);
	}

	public static void main(String[] args) {
//		String s1 = "babad";
//		System.out.println(s1);
//		for(int i=0;i<s1.length();i++)
//		System.out.println(new Solution().getPalidromeLength(s1,i));

		String s = null;
		
		s = "bb";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("bb");
		
		s = "ccd";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("cc");
		
		s = "babad";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("bab");
		s = "cbbd";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("bb");

		s = "a";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("a");

		s = "ccc";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("ccc");

		s = "abcda";
		System.out.println("input : " + s);
		System.out.println(new Solution().longestPalindrome(s));
		System.out.println("a");

	}
}
