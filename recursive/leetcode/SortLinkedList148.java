package recursive.leetcode;

import helper.ListNode;

public class SortLinkedList148 {

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

    public void printList(ListNode head){
        ListNode last = head;
        while (last!=null) {
            System.out.print(last.val+" ");
            last = last.next;
        }
    }

    public ListNode mergeSortList(ListNode l1, ListNode l2) {

        ListNode list = new ListNode();
        ListNode last = list;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                last.next = new ListNode(l1.val);
                l1 = l1.next;
                last = last.next;
            }else{
                last.next = new ListNode(l2.val);
                l2 = l2.next;
                last = last.next;
            }
        }

        while(l1 != null){
            last.next = new ListNode(l1.val);
            l1 = l1.next;
            last = last.next;
        }

        while(l2 != null){
            last.next = new ListNode(l2.val);
            l2 = l2.next;
            last = last.next;
        }


        return list.next;



//        ListNode last = l1;
//        while (last.next != null)
//            last = last.next;
//
//        last.next = l2;
//
//        int status;
//        do{
//            ListNode current = l1;
//            status = 0;
//
//            while (current!=null && current.next!=null){
//                if(current.val>current.next.val){
//                  status = 1;
//                    current.val = current.val + current.next.val;
//                    current.next.val = current.val - current.next.val;
//                    current.val = current.val - current.next.val;
//                }
//
//                current = current.next;
//            }
//        }while (status == 1);
//
//        return l1;

    }

    public ListNode sortListRecursively(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = sortListRecursively(l1.next, l2);
            return l1;
        }
        else {
            l2.next = sortListRecursively(l1, l2.next);
            return l2;
        }

    }


    public static void main(String[] args) {

        SortLinkedList148 sortLinkedList148 = new SortLinkedList148();
        ListNode l1 = sortLinkedList148.add(null,1);
        l1 = sortLinkedList148.add(l1,2);
        l1 = sortLinkedList148.add(l1,4);

        //sortLinkedList148.printList(l1);
        //System.out.println();

        ListNode l2 = sortLinkedList148.add(null,1);
        l2 = sortLinkedList148.add(l2,3);
        l2 = sortLinkedList148.add(l2,4);

//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode();

        ListNode sortedList = sortLinkedList148.mergeSortList(l1, l2);
        sortLinkedList148.printList(sortedList);
        //sortLinkedList148.printList(l2);
        //l1 = sortLinkedList148.sortListRecursively(l1, l2);
        //sortLinkedList148.printList(l1);
    }




}
