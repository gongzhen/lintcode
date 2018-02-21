import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
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

// 245. Subtree 
public class Solution4 {

    public String minWindow(String source, String target) {
     Map<Character, Integer> map = new HashMap<>();
        char[] arr = target.toCharArray();
        // make a map for each char in target string.
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            char key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            counter++;
        }
        printString("line 130");
        printMap(map);
        printLine();
        // int counter = map.size(); // counter is the number of different char in target.
        arr = source.toCharArray();
        int start = 0, end = 0;
        int min = -1;
        int head = 0;
        // two points start and end. Both start at index 0.
        while (end < arr.length) {
            if (counter > 0) { // check if counter == 0
                char key = arr[end]; // check each char from source.
                if (map.containsKey(key)) { // if map has the char
                    int count = map.get(key) - 1; // get the count for the key
                    if (count >= 0) { 
                        counter--; // if count>= 0, minus 1 for counter.                        
                    }
                    printString("counter: " + counter + ", key:" + key);
                    map.put(key, count); // put the new count for key.
                    printString("line 150");
                    printMap(map);
                    printLine();                    
                }
                end++; // end move forward 1.
            }
            while (start < end && counter == 0) { // when start < end and counter == 0
                int size = end - start;  // counter == 0 means we cover all chars from target. we get the size now.
                printString("line 157 size: " + size + ", start: " + start + ", end: " + end);
                if (min == -1 || size < min) { // min = -1, first time for min.
                    head = start; // head = start and min = size;
                    min = size;
                    printString("line 161 min: " + min + ", head: " + head);
                }
                char key = arr[start]; // get key from start index.
                if (map.containsKey(key)) { // if map contains key, we will add counter
                    int count = map.get(key) + 1; // count >= 1 here.
                    printString("line 166 start: " + key + ", count: " + count);                    
                    if (count >= 1) counter++; // add counter if count >= 1
                    map.put(key, count); // map put key for new count.
                    printString("line 169");
                    printMap(map);
                    printLine();                      
                }
                start++; // start moves forward to next index.              
            }
        }
        return min == -1 ? "" : source.substring(head, head + min);
    }

    private void printLine() {
    	System.out.println("---------------------"); 
	}

    private void printMap(Map<Character, Integer> map) {
        for(Character key : map.keySet()) {
            Integer value = map.get(key);
            printString("key:" + key + ",value:" + value);
        }
    }    

    private void printString(String arg) {
        System.out.println(arg); 
    } 

	public static void main(String[] args) {
		Solution4 obj = new Solution4();
        System.out.println(obj.minWindow("absdfaabab", "adb"));
	}

}
