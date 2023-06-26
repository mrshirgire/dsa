package linkedlist;


import java.util.ArrayList;
import java.util.List;

//[
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
public class MergeListNodes {

    public static void main(String[] args) {

        SLinkedList sLinkedList1 = new SLinkedList();
        sLinkedList1.add(1);
        sLinkedList1.add(1);
        sLinkedList1.add(1);

        SLinkedList sLinkedList2 = new SLinkedList();
        sLinkedList2.add(1);
        sLinkedList2.add(4);
        sLinkedList2.add(5);

        SLinkedList sLinkedList3 = new SLinkedList();
        sLinkedList3.add(2);
        sLinkedList3.add(6);

        List<SLinkedList> list = new ArrayList<>();
        list.add(sLinkedList1);
        list.add(sLinkedList2);
        list.add(sLinkedList3);

        /*SLinkedList.ListNode mergedList = mergeKLists(list);

        while(mergedList!=null){
            System.out.print(mergedList.val+" ");
            mergedList = mergedList.next;
        }*/

    }

   /* private static SLinkedList.ListNode mergeKLists(List<SLinkedList> lists) {
        return partition(0, lists.size() - 1, lists);
    }*/

   /* private static SLinkedList.ListNode partition(int l, int r, List<SLinkedList> lists) {
        if (r < l) return null;
        if (r == l) return lists[r];
        if (r - l == 1) return mergeTwo(lists[l], lists[r]);

        var m = (l + r) / 2;
        var left = partition(l, m, lists);
        var right = partition(m + 1, r, lists);

        if (right == null) return left;
        if (left == null) return right;

        return  mergeTwo(left, right);
    }

    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
        var dummy = new ListNode();
        var curr = dummy;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {  curr.next = l1; l1 = l1.next; }
            else
            { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

        return dummy.next;
    }*/

}
