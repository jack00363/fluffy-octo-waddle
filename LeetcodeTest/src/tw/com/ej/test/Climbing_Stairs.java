package tw.com.ej.test;

public class Climbing_Stairs {
    public int climbStairs(int n) {
    	int n1=1,n2=1,temp;
		 for(;n>1;n--) {
			 temp = n2;
			 n2 = n1+temp;
			 n1=temp;
		 }
		return n2;
    }
}
