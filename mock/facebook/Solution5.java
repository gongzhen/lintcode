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

// 612. K Closest Points

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution5 {

   /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        globalOrigin = origin;
        PriorityQueue<Point> minHeap = new PriorityQueue<>(k + 1, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                int dif = getDistance(p2, globalOrigin) - getDistance(p1, globalOrigin);
                if (dif == 0) {
                    dif = p2.x - p1.x;
                }
                if (dif == 0) {
                    dif = p2.y - p1.y;
                }
                return dif;
            }
        });
        
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(points[i]);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        
        k = minHeap.size();
        Point[] ret = new Point[k];  
        while (!minHeap.isEmpty())
            ret[--k] = minHeap.poll();
        return ret;
    }

    Point go;
    public Point[] kClosest_gz(Point[] points, Point origin, int k) {
        // write your code here
        go = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
            public int compare(Point a, Point b) {
                int diff = getDistance(b, go) - getDistance(a, go);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if(diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        for(Point p : points) {
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int size = pq.size();
        Point[] res = new Point[size];
        int i = size - 1;
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            res[i--] = p;
        }              
        return res;
    }
    
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
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
            printStringWithoutNewLine("[" + i + "]:" + n + ", ");
            i++;
        }
        printStringWithoutNewLine("]\n");
    } 

    private void printStringWithoutNewLine(String arg) {
        System.out.print(arg); 
    } 


	public static void main(String[] args) {
		Solution5 obj = new Solution5(); 
        Point[] ps = new Point[]{new Point(4, 6),new Point(4, 7),new Point(4, 4),new Point(2, 5),new Point(1, 1)};
        Point origin = new Point(0, 0);
        Point[] res = obj.kClosest_gz(ps, origin, 3);
        for(Point p : res) {
            obj.printString("p:" + p.x + ", " + p.y);
        }
	}

}
