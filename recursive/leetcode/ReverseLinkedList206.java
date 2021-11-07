package recursive.leetcode;

import helper.ListNode;

public class ReverseLinkedList206 {

   public void printList(ListNode head){
      ListNode last = head;
      while (last!=null) {
        System.out.print(last.val+" ");
        last = last.next;
      }
   }

   public static void main(String[] args) {
      ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();

      ListNode head = reverseLinkedList206.add(null,10);
      head = reverseLinkedList206.add(head,20);
      head = reverseLinkedList206.add(head,30);

      reverseLinkedList206.printList(head);

      System.out.println();
      ListNode reverseHead = reverseLinkedList206.reverseList(head);
      reverseLinkedList206.printList(reverseHead);


   }

   public ListNode add(ListNode head, int val){
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

   public ListNode reverseList(ListNode head){

       if (head == null || head.next == null)
           return head;
       ListNode p = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return p;
  }

}
