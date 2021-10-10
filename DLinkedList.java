class DNode{
    int data;
    DNode next;
    DNode prev;

    DNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLinkedList {
    
    DNode head = null;

    public DNode add(int data){
        
        DNode newDNode = new DNode(data);

        if(head == null){
            head = newDNode;
        }else{
            
            DNode last = head;
            while(last.next != null)
                last = last.next;
            
            last.next = newDNode;
            newDNode.prev = last;
        }
        
        return head;
    }

    public DNode addFirst(int data){
        
        DNode newDNode = new DNode(data);
        newDNode.next = head;
        head.prev = newDNode;
        head = newDNode;

        return head;
    }



    public DNode delete(int data){
       
        if(head.data == data){
            head = head.next;
            head.prev = null;
        }else{
            DNode temp = head;
            while(temp.next != null){
                if(temp.next.data == data){
                    temp.next = temp.next.next;
                    temp.next.next.prev = temp;
                }
                
                temp = temp.next;
            }
        }
        
        return head;
    }
    
    public void printList(){

        DNode last = head;
        while(last != null){
            System.out.print(last.data+"-><-");
            last = last.next;
        }
    }
}
