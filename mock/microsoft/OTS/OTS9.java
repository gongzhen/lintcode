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

public class OTS9 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 

    private void reformat(String[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            String num = numbers[i];
            String[] array = num.split("-");
            // printString("array:" + array[0]);
            if(array.length == 1) {
                if(num.length() == 10) {
                    String prefix = num.substring(0, 3);
                    String areaCode = num.substring(3, 6);
                    String line = num.substring(6, 10);
                    String newNum = areaCode + "-" + prefix + "-" + line;
                    numbers[i] = newNum;
                }                
            } else if (array.length == 3){
                String prefix = array[0];
                String areaCode = array[1];
                String line = array[2];
                String newNum = areaCode + "-" + prefix + "-" + line;
                numbers[i] = newNum;
            }
        }
    }


	public static void main(String[] args) {
		OTS9 obj = new OTS9();   
        String[] numbers = new String[]{"1234567890", "123-456-7890"};        
        obj.reformat(numbers);
        for(String num: numbers) {
            obj.printString("" + num);
        }
        String test = " 1";
        String[] tests = test.split(" ");
        for(String str : tests) {
            obj.printString("53:[" + str + "]");
        }
	}

}
