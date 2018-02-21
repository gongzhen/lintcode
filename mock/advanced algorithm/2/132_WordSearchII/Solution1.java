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
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     * by Gong Zhen
     * 
     */
     
    private class TrieNode {
        Hashtable<Character, TrieNode> tb;
        boolean endWord;
         
        public TrieNode() {
            tb = new Hashtable<Character, TrieNode>();
            endWord = false;
        }
    }
    
    public TrieNode buildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode ptr = root;            
            for (Character c: word.toCharArray()) {
                if (ptr.tb.containsKey(c) == false){
                    ptr.tb.put(c, new TrieNode());
                }
                ptr = ptr.tb.get(c);
            }
            ptr.endWord = true;
        }
        return root;
    }
     
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return result;
        }
        
        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.tb.containsKey(board[i][j])) {
                    dfs(board, root, visited, i, j, "", result);    
                }
            }
        }
        return result;
    }
    
    public void dfs(char[][] board, TrieNode node, boolean[][] visited, int row, int col, String str, ArrayList<String> result) {
        if (node == null) {
            return;
        }
        
        if (node.endWord == true) {
            result.add(str);
            node.endWord = false;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == true) {
            return;
        }
                
        visited[row][col] = true;
        char c = board[row][col];
        dfs(board, node.tb.get(c), visited, row + 1, col, str + c, result);
        dfs(board, node.tb.get(c), visited, row - 1, col, str + c, result);
        dfs(board, node.tb.get(c), visited, row, col + 1, str + c, result);
        dfs(board, node.tb.get(c), visited, row, col - 1, str + c, result);
        visited[row][col] = false;
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
