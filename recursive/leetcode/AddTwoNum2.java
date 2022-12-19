package recursive.leetcode;

import helper.LinkedListHelper;
import helper.ListNode;

public class AddTwoNum2 {

    public static ListNode l1 = LinkedListHelper.add(null,9);
    public static ListNode l2 = LinkedListHelper.add(null,9);
    public static ListNode ans = new ListNode();
    public static ListNode ansLast = ans;

    public static void main(String[] args) {

        l1 = LinkedListHelper.add(l1,9);
        l1 = LinkedListHelper.add(l1,9);
        l1 = LinkedListHelper.add(l1,9);
        l1 = LinkedListHelper.add(l1,9);
        l1 = LinkedListHelper.add(l1,9);
        l1 = LinkedListHelper.add(l1,9);

        l2 = LinkedListHelper.add(l2,9);
        l2 = LinkedListHelper.add(l2,9);
        l2 = LinkedListHelper.add(l2,9);
        addTwoNumbers();
        LinkedListHelper.printList(ans);
    }

    public static ListNode addTwoNumbers() {



        ListNode carryNode = getAddition(0);

        int carry = carryNode.val;
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            ansLast.next = newNode;
            ansLast = ansLast.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            ansLast.next = newNode;
            ansLast = ansLast.next;
            l2 = l2.next;
        }

        if(carry != 0 )
            ansLast.next = new ListNode(carry);

        return ans.next;
    }

    public static ListNode getAddition(int carry){

        if(l1 == null || l2 == null){
            return  new ListNode(carry);
        }

        int sum = l1.val + l2.val + carry;
        carry = sum / 10;

        ListNode newNode = new ListNode(sum % 10);
        ansLast.next = newNode;
        ansLast = ansLast.next;
        l1 = l1.next;
        l2 = l2.next;
        return getAddition(carry);

    }
}
