package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class AddTwoNumber {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		if (isPalindrome2(111121111)) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		int future = 0;
		int current = 0;
		while (l1.next != null || l2.next != null) {
			int l1Num = l1 == null ? 0 : l1.val;
			int l2Num = l2 == null ? 0 : l2.val;
			future = (l1Num + l2Num + future) / 10;
			current = (l1Num + l2Num + future) % 10;
			result.val = current;
			result = result.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			
		}
		return result;
    }
	
	
    
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
		
}



