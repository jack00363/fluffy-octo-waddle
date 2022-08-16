package tw.com.ej.test;

import org.junit.Test;

public class ZigZag_Conversion {

//			    0123456789ABCD 
//			    
//			    3rows  048C13579BD26A
//			
//			0   4   8   C
//			1 3 5 7 9 B D    
//			2   6   A    
//			
//			   4rows   06C157BD248A39
//			    
//			0     6     C 
//			1   5 7   B D    
//			2 4   8 A    
//			3     9   
//	
//			   5rows   0817926A35BD4C
//			0       8
//			1     7 9
//			2   6	A
//			3 5		B D
//			4		C

	@Test
	public void aa() {
		System.out.println(convert("0123456789ABCD", 3));
		System.out.println(convert("0123456789ABCD", 4));
		System.out.println(convert("0123456789ABCD", 5));
		System.out.println(convert("AA", 1));
	}

	public String convert(String s, int numRows) {
		if(numRows==1||numRows==s.length())return s;
		char[] c = new char[s.length()];
		c[0] = s.charAt(0);
		for(int i=0,j=0,odd=0,temp=-2*(numRows-1),len=s.length();i<len;i++,odd++) {
			
			if(j==0||j==numRows-1) temp =temp+2*(numRows-1);
			else temp=temp+2*(odd%2!=0?numRows-j-1:0+j);
			if(temp>=len) {j++;temp=j;odd=0;};
			c[i]=s.charAt(temp);
		}
		return String.valueOf(c);
	}
}
