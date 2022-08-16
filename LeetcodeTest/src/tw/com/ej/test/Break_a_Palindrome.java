package tw.com.ej.test;

public class Break_a_Palindrome {
    public String breakPalindrome(String palindrome) {
    	if(palindrome.length()<=1)return "";
    	StringBuilder sb = new StringBuilder(palindrome);
    	int i=0;
    	while(palindrome.charAt(i)=='a'&&i!=palindrome.length()-1) i++;
    	if(i==0)return sb.replace(0, 1, "a").toString();
    	if(i==1&&palindrome.charAt(2)=='a')return sb.replace(i+1, i+2, "b").toString();
    	if(i==palindrome.length()-1) return sb.replace(i, i+1, "b").toString();
    	if(i==palindrome.length()/2&&palindrome.charAt(i)=='b'&&palindrome.charAt(i+1)=='a'&&palindrome.charAt(i-1)=='a')return sb.replace(palindrome.length()-1,palindrome.length(), "b").toString();;
    	return sb.replace(i, i+1, String.valueOf((char)(palindrome.charAt(i)-1))).toString();
    }
}
