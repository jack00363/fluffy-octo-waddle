package tw.com.ej.test;

public class Maximum_Number_of_Balloons {
	public int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(char c:text.toCharArray()) {
        	if(c=='b') b++;
        	if(c=='a') a++;
        	if(c=='l') l++;
        	if(c=='o') o++;
        	if(c=='n') n++;
        }
        
        b=Math.min(b, a);
        l=Math.min(l/2, o/2);
        b=Math.min(b, Math.min(l, n));
        return b;
    }
}
