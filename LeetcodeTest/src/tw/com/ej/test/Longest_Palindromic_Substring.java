package tw.com.ej.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Longest_Palindromic_Substring {
	
	@Test
	public void aa() {
		Longest_Palindromic_Substring l  =new Longest_Palindromic_Substring();
//		System.out.println(l.longestPalindrome("babad"));
//		System.out.println(l.longestPalindrome("cbbd"));
//		System.out.println(l.longestPalindrome("a"));
//		System.out.println(l.longestPalindrome("ac"));
//		System.out.println(l.longestPalindrome("cccc"));
//		System.out.println(l.longestPalindrome("aacabdkacaa"));
//		System.out.println(l.longestPalindrome("aaaaa"));
		System.out.println(l.longestPalindrome("ababababa"));
	
	}
	//online
public String longestPalindromeBest(String s) {
        
        int max = 1, index = 0; // the minimum palindromic substring for any s
        char [] ch = s.toCharArray();
        for(int i = 0, j, len = s.length(); i<len; i++){
            
            // check for odd palindromes
            j = 1;
            while((i-j >= 0 && i+j < len) && ch[i-j] == ch[i+j]){
                if((j<<1)+1 > max){
                    max = (j<<1)+1;
                    index = i;
                }
                j++;
            }
            
            // check for even palindromes
            j = 0;
            while((i-j >= 0 && i+j+1 < len) && ch[i-j] == ch[i+j+1]){
                j++;
                if(j<<1 > max){
                    max = j<<1;
                    index = i;
                }
            }
        }
        
        // return the palindrome
        return s.substring(index-(max>>1)+1-max%2, index+(max>>1)+1);
    }
	
	
	public String longestPalindrome(String s) {
		int[] temp = new int[2];
		System.out.println(s);
		int startIndex = 0;
		int endIndex = 0;
		Set set = new HashSet<CharSequence>();

		for (int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				if (i>=1&&s.charAt(i - 1) == s.charAt(i)) {
					startIndex = i - 1;
					endIndex = i;
					while(endIndex+1<s.length()&&s.charAt(endIndex+1)==s.charAt(endIndex)) endIndex++;
					while(startIndex-1>=0&&s.charAt(startIndex-1)==s.charAt(startIndex)) startIndex--;
					check(s,startIndex,endIndex,temp);
					
				}
				
				if(i>=2&&s.charAt(i - 2) == s.charAt(i)&&s.charAt(i-1)!=s.charAt(i)) {
					startIndex = i - 2;
					endIndex = i;
					check(s, startIndex, endIndex,temp);
				}
			}
			set.add(s.charAt(i));
		}
		return s.substring(temp[0], temp[1] + 1);
	}
	private void check(String s,int startIndex,int endIndex,int[] temp) {
		while (startIndex - 1 >= 0 && endIndex + 1 < s.length()
				&& s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
			startIndex--;
			endIndex++;
		}
		if (endIndex - startIndex > temp[1] - temp[0]) {
			temp[0] = startIndex;
			temp[1] = endIndex;
		}
		
	}
	
	
	
//第一次成功完成回傳最長映射字
	public String ttt(String s) {
		System.out.println(s);
		int startIndex = 0;
		int endIndex = 0;
		int[] temp = new int[2];
		Set set = new HashSet<CharSequence>();

		for (int i = 0,len=s.length(); i < len; i++) {
			if (set.contains(s.charAt(i))) {

				if (s.charAt(i - 1) == s.charAt(i)) {
					startIndex = i - 1;
					endIndex = i;
				}
				while (startIndex - 1 >= 0 && endIndex + 1 < len
						&& s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
					startIndex--;
					endIndex++;
				}
				if (endIndex - startIndex > temp[1] - temp[0]) {
					temp[0] = startIndex;
					temp[1] = endIndex;
				}
				if (i >= 2 && s.charAt(i - 2) == s.charAt(i)) {
					startIndex = i - 2;
					endIndex = i;
				}
				while (startIndex - 1 >= 0 && endIndex + 1 < len
						&& s.charAt(startIndex - 1) == s.charAt(endIndex + 1)) {
					startIndex--;
					endIndex++;
				}
				if (endIndex - startIndex > temp[1] - temp[0]) {
					temp[0] = startIndex;
					temp[1] = endIndex;
				}
			}
			set.add(s.charAt(i));
		}
		return s.substring(temp[0], temp[1] + 1);
	}

	// 找出最前最後的相同的最長字
	public String lll(String s) {
		char repeat = ' ';
		int temp = 0;
		Set set = new HashSet<CharSequence>();
		for (char c : s.toCharArray()) {
			if (set.contains(c) && s.lastIndexOf(c) - s.indexOf(c) > temp) {
				temp = s.lastIndexOf(c) - s.indexOf(c);
				repeat = c;
			}
			set.add(c);
		}

		return repeat == ' ' ? s.substring(0, 1) : s.substring(s.indexOf(repeat), s.lastIndexOf(repeat) + 1);
	}

	// 找出不重複的最長字
	public String ll(String s) {
		int startIndex = 0;
		int endIndex = 0;
		Map m = new HashMap<CharSequence, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (m.containsKey(s.charAt(i))) {
				if (i - (int) m.get(s.charAt(i)) > endIndex - startIndex) {
					endIndex = i;
					startIndex = (int) m.get(s.charAt(i));
				}
			}
			m.put(s.charAt(i), i);
		}

		return s.substring(startIndex, endIndex + 1);
	}
}
