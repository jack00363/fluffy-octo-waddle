package tw.com.ej.test;

import org.junit.Test;

public class Reverse_Integer {
	
	
	@Test
	public void pp() {
		System.out.println(isPalindrome(121));

	}
	
	public boolean isPalindrome(int x) {
        if(0>x)return false;
        int y=x;
        long res = 0;
		for (; x != 0; x /= 10)
			res = res * 10 + x % 10;
        
        return (int)res==y?true:false;
    }
	
	
	
	
	public int reverse(int x) {
        long res = 0;
		for (; x != 0; x /= 10)
			res = res * 10 + x % 10;
		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int) res;
    }
	
	public int r(int x) {
		String reverse=new StringBuilder(String.valueOf(x>0?x:-Long.valueOf(x))).reverse().toString();
		if(Long.valueOf(reverse)>Integer.MAX_VALUE)return 0;
		return x<0?-Integer.valueOf(reverse):Integer.valueOf(reverse);
	}
}
