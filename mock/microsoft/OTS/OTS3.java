import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class OTS3 {

	private void printString(String arg) {
	    System.out.println(arg + ","); 
	} 
	//// make a == x b == y
	public void MakeNumbersMatch(int a, int b, int x, int y){
		while(a != x || b != y){
			if(a > x){
				a--;
			}else if (a < x){
				a++;
			}
			if(b > y){
				b--;
			}else if (b < y){
				b++;
			}
			// printString("a:" + a + ", b: " + b);
			// printString("x:" + x + ", y: " + y);	
			
		}
		printString("28 a:" + a + ", b: " + b);
		printString("29 x:" + x + ", y: " + y);
	}
	public static void main(String[] args) {
		OTS3 obj = new OTS3();		
		obj.MakeNumbersMatch(3, 5, 6, 9);
	}

}
