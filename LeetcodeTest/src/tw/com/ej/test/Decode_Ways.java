package tw.com.ej.test;

import org.junit.Test;

public class Decode_Ways {
	@Test
	public void aa() {
		System.out.println(getNum(9));
	}
	
	public int numDecodings(String s) {
		if(s.charAt(0)=='0') return 0;
		int answer=1;
		int number=0;
		
		for(int i = 0;i<s.length();i++) {
			switch (s.charAt(i)) {
			case '1':
				number++;
				break;
			case '2':
				if(i+1<s.length()&&s.charAt(i+1)-48>6)number--;
				number++;
				break;
			case'0':
				if(s.charAt(i-1)-48>2||s.charAt(i-1)=='0')return 0;
				number-=2;
			default:
				answer*=getNum(++number);
				number=0;
				break;
			}
		}
		answer*=getNum(number);
        return answer;
    }
	private int getNum(int i) {
		 int n1=1,n2=1,temp;
		 for(;i>1;i--) {
			 temp = n2;
			 n2 = n1+temp;
			 n1=temp;
		 }
		return n2;
	}
	
}
