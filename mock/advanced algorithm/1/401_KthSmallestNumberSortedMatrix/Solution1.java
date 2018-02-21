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

    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     * by Gong Zhen
     * time complexity: logn + n + k
     */
    private class Node {
         private int row;
         private int col;
         private int val;
         public Node(int row, int col, int val) {
             this.row = row;
             this.col = col;
             this.val = val;
         }
     }

    public int kthSmallest_1(int[][] matrix, int k) {
        // write your code here
        
        if (matrix == null || matrix.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        // logn
        PriorityQueue<Node> pq = new PriorityQueue<Node>(matrix.length, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val; // minHeap
            }
        });
        
        // m
        for (int col = 0; col < matrix[0].length; col++) {
            pq.offer(new Node(0, col, matrix[0][col]));
        }
        
        // k
        for (int i = 0; i < k - 1; i++) {
            Node minNode = pq.poll();
            // row + 1 < matrix.length not row < matrix.length
            if (minNode.row + 1 < matrix.length) {
                pq.offer(new Node(minNode.row + 1, minNode.col, matrix[minNode.row + 1][minNode.col]));
            }
        }
        return pq.poll().val;
    }

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(matrix.length * matrix[0].length, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                pq.offer(new Pair(i, j, matrix[i][j]));
            }
        }
        
        
        int i = 0;
        Pair pair = null;
        while(!pq.isEmpty()) {
            pair = pq.poll();
            i++;
            if(i == k) {
                break;
            }
        }
        if(pair == null) {
            return Integer.MIN_VALUE;
        }
        return pair.val;
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
