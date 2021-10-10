class SNode{
    int data;
    SNode next;

    public SNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class SLinkedList{
    
    SNode head = null;

    public SNode add(int data){
        
        SNode newNode = new SNode(data);
        if(head == null){
            head = newNode;
        }else{
            
            SNode last = head;
            while(last.next != null)
                last = last.next;
            
            last.next = newNode;
        }
        return newNode;
    }

    public SNode add(int data, int position){
        
        SNode newNode = new SNode(data);
        if(position == 0){
            newNode.next = head;
            head = newNode;
        }else{
            SNode prevNode = head;
            for(int index=0; index<position-1; index++){
                prevNode = prevNode.next;
            }

            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }

        return head;
    }

    public void addFirst(int data){
        
        SNode newNode = new SNode(data);
        newNode.next = head;
        head = newNode;

    }

    public SNode delete(int data){
        
        if(head.data == data){
            head = head.next;
            return head;
        }else{
            SNode temp = head;
            while(temp.next != null){
                if(temp.next.data == data){
                    temp.next = temp.next.next;
                    return temp;
                }
                temp = temp.next;
            }
            
        }
        
        return null;
    }



    public void printList(){
        
        SNode temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
         
    }
}