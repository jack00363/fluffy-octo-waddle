package tw.com.ej.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Merge_k_Sorted_Lists {
	  class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		     ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	  public ListNode mergeKLists(ListNode[] lists) {
		  	List<Integer> s = new ArrayList<Integer>();
	        ListNode listNode =new ListNode(0),l;
	        l=listNode;
	        for(int i = 0;i<lists.length;i++) {
	        	ListNode temp=lists[i];
	        	while(temp!=null) {
	                l.next=new ListNode(0);
	                l=l.next;
	        		s.add(temp.val);
	        		temp=temp.next;
	        	}
	        }
	        Collections.sort(s);
	        l=listNode.next;
	        for(int i:s) {
	        	l.val=i;
	        	l=l.next;
	        }
	        return listNode.next;
	    }
	
}
