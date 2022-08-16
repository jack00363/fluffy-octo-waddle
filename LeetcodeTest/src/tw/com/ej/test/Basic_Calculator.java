package tw.com.ej.test;

import java.util.Stack;

import org.junit.Test;

public class Basic_Calculator {
	@Test
	public void aa() {
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	
	
    int i=0;
    public int calculate(String s) {
        int ans=0;
        int curr=0;
        int currsign=1;
        
        while(i<s.length()){
            char ch=s.charAt(i++);
            if(ch>='0'&&ch<='9'){
                curr=curr*10+ch-'0';
            }
            else{
                ans+=curr*currsign;
                curr=0;
                if(ch=='-'){
                    currsign=-1;
                }
                else if(ch=='+'){
                    currsign=1;
                }
                else if(ch=='('){
                    ans=ans+calculate(s)*currsign;
                    System.out.println(ans);
                }
                else if(ch==')'){
                    return ans;
                }    
            }
        }
        return ans+curr*currsign;
    }

	public int calculateByEJ(String s) {
		int answer=0;
	    int temp = 0;
	    boolean isAdd=true;
	    Stack<Boolean> stack = new Stack<Boolean>();
	    stack.push(true);
	    s=s.replace(" ", "");
        for(int i=0;i<s.length();i++) {
        	switch(s.charAt(i)) {
        		case '+':
        			if(isAdd^stack.lastElement()) answer-=temp;
        			else answer+=temp;
        			temp=0;
        			isAdd=true;
        			break;
        		case '-':
        			if(isAdd^stack.lastElement()) answer-=temp;
        			else answer+=temp;
        			isAdd=false;
        			temp=0;
        			break;
        		case '(':
        			if(i>0&&s.charAt(i-1)=='-') {stack.push(!stack.lastElement());
        			isAdd=true;}
        			else stack.push(stack.lastElement());;
        			break;
        		case ')':
        			if(isAdd^stack.lastElement()) answer-=temp;
        			else answer+=temp;
        			temp=0;
        			stack.pop();
        			break;
        		default:
        			temp=temp*10+s.charAt(i)-48;
        	}
        }
        if(isAdd^stack.lastElement()) answer-=temp;
		else answer+=temp;
        return answer;
    }
}
