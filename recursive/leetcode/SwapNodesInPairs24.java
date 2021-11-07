package recursive.leetcode;

import helper.LinkedListHelper;
import helper.ListNode;

public class SwapNodesInPairs24 {

    public static ListNode swapPairs(ListNode head, int start, int end) {

        if(start>=end) return head;

        if((end - start + 1) == 2){
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }

        int mid = start + (end - start) / 2;

        if((mid + 1) % 2 !=0)
            mid = mid - 1;

        int str = start;
        ListNode temp = head;
        while (str<mid) {
            temp = temp.next;
            str++;
        }

        ListNode rightNode = temp.next;
        temp.next = null;

        ListNode leftList = swapPairs(head, start, mid);
        ListNode rightList = swapPairs(rightNode, mid + 1, end);

        ListNode last = leftList;
        while(last.next != null)
            last = last.next;

        last.next =  rightList;

        return leftList;

    }

    public static void main(String[] args) {

        SwapNodesInPairs24 sortLinkedList24 = new SwapNodesInPairs24();

        ListNode l1 = LinkedListHelper.add(null,1);
        l1 = LinkedListHelper.add(l1,2);
        l1 = LinkedListHelper.add(l1,3);
        l1 = LinkedListHelper.add(l1,4);
        l1 = LinkedListHelper.add(l1,5);


        int end = 0;
        ListNode last = l1;
        while(last.next!=null){
            end++;
            last = last.next;
        }

        ListNode swapList = swapPairs(l1, 0,  end);
        LinkedListHelper.printList(swapList);
    }


}
