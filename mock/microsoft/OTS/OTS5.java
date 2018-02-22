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

public class OTS5 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 
    /// http://www.1point3acres.com/bbs/thread-226124-1-1.html

    public List<String> contiguousSubstring(String str) {
        List<String> res = new ArrayList<String>();
        if(str.length() == 0) {
            return res;
        }

        char[] array = str.toCharArray();
        for(int i = 0; i < array.length - 1; i++ ) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] - array[j - 1] != 1) {
                    break;
                }
                if(j - i + 1 >= 2) {
                    res.add(str.substring(i, j + 1));    
                }                    
            }
        }
        return res;
    }

	public static void main(String[] args) {
		OTS5 obj = new OTS5();	
        String str = "BCCDEG";	
		List<String> res = obj.contiguousSubstring(str);
        for(String word : res) {
            obj.printString(word);
        }
	}

}
