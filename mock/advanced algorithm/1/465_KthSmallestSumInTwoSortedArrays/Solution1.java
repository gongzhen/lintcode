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
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     * By Zhen Gong
     * time complexity: logn + n 
     * 
     */
     
     private class Node {
         private int indexA;
         private int indexB;
         private int sum;
         
         public Node(int indexA, int indexB, int sum) {
            this.indexA = indexA;
            this.indexB = indexB;
            this.sum = sum;
         }
     }
     
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        // 
        PriorityQueue<Node> pq = new PriorityQueue<Node>(A.length + B.length, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                // minHeap
                return a.sum - b.sum;
            }
        });
        
        for (int i = 0; i < A.length; i++) {
            // add B[0] + A[i]
            pq.offer(new Node(i, 0, A[i] + B[0]));
        }
        
        for (int i = 0; i < k - 1; i++) {
            Node minNode = pq.poll();
            // i == k - 1, it will break and pop
            if (minNode.indexB + 1 < B.length) {
                pq.offer(new Node(minNode.indexA, minNode.indexB + 1, A[minNode.indexA] + B[minNode.indexB + 1]));
            }
        }
        return pq.poll().sum;
        
    } 

    private void printSet(Set<Character> set) {
        printStringWithoutNewLine("[");
        for(char c : set){
            printStringWithoutNewLine(c + ", ");
        }
        printStringWithoutNewLine("]\n");
    }       

    private void printMap(Map<Character, Integer> map) {
        for(char c:map.keySet()) {
            Integer value = map.get(c);
            printString("key:" + c + ",value:" + value);
        }
    }

    /*
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        // if(s.length() == 0) {
        //     return 0;
        // }
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(allUniqueChar(s, i, j) == true) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
    
    public boolean allUniqueChar(String s, int i, int j) {
        String subStr = s.substring(i, j);
        Set<Character> set = new HashSet<Character>();
        char[] array = subStr.toCharArray();
        for(char c: array) {
            if(set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
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
        // System.out.println(obj.lengthOfLongestSubstring_1("gehmbfqmozbpripibusbezagafqtypz"));
        System.out.println(obj.lengthOfLongestSubstring_2("an++--viaj"));
	}

}
