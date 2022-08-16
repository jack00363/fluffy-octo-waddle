package tw.com.ej.test;

public class Split_Linked_List_in_Parts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int nodelength=0;
        ListNode temp= head;
        while (temp!=null) {
        	nodelength++;
        	temp = temp.next;
        }
        ListNode[] answer = new ListNode[k];
        for(int i= 0;i<k;i++) {
        	int j=nodelength/k;
        	if(i<nodelength%k) j++;
        	
        	
        	if(--j>=0) {
        		answer[i]=new ListNode(head.val);
        		temp =answer[i];
        		head = head.next;
        	}
        	while(--j>=0) {
        		temp.next = new ListNode(head.val);
        		temp = temp.next;
        		head = head.next;
        	}
        }
        return answer;
    }
}
