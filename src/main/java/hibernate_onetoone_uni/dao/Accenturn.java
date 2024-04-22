package hibernate_onetoone_uni.dao;

import java.util.ArrayList;
import java.util.List;

public class Accenturn {

	static int fact =1;
	
	public static void main(String[] args) {
		
		int n =5;
		System.out.println(getFactorial(n));
//		fewestSquare(n);
	}
	public static int getFactorial(int ip) {
		
		if(ip>0) {
			fact*=ip;
			return getFactorial(--ip);
		}else {
			return fact;
		}
	}

//	public static void fewestSquare(int n) {
//		int count =0;
//		
//		for(int i=1;i<=n;i++) {
//			for (int j = 1; j <=i; j++) {
//				if (j*j==i) {
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
//	}
}
