package tw.com.ej.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Longest_Common_Prefix {
	@Test
	public void aa() {
		String[] s= {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(s));
	}
	
	public String longestCommonPrefix_OnLine(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
	
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0||strs[0].length()==0) return "";
		if(strs.length == 1) return strs[0];
		int i =0;
		char c = strs[0].charAt(i);
		
		for (int j = 1,len=strs.length; j<strs[0].length()*len; j++) {
			if(i==strs[j%len].length()||c!=strs[j%len].charAt(i)) {
				return strs[0].substring(0,i);
			}
			if(j%len==len-1) {
				i++;
				j++;
				if(i!=strs[0].length()) {c=strs[0].charAt(i);}
				else break;
			}
		}
		return strs[0].substring(0,i);
	}
}
