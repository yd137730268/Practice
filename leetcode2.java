package com.dy.leetcode2;

public class Solution {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a, b, addtion = 0;
		ListNode curl1 = l1, curl2 = l2;
		ListNode resultHead = null, resultTail = resultHead;
		while (curl1 != null || curl2 != null || addtion > 0) {
			if (curl1 != null) {
				a = curl1.val;
				curl1 = curl1.next;
			} else {
				a = 0;
			}
			if (curl2 != null) {
				b = curl2.val;
				curl2 = curl2.next;
			} else {
				b = 0;
			}
			int sum = a + b + addtion;
			addtion = sum / 10;
			ListNode newNode = new ListNode(sum % 10);
			if(resultHead == null) {
				resultHead = newNode;
				resultTail = newNode;
			}else{
				resultTail.next = newNode;
				resultTail = resultTail.next;
			}
		}
		return resultHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l1.next = l12;
		l12.next = l13;

		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(9);
		l2.next = l22;
		l22.next = l23;

		ListNode list = new Solution().addTwoNumbers(l1, l2);
		while (list!= null) {
			System.out.println(list.val);
			list = list.next;
		}
	}
}
