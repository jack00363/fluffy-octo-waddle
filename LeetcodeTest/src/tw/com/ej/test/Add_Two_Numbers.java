package tw.com.ej.test;

public class Add_Two_Numbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		//dummy為最外層的Node,l1+l2會存在他next,而p會一直替換成nextNode,所以不能只創p或dummy
		ListNode p, dummy = new ListNode(0);
		p = dummy;
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(carry % 10);
			carry /= 10;
			p = p.next;
		}
		return dummy.next;
	}
	//KSFW
	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0){
            
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
           
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            
            if(l3 != null){
                ListNode data = l3;
                while(data.next != null)
                    data = data.next;
                data.next = new ListNode(sum % 10);
            }else{
                l3 = new ListNode(sum % 10);
            }
            sum /= 10;
        }
        return l3 != null ? l3 : new ListNode();
    }

	public class ListNode {
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
}
