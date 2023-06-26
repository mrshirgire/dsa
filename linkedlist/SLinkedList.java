package linkedlist;



public class SLinkedList{

     static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    ListNode head = null;

     public ListNode addList(int[] arr){
         SLinkedList sLinkedList  = new SLinkedList();
         for(int i =0; i < arr.length; i++){
             sLinkedList.add(arr[i]);
         }

         return sLinkedList.head;
     }
    public ListNode add(int val){
        
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
        }else{
            
            ListNode last = head;
            while(last.next != null)
                last = last.next;
            
            last.next = newNode;
        }

        return head;
    }

    public ListNode add(int val, int position){
        
        ListNode newNode = new ListNode(val);
        if(position == 0){
            newNode.next = head;
            head = newNode;
        }else{
            ListNode prevNode = head;
            for(int index=0; index<position-1; index++){
                prevNode = prevNode.next;
            }

            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }

        return head;
    }

    public void addFirst(int val){
        
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;

    }

    public ListNode delete(int val){
        
        if(head.val == val){
            head = head.next;
            return head;
        }else{
            ListNode temp = head;
            while(temp.next != null){
                if(temp.next.val == val){
                    temp.next = temp.next.next;
                    return temp;
                }
                temp = temp.next;
            }
            
        }
        
        return null;
    }

    public void printList(){
        
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
    }


}