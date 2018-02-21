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

    /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null) {
            return 0;
        }
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int len = 0;
        
        for(int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
            while(map.size() > k) {
                map.put(cs[left], map.get(cs[left]) - 1);
                if(map.get(cs[left]) == 0) {
                    map.remove(cs[left]);
                }
                left++;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    } 

   /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct_1(String s, int k) {
        // write your code here

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0, max = 0;
        while(i < s.length() && j < s.length()) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                if(map.size() >= k) {
                    // remove j
                    max = Math.max(max, i - j);
                    while(map.size() >= k) {
                        char left = s.charAt(j);
                        int count = map.get(left);
                        count--;
                        if(count == 0) {
                            map.remove(left);
                        } else {
                            map.put(left, count);
                        }
                        j++;
                    }
                } else if(map.size() < k){
                    map.put(c, 1);
                    i++;
                }
                printString("substr:" + s.substring(j, i) + ", length:" + s.substring(j, i).length());
                printString("max:" + max + ", i: " + i + ", j: " + j + ", map.size():" + map.size()); 
                printMap(map);
            } else {
                int count = map.get(c);
                count++;
                map.put(c, count);
                i++;
            } 
            printLine();
        }
        
        return max;        
    }   


    public int lengthOfLongestSubstringKDistinct_2(String s, int k) {
      // write your code here
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        if(s.length() <= k){
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            //如果遇到的字符是之前出现过的，则直接将其数量加1
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            }else{
            //如果遇到的新字符之前没有出现过则分情况讨论
            //若目前遇到过字符种类不足k个，则直接加入
                if(map.size() < k){
                    map.put(s.charAt(right), 1);
                }else{
            //若目前遇到过的字符种类大于k个，则移动左边界减少字符，直到字符种类少于k个后再加入
                    max = Math.max(max, right - left);
                    while(map.size() >= k){
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        if(map.get(s.charAt(left)) == 0){
                            map.remove(s.charAt(left));
                        }
                        left++;
                    }
                    map.put(s.charAt(right), 1);
                }
            }
            right++;
        }

        //right到底之后要统计最后一次substring的长度
        max = Math.max(max, right - left);

        return max;
    }

   /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct_3(String s, int k) {
        // write your code here
           // write your code here
        if(k == 0) {
            return 0;
        }
        if(s.length() <= k) {
            return s.length();
        }      
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int i = 0, j = 0, max = 0;
        
        while(i < s.length() && j < s.length()) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                count++;
                map.put(c, count);
                i++;
            } else { /// c not in map
                if(map.size() < k) {
                    map.put(c, 1);
                } else {
                    max = Math.max(max, i - j);
                    printString("substr:" + s.substring(j, i) + ", length:" + s.substring(j, i).length());
                    printString("max:" + max + ", i: " + i + ", j: " + j + ", map.size():" + map.size()); 
                    printMap(map); 
                    printLine();                   
                    while(map.size() >= k) { /// remove map key
                        char left = s.charAt(j);
                        if(map.containsKey(left)) {
                            int count = map.get(left);
                            count--;
                            if(count == 0) {
                                map.remove(left);
                            } else {
                                map.put(left, count);    
                            }
                        }                         
                        j++;                        
                    }
                    map.put(c, 1);
                }
                i++;
            }
        }
        max = Math.max(max, i - j);
        return max;
    }   

    public int lengthOfLongestSubstringKDistinct_4(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0, max = 0;
        while(i < s.length()) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            }

            if(map.size() > k) {
                while(map.size() > k) {
                    if(map.containsKey(s.charAt(j))) {
                        int count = map.get(s.charAt(j));
                        --count;
                        if(count == 0) {
                            map.remove(s.charAt(j));
                        } else {
                            map.put(s.charAt(j), count);
                        }
                    }
                    j++;
                }
            }
            max = Math.max(max, i - j + 1);
            i++;
            printString("substr:" + s.substring(j, i) + ", length:" + s.substring(j, i).length());
            printString("max:" + max + ", i: " + i + ", j: " + j + ", map.size():" + map.size()); 
            printLine();                               
        }
        return max;
        // int[] count = new int[256];
        // int num = 0, i = 0, max = 0;
        // for (int j = 0; j < s.length(); j++) {
        //     if (count[s.charAt(j)]++ == 0) num++;
        //     if (num > k) {
        //         while (--count[s.charAt(i++)] > 0);
        //         num--;
        //     }
        //     max = Math.max(max, j - i + 1);
        // }
        // return max;        
    }

    private int mapSize(int[] count) {
        int len = 0;
        for(int n : count) {
            if(n != 0) { len++ ; }
        }
        return len;
    }

    private void printSet(Set<Character> set) {
        int i = 1;
        printStringWithoutNewLine("[");
        for(char c : set){
            printStringWithoutNewLine((i++) + ":" + c + ", ");
        }
        printStringWithoutNewLine("]\n");
    }  

    private void printMap(Map<Character, Integer> map) {
        int i = 1;
        printStringWithoutNewLine("[");
        for(char c : map.keySet()){
            printStringWithoutNewLine((i++) + ": " + c + ", ");
        }
        printStringWithoutNewLine("]\n");
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
        System.out.println(obj.lengthOfLongestSubstringKDistinct_4("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 0));
        // System.out.println(obj.lengthOfLongestSubstringKDistinct_4("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
        // System.out.println(obj.lengthOfLongestSubstringKDistinct_4("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));   
        // System.out.println(obj.lengthOfLongestSubstringKDistinct_4("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25));   
        // System.out.println(obj.lengthOfLongestSubstringKDistinct_4("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25));           
        
	}

}
