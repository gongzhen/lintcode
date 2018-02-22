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

public class OTS10 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 

    private void printVertical(int n) {
        if(n == 0) {
            printString("" + n);
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        int sign = 1;
        if(n  < 0) {
            sign = -1;
            n = -n;
        }
        while(n > 0) {
            int mode = n % 10;
            list.add(mode);
            n = n / 10;
        }
        int i = list.size() - 1;
        for(; i>= 0; i--) {
            printString("" + sign * list.get(i));
            sign = 1;
        }
    }


	public static void main(String[] args) {
		OTS10 obj = new OTS10();   
        obj.printVertical(123);
        obj.printVertical(1);
        obj.printVertical(0);
        obj.printVertical(-123);
	}

}
