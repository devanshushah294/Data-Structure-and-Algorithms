public class DoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void printLL() {
        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }
        System.out.print("ForwardLL = ");
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("null");
        System.out.print("ReverseLL = ");
        currNode = tail;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.prev;
        }
        System.out.println("null");
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (head == tail) {
            head = newNode;
            head.next = tail;
            tail.prev = head;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("No node to remove");
            return Integer.MIN_VALUE;
        }
        if (head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (head == tail) {
            tail = newNode;
            head.next = tail;
            tail.prev = head;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("No node to remove");
            return Integer.MIN_VALUE;
        }
        if (head == tail) {
            int val = tail.data;
            head = tail = null;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return val;

    }

    public void reverseDLL() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            return;
        }
        Node currNode = head;
        Node prev = null;
        Node next;
        tail = head;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            currNode.prev = next;
            prev = currNode;
            currNode = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(6);
        dll.addFirst(7);
        dll.addFirst(8);
        dll.addLast(4);
        // dll.removeLast();
        // dll.printLL();
        // dll.removeLast();
        // dll.printLL();
        // dll.removeLast();
        // dll.printLL();
        // dll.removeLast();
        // dll.printLL();
        // dll.removeLast();
        dll.printLL();
        dll.reverseDLL();
        dll.printLL();
        // dll.removeFirst();
    }
}
