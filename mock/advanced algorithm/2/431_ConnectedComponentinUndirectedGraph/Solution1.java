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

class UF {
    
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> size;
    private int count;
    
    public UF(Set<Integer> nodes) {
        count = nodes.size();
        parent = new HashMap<>();
        size = new HashMap<>();
        for (int node: nodes) {
            parent.put(node, node);
            size.put(node, 1);
        }
    } 
    
    public int getCount() {
        return count;
    }
    
    public Map<Integer, Integer> getParent() {
        return parent;
    }
    
    public int find(int p) {
        int root = p;
        while (root != parent.get(root)) {
            root = parent.get(root);
        }
        while (p != parent.get(root)) {
            int newP = parent.get(p);
            parent.put(p, root);
            p = newP;
        }
        return root;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size.get(rootP) < size.get(rootQ)) {
            parent.put(rootP, rootQ);
            size.put(rootQ, size.get(rootQ) + size.get(rootP));
        } else {
            parent.put(rootQ, rootP);;
            size.put(rootP, size.get(rootQ) + size.get(rootP));
        }
        count--;
    }
}

public class Solution1 {

    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        Set<Integer> nodesSet = new HashSet<>();
        for (UndirectedGraphNode node: nodes) {
            nodesSet.add(node.label);
            for (UndirectedGraphNode neighbor: node.neighbors) {
                nodesSet.add(neighbor.label);
            }
        }
        UF uf = new UF(nodesSet);
        for (UndirectedGraphNode node: nodes) {
            for (UndirectedGraphNode neighbor: node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        List<List<Integer>> result = new ArrayList<>(uf.getCount());
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for (Integer node: uf.getParent().keySet()) {
            int root = uf.find(node);
            if (resultMap.containsKey(root)) {
                resultMap.get(root).add(node);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node);
                resultMap.put(root, list);
            }
        }
        for (List<Integer> list: resultMap.values()) {
            Collections.sort(list);
            result.add(list);
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
