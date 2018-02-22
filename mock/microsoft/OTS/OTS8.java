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

public class OTS8 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 

    public boolean convertNumber(String str) {
        boolean canConvert = false;
        try {
            short n = Short.parseShort(str);
            if(n != 0) {
                canConvert = true;
            }
        } catch(NumberFormatException ex) {
            printString("" + ex);
        }

        boolean retval = false;
        if(canConvert == true) {
            retval = true;
        }
        return retval;
    }


	public static void main(String[] args) {
		OTS8 obj = new OTS8();   
        obj.printString("res:" + obj.convertNumber("123"));
        obj.printString("res:" + obj.convertNumber("12347192391792374222"));
        obj.printString("res:" + obj.convertNumber("123sa"));
	}

}
