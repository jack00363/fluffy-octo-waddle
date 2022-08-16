package tw.com.ej.test;

public class Reverse_Only_Letters {
    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j) {
        	if(!Character.isLetter(c[i])) i++; 
        	else if(!Character.isLetter(c[j])) j--; 
        	else {
	        	char temp=c[i];
	        	c[i] =c[j];
	        	c[j] = temp;
	        	i++;
	        	j--;
	        	}
        }
        return new String(c);
        
    }
}
