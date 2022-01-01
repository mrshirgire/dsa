package leetcode;

public class LeetCode_83 {


    public static void main(String[] args) {
        LL ll = new LL();

        ll.insert(1);
        ll.insert(1);
        ll.insert(1);


        ll.display();
        deleteDuplicates(ll.head);
        System.out.println();
        ll.display();
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode temp = head;

        while(temp.next!=null){

            if (temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else {
               temp = temp.next;
            }
        }

        return head;
    }

}
