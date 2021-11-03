class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//[
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
public class MergeListNodes {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);

        l31.next = l32;

        ListNode[] list = new ListNode[3];
        list[0] = l11;
        list[1] = l21;
        list[2] = l31;

        ListNode mergedList = mergeKLists(list);

        while(mergedList!=null){
            System.out.print(mergedList.val+" ");
            mergedList = mergedList.next;
        }

    }

    private static ListNode mergeKLists(ListNode[] lists) {
        return partition(0, lists.length - 1, lists);
    }

    private static ListNode partition(int l, int r, ListNode[] lists) {
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
    }
}
