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

public class OTS4 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        
        int len = 1;
        ListNode tail = head;
        /// 1->2->3->4->5->NULL
        /// len = 5 , k = 2
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }
        /// 1->2->3->4->5 (tail)
        /// |____________|
        tail.next = head;
        k = k % len;
        if(k > 0) {
            for(int i = 0; i < len - k; i++) {
                tail = tail.next;
            }            
        }

        /// 1->2->3 (tail)->4->5
        /// |__________________|
        ListNode newHead = tail.next;
        /// 1->2->3 (tail)->4(newHead)->5
        /// |___________________________|
        tail.next = null;
        return newHead;
    }
	public static void main(String[] args) {
		OTS4 obj = new OTS4();		
		obj.MakeNumbersMatch(3, 5, 6, 9);
	}

}
