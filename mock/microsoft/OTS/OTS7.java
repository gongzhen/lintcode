import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ListNode {
 	int val;
 	ListNode next;
 	ListNode(int x) { val = x; }
}

public class OTS7 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = l1;
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        ListNode p2 = l2;
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }  
        
        if(len1 < len2) {
            return addTwoNumbers(l2, l1);
        }
        
        /// l1 >= l2;
        p1 = reverse(l1);
        p2 = reverse(l2);        
        ListNode head = new ListNode(-1);
        head.next = p1;
        int carry = 0;
        while(p2 != null) {
            int sum = p2.val + p1.val + carry;
            carry = sum / 10;
            p1.val = sum % 10;
            if(p1.next == null && p2.next == null && carry > 0)  {
                ListNode node = new ListNode(carry);
                p1.next = node;
                carry = 0;
            }            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        while(p1 != null && carry > 0) {
            int sum = p1.val + carry;
            carry = sum / 10;
            p1.val = sum % 10;
            if(p1.next == null && carry > 0)  {
                ListNode node = new ListNode(carry);
                p1.next = node;
                carry = 0;
            }             
            p1 = p1.next;
        }
        return reverse(head.next);
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null) {
            return null;
        }
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }    


	public static void main(String[] args) {
		OTS7 obj = new OTS7();    
	}

}
