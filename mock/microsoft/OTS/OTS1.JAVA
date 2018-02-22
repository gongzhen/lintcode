import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode {
	public char value;
	ListNode next;
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
		if(Character.isLetter(p1.value)) {
			if(p1.value == '+') {
				signN1 = 1;
			} else if (p1.value == '-') {
				signN1 = -1;
			}
			while(Character.isLetter(p1.value)) {
				p1 = p1.next;	
			}			
		}
		if(Character.isLetter(p2.value)) {
			if(p2.value == '+') {
				signN2 = 1;
			} else if (p2.value == '-') {
				signN2 = -1;
			}
			p2 = p2.next;
			while(Character.isLetter(p2.value)) {
				p2 = p2.next;	
			}			
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

	}

}
