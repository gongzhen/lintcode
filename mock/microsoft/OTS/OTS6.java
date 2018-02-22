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

public class OTS6 {

    private void printString(String arg) {
        System.out.println(arg + ","); 
    } 
    
    /// private int GetPriority(String productCode).
    public void OrderProductsByPriority(String[] productCodes) {
        // int[] codes = new int[productCodes.length];
        // int i = 0;
        // for(String code: productCodes) {
        //     codes[i++] = GetPriority(code);
        // }

        /// [1, 0, 2, 1, 0, 1, 1, 2, 0]
        int[] nums = {1, 0, 2, 1, 0, 1, 1, 2, 0};
        int zero = nums.length - 1;
        int second = 0;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] == 2 && i > second) {
                int temp = nums[i];
                nums[i] = nums[second];
                nums[second] = temp;
                second++;
            }

            while(nums[i] == 0 && i < zero) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero--;
            }            
        }

        for(int n : nums) {
            printString(n + ", ");
        }
    }

	public static void main(String[] args) {
		OTS6 obj = new OTS6();
        String[] strs = new String[]{"111", "22", "333", "44"};
        obj.OrderProductsByPriority(strs);
	}

}
