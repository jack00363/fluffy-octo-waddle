package tw.com.ej.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

public class Integer_to_Roman {

	@Test
	public void aaa() {
		System.out.println(romanToInt("MCMXCIV"));
	}

	// online
	public int romanToInt(String s) {
		int num = 0;
		int l = s.length();
		int last = 1000;
		for (int i = 0; i < l; i++) {
			int v = getValue(s.charAt(i));
			if (v > last)
				num = num - last * 2;
			num = num + v;
			last = v;
		}
		return num;
	}

	private int getValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

//mine
	public int mRomanToInt(String s) {
		Map<Character, Integer> m = new HashMap();
		m.put('M', 1000);
		m.put('D', 500);
		m.put('C', 100);
		m.put('L', 50);
		m.put('X', 10);
		m.put('V', 5);
		m.put('I', 1);
		int answer = 0;

		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (i + 1 < c.length && m.get(c[i]) < m.get(c[i + 1])) {
				answer -= m.get(c[i]);
			} else {
				answer += m.get(c[i]);
			}
		}

		return answer;
	}

//mine
	public String mIntToRoman(int num) {

		String.valueOf(num).length();
		Character[] chars = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		StringBuilder sb = new StringBuilder();
		for (int i = 1000, j = 0, temp; i > 0; i /= 10, j += 2) {
			temp = num / i;
			if (temp > 0) {
				num -= i * temp;
				if (temp % 5 == 4) {
					sb.append(chars[j]);
					sb.append(temp > 5 ? chars[j - 2] : chars[j - 1]);
				} else {
					if (temp >= 5) {
						sb.append(chars[j - 1]);
						temp -= 5;
					}
					while (temp-- > 0)
						sb.append(chars[j]);

				}
			}
		}
		return sb.toString();
	}

	// online
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		int[] div = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		for (int i = 0; i < div.length;) {
			if (num >= div[i]) {
				result.append(roman[i]);
				num -= div[i];
			} else {
				i++;
			}
		}

		return result.toString();
	}

}
