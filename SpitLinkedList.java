public class SpitLinkedList {


    // Node
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }

    // Function to split the given linked list
// into ratio of p and q
    static void splitAndPrint(Node head,int p,int q)
    {
        int n = 0;
        Node temp;
        temp = head;

        // Find the length of the list
        while(temp!=null)
        {
            n += 1;
            temp = temp.next;
        }

        // If ration exceeds the actual length
        if (p + q > n)
        {
            System.out.println("-1");
            return;
        }
        temp = head;
        while(p > 1)
        {
            temp = temp.next;
            p-= 1;
        }

        // second head node after splitting
        Node head2 = temp.next;
        temp.next = null;

        // Print first linked list
        printList(head);
        System.out.println();

        // Print second linked list
        printList(head2);
    }

    // Function to print the nodes
// of the linked list
    static void printList(Node head)
    {
        if( head == null)
            return;
        System.out.print(head.data+" , ");
        printList(head.next);
    }

    // Driver code
    public static void main(String args[])
    {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(2);

        int p =2,q= 4;
        splitAndPrint(head, p, q);
    }
}
