package tw.com.ej.test;

public class Reverse_Linked_List {
	
	public ListNode reverseList_yu(ListNode head) {
		ListNode listNode = null;
		while (head != null) {
			listNode = new ListNode(head.val, listNode);
			head = head.next;
		}
		return listNode;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode listNode = new ListNode(head.val);
		while (head.next != null) {
			head = head.next;
			listNode = new ListNode(head.val, listNode);
		}
		return listNode;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
