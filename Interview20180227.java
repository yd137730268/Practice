package com.dy.toutiao;

import java.util.Arrays;

/**
 * from 今日头条 算法
 * 一个int整数， 调整位置取得下一个大小的数字 1423 -> 1432 1342 -> 1423 1432 -> 2134 Solution:
 * step1
 * :　从个位开始遍历，和十位比较大小，如果当前位大于进位数则ｓｔｅｐ２，否则十位和百位继续比较；如果遍历结束未找到，则当前数已经是最大，进入step3；
 * step2 : 获取进位数和低位数字，取得比进位数大且最接近的数字替换该位置，其他的位置从剩余数字取一个最小的数字（剩余的数字升序），进入step3；
 * step3 : 结束并返回值；
 * 
 * @author dy83694
 *
 */
public class Solution {
	public static int nextVal(int inputArray) {
		char[] intArray = String.valueOf(inputArray).toCharArray();
		int i = intArray.length - 1;
		for (; i > 0; i--) {
			if (intArray[i] > intArray[i - 1]) {
				break;
			}
		}
		
		if (i > 0 && intArray[i] > intArray[i - 1]) {
			char maxDigtNum = intArray[i - 1];
			char nextValMaxDigtNum=intArray[i];
			int index = i;
			for ( int j = i;j < intArray.length; j++) {
				if (intArray[j] > maxDigtNum && intArray[j] < nextValMaxDigtNum) {
					nextValMaxDigtNum = intArray[j];
					index = j;
				}
			}
			intArray[i - 1] = intArray[index];
			intArray[index] = maxDigtNum;
			
			Arrays.sort(intArray, i, intArray.length);
		}
		
		return Integer.parseInt(String.valueOf(intArray));
	}

	public static void main(String[] args) {
		int input;
		
		input = 1432;
		System.out.println("input : 1432");
		System.out.println("expect : 2134");
		System.out.println("actual : "+nextVal(input));
		System.out.println("-----------------------");
		
		input = 1342; 
		System.out.println("input : 1342");
		System.out.println("expect : 1423");
		System.out.println("actual : "+nextVal(input));
		System.out.println("-----------------------");
		
		input = 1423;
		System.out.println("input : 1423");
		System.out.println("expect : 1432");
		System.out.println("actual : "+nextVal(input));
		System.out.println("-----------------------");
		

	}
}
