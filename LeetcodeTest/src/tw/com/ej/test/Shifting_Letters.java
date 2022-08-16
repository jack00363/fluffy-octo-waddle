package tw.com.ej.test;

import org.junit.Test;

public class Shifting_Letters {
	 public String shiftingLetters(String s, int[] shifts) {
		 int len = s.length();
		 char[] ss =s.toCharArray();
		 int t =shifts[len-1]%26;
		 ss[len-1] = (char) ((ss[len-1]-'a'+shifts[len-1])%26+'a');
		 for(int i =len-2;i>=0;i--) {
			 shifts[i]=(shifts[i]+shifts[i+1])%26;
			 ss[i] = (char) ((ss[i]-'a'+shifts[i])%26+'a');
		 }
	    return String.valueOf(ss);
	 }
	 @Test
	 public void aa() {
		 int[] a= {1,2,3};
		 System.out.println(shiftingLetters("aaa",a));
	 }
}
