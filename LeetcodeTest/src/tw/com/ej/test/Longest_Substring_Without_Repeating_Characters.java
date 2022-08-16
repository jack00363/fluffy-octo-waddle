package tw.com.ej.test;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
	
	//若出現同字元時 此時可確定目前字串長度,而下一個不重複的字的開始位置為剛剛同字元的第一個的索引直
	//有兩種方式 一種為把第一個字元前的字串砍光,或是把第一個字元開始的字重新開始算
	
	
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				//把出現相同的字元前的值都去除,直到完全沒有重複的值
				set.remove(s.charAt(i++));
			}
		}

		return max;

	}
}
