package helper;

public class LinkedListHelper {

    public static ListNode add(ListNode head, int val) {
        ListNode newNode = new ListNode(val, null);
        if(head == null)  head = newNode;
        else {
           ListNode last = head;
            while (last.next!=null){
                last = last.next;
            }

            last.next = newNode;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode last = head;
        while (last!=null) {
            System.out.print(last.val+" ");
            last = last.next;
        }
    }
}
