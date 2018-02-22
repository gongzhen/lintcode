import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode {
	public char value;
	ListNode next;
	public ListNode(char v) {
		value = v;
		next = null;
	}
}
public class OTS1 {

	public ListNode compare(ListNode n1, ListNode n2) {
		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}

		ListNode p1 = n1;
		ListNode p2 = n2;
		int signN1 = 1, signN2 = 1;
		if(p1.value == '+') {
			signN1 = 1;
			p1 = p1.next;	
		} else if (p1.value == '-') {
			signN1 = -1;
			p1 = p1.next;	
		}
				
		
		if(p2.value == '+') {
			signN2 = 1;
			p2 = p2.next;	
		} else if (p2.value == '-') {
			signN2 = -1;
			p2 = p2.next;	
		}		

		/// n1 and n2 both starts from digit.
		StringBuilder sb1 = new StringBuilder();
		while(p1 != null && Character.isDigit(p1.value)) {
			sb1.append(p1.value);
			p1 = p1.next;
		}
		StringBuilder sb2 = new StringBuilder();		
		while(p2 != null && Character.isDigit(p2.value)) {
			sb2.append(p2.value);

			p2 = p2.next;
		}

		int num1 = Integer.parseInt(sb1.toString());
		int num2 = Integer.parseInt(sb2.toString());

		num1 = num1 * signN1;
		num2 = num2 * signN2;

		return num1 > num2 ? n1 : n2;
	}


	public static void main(String[] args) {
		OTS1 obj = new OTS1();		
		ListNode n1 = new ListNode('1');
		ListNode n2 = new ListNode('2');
		ListNode sign = new ListNode('-');
		ListNode n3 = new ListNode('3');
		ListNode n4 = new ListNode('4');
		n1.next = n3;
		sign.next = n2;
		n2.next = n4;
		ListNode res = obj.compare(n1, sign);
		System.out.println(res.value);
	}

}
