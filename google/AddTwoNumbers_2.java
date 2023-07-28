package google;

import helper.ListNode;

public class AddTwoNumbers_2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head  = new ListNode();
        ListNode temp = head;

        int borrow = 0;
        while(l1.next != null && l2.next != null){

            int sum = l1.val + l2.val + borrow;
            int val = 0;
            if(sum > 9){
                borrow = sum % 10;
                val = sum / 10;
            }else{
                val = sum;
            }

            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            temp =  newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1.next != null){

            int sum = l1.val + borrow;
            int val = 0;
            if(sum > 9){
                borrow = sum % 10;
                val = sum / 10;
            }else{
                val = sum;
            }

            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            temp =  newNode;

            l1 = l1.next;
        }


        while(l2.next != null){

            int sum = l2.val + borrow;
            int val = 0;
            if(sum > 9){
                borrow = sum % 10;
                val = sum / 10;
            }else{
                val = sum;
            }

            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            temp =  newNode;

            l2 = l2.next;
        }

        return head.next;

    }

    public static void main(String[] args) {


        System.out.println(10%10);
        System.out.println(10/10);

        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};

        int borrow = 0;
        for(int i = 0; i < 3; i ++){
            int sum = arr1[i] + arr2[i] + borrow;
            borrow = sum / 10;
            int val = sum % 10;
            System.out.println(val);
        }


    }
}
