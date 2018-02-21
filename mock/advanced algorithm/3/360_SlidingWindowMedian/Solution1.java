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

// 401. Kth Smallest Number in Sorted Matrix.
public class Solution1 {
    
    private TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
    private TreeMap<Integer, Integer> minHeap = new TreeMap<>();
    private int leftCount = 0;
    private int rightCount = 0;
    
    private void addNum(int num) {
        if (maxHeap.isEmpty()) {
            addNum(maxHeap, num);
            leftCount++;
        } else {
            int mid = maxHeap.firstKey();
            if (num <= mid) {
                addNum(maxHeap, num);
                leftCount++;
            } else {
                addNum(minHeap, num);
                rightCount++;
            }
        }
        balance();
    }
    
    private void addNum(TreeMap<Integer, Integer> heap, int num) {
        if (heap.containsKey(num)) {
            heap.put(num, heap.get(num) + 1);
        } else {
            heap.put(num, 1);
        }
    }
    
    private void deleteNum(int num) {
        if (minHeap.containsKey(num)) {
            deleteNum(minHeap, num);
            rightCount--;
        } else {
            deleteNum(maxHeap, num);
            leftCount--;
        }
        balance();
    }
    
    private void deleteNum(TreeMap<Integer, Integer> heap, int num) {
        int count = heap.get(num) - 1;
        if (count == 0) {
            heap.remove(num);
        } else {
            heap.put(num, count);
        }
    }
    
    private void balance() {
        if (leftCount > rightCount + 1) {
            int removeKey = maxHeap.firstKey();
            deleteNum(maxHeap, removeKey);
            addNum(minHeap, removeKey);
            leftCount--;
            rightCount++;
        }
        if (leftCount < rightCount) {
            int removeKey = minHeap.firstKey();
            deleteNum(minHeap, removeKey);
            addNum(maxHeap, removeKey);
            leftCount++;
            rightCount--;
        }
    }
    
    private int getMedian() {
        return (int)maxHeap.firstKey();
    }
    
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            addNum(nums[i]);
        }
        for (int i = k - 1; i >= 0 && i < nums.length; i++) {
            addNum(nums[i]);
            result.add(getMedian());
            deleteNum(nums[i - k + 1]);
        }
        return result;
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
		Solution1 obj = new Solution1();
        // System.out.println(obj.kthSmallest(t1, t2));
	}

}
