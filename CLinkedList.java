class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CLinkedList {

    CNode head = null;

    public CNode add(int data) {
        CNode newNode = new CNode(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CNode last = head;
            while (last.next != head) {
                last = last.next;
            }

            last.next = newNode;
            newNode.next = head;
        }

        return head;

    }

    public CNode add(int data, int position){
        
        CNode newNode = new CNode(data);
        
        if(position == 0){
            CNode last = head;
            while(last.next != head){
               last =  last.next;
            }

            newNode.next = head;
            head = newNode;
            last.next = head;
            
        }else{
            CNode temp = head;
            int index = 0;
            int prevIndex = position-1;
            while(index<prevIndex && temp.next != head){
                temp = temp.next;
                index++;
            }
            
            if(prevIndex <= index +1 ){
                newNode.next = temp.next;
                temp.next = newNode;
            }
            
        }
        
        return head;
    }

    public CNode addFirst(int data) {

        CNode newNode = new CNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {

            CNode last = head;
            do {
                last = last.next;
            } while (last.next != head);

            last.next = newNode;
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public CNode delete(int data) {

        if (head.data == data) {
            if(head.next == head)
                head = null;
            else{
                CNode last = head;    
                while (last.next != head) {
                    last = last.next;
                }
                last.next = head.next;
                head = head.next;
            }
        } else {
            CNode temp = head;
            while (temp.next != head) {
                if (temp.next.data == data) {
                    break;
                }
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }

        return head;
    }

    public void printList() {
        System.out.println("list element: ");
        CNode last = head;
        
        do {
            if(last != null){
                System.out.print(last.data + "->");
                last = last.next;
            }
        } while (last != head);
        
        System.out.println("");
    }
    
}
