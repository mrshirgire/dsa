package linkedlist;


public class LC2181 {

    public SLinkedList.ListNode mergeNodes(SLinkedList.ListNode head) {

        SLinkedList.ListNode temp = head;
        SLinkedList.ListNode tempHead = head;

        while(temp != null) {
            int sum = 0;
            do{
                sum+=temp.val;
                temp = temp.next;
            }while(temp!= null && temp.val != 0);

            if(sum != 0){
                SLinkedList.ListNode node = new SLinkedList.ListNode(sum);
                tempHead.next = node;
                tempHead = node;
            }

        }
        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        SLinkedList sLinkedList  = new SLinkedList();

        int[] arr = {0,1,0,3,0,2,2,0};
        for(int i =0; i < arr.length; i++){
            sLinkedList.add(arr[i]);
        }
        LC2181 lc2181 = new LC2181();
        lc2181.mergeNodes(sLinkedList.head);
    }


}
