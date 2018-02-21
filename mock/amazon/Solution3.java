import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// class TreeNode {
//  int val;
//  TreeNode left;
//  TreeNode right;
//  TreeNode(int x) { val = x; }
// }
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
// private TreeNode createTree() {
//  //       5
//  //    2      7
//  //  1   3      10
//  TreeNode node5 = new TreeNode(5);
//  TreeNode node2 = new TreeNode(2);
//  TreeNode node1 = new TreeNode(1);
//  TreeNode node7 = new TreeNode(7);
//  TreeNode node10 = new TreeNode(10);

//  node5.left = node2;
//  node5.right = node7;
//  node2.left = node1;
//  node2.right = node3;
//  node5.right = node7;
//  node7.right = node10; 
//  return node5;
// }
// private void printList(List<String> list) {
//  for(String s: list) {
//      System.out.println(s);
//  }
// }
// private void printQueue(Queue<String> list) {
//  for(String s: list) {
//      System.out.println(s);
//  }
// } 
// private void enterKey() {
//     System.out.println("Press \"ENTER\" to continue...");
//     Scanner scanner = new Scanner(System.in);
//     scanner.nextLine();      
// }
// private void printListOfList(List<List<Integer>> listOflist) {
//  for(List<Integer> list: listOflist){
//      for(int n : list) {
//          System.out.print(n + ", ");
//      }
//      System.out.println();
//  }
// }
// private void printMatrix(int[][] matrix) {
//     for(int[] s: matrix) {
//         for(int n: s) {
//             System.out.print(n + ",");
//         }
//         System.out.println();            
//     }
// }  
//  private void scannerIn() {
//    Scanner scanner = new Scanner(System.in);
//    scanner.nextLine();
// }
// private void printString(String arg) {
//     System.out.println(arg); 
// }
// private void printLine() {
//     System.out.println("---------------------"); 
// }  
// 
// private void printMap(HashMap<TreeNode, Integer> map) {
//     for(TreeNode node:map.keySet()) {
//         Integer value = map.get(node);
//         printString("key:" + node.val + ",value:" + value);
//     }
// }
// private void printStringWithoutNewLine(String arg) {
//     System.out.print(arg + ","); 
// } 
// private void printArray(int[] list) {
//     printStringWithoutNewLine("[");
//     for(int n: list) {
//         printStringWithoutNewLine(n + ", ");
//     }
//     printStringWithoutNewLine("]\n");
// } 
// private void printArray(int[] list) {
//     printStringWithoutNewLine("[");
//     int i = 0;
//     for(int n : list) {
//         printStringWithoutNewLine("[" + i + "]" + n + ", ");
//         i++;
//     }
//     printStringWithoutNewLine("]\n");
// }  
// private void printArray(int[] list, int s, int e) {
//     printStringWithoutNewLine("[");
//     for(int i = s; i <= e; i++) {
//         printStringWithoutNewLine("[" + i + "]" + list[i] + ", ");
//     }
//     printStringWithoutNewLine("]\n");
// } 
// private void printStringWithoutNewLine(String arg) {
//     System.out.print(arg); 
// }  
// private void printStringWithoutNewLine(String arg) {
//     System.out.print(arg); 
// } 
// private void printStack(Stack<Integer> stack) {
//     Interator<Integer> iter = stack.iterator();
//     while(iter.hasNext()) {
//         printString("" + iter.next());
//     }
// }
// private void printTree(TreeNode root) {
//     if(root == null) { return ; }
//     Queue<TreeNode> queue = new LinkedList<TreeNode>();
//     queue.offer(root);
//     while(!queue.isEmpty()) {
//         int size = queue.size();
//         for(int i = 0; i < size; i++) {
//             TreeNode node = queue.poll();                
//             if(node.left != null) {
//                 queue.offer(node.left);
//             }
//             if(node.right != null) {
//                 queue.offer(node.right);
//             }                
//             printStringWithoutNewLine("" + node.val);
//         }
//         printLine();
//     }
// } 


// 655. Big Integer Addition
public class Solution3 {

    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

   public String addStrings_bad(String num1, String num2) {
        // write your code here
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        int len1 = c1.length;
        int len2 = c2.length;
        
        if(len1 < len2) {
            return addStrings(num2, num1);
        }
        
        int diff = len1 - len2;
        // len1 is always longer.
        long sum = 0;
        long tempSum = 0;
        long reminder = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = len1 - 1; i >= 0; i--) {
            char char1 = c1[i];
            if(i - diff < 0) {
                break;
            }
            char char2 = c2[i - diff];
            long d1 = Character.getNumericValue(char1);
            long d2 = Character.getNumericValue(char2);
            tempSum = d1 + d2 + reminder;
            reminder = tempSum / 10;
            tempSum = tempSum % 10;
            sum = sum + tempSum * (long)Math.pow(10, count);
            count++;
        }
        
        if(diff > 0) {
            for(int i = diff - 1; i >= 0; i--) {
                char char1 = c1[i];
                long d1 = Character.getNumericValue(char1);
                tempSum = d1 + reminder;
                reminder = tempSum / 10;
                tempSum = tempSum % 10;
                sum = sum + tempSum * (long)Math.pow(10, count);
                count++;
            }
        }
        
        if(reminder == 1) {
            sum = sum + reminder * (long)Math.pow(10, count);
        }
        
        return Long.toString(sum);
    }

    public String addStrings(String num1, String num2) {
       char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        int len1 = c1.length;
        int len2 = c2.length;
        
        if(len1 < len2) {
            return addStrings(num2, num1);
        }
        
        int diff = len1 - len2;
        // len1 is always longer.
        int sum = 0;
        int tempSum = 0;
        int reminder = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = len1 - 1; i >= 0; i--) {
            char char1 = c1[i];
            if(i - diff < 0) {
                break;
            }
            char char2 = c2[i - diff];
            int d1 = Character.getNumericValue(char1);
            int d2 = Character.getNumericValue(char2);
            tempSum = d1 + d2 + reminder;
            reminder = tempSum / 10;
            tempSum = tempSum % 10;
            sb.append(tempSum);
        }
        
        if(diff > 0) {
            for(int i = diff - 1; i >= 0; i--) {
                char char1 = c1[i];
                int d1 = Character.getNumericValue(char1);
                tempSum = d1 + reminder;
                reminder = tempSum / 10;
                tempSum = tempSum % 10;
                sb.append(tempSum);
            }
        }
        
        if(reminder == 1) {
            sb.append(reminder);
        }
        
        char[] c3 = sb.toString().toCharArray();
        int len3 = c3.length;
        for(int i = 0; i < len3 / 2; i++) {
            char temp = c3[i];
            c3[i] = c3[len3 - i - 1];
            c3[len3 - i - 1] = temp;
        }
        
        return new String(c3);        
    }

    private void printNodeList(ListNode head) {
        while(head != null) {
            printStringWithoutNewLine("" + head.val + ", ");
            head = head.next;
        }
        printString("");
    }    

    private int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void printLine() {
    	System.out.println("---------------------"); 
	}

    private void printString(String arg) {
        System.out.println(arg); 
    }    

    private void printArray(int[] list) {
        printStringWithoutNewLine("[");
        int i = 0;
        for(int n : list) {
            printStringWithoutNewLine("[" + i + "]" + n + ", ");
            i++;
        }
        printStringWithoutNewLine("]\n");
    } 

    private void printStringWithoutNewLine(String arg) {
        System.out.print(arg + ","); 
    } 


	public static void main(String[] args) {
		Solution3 obj = new Solution3();
        System.out.println(obj.addStrings("9999999999981", "19"));
	}

}
