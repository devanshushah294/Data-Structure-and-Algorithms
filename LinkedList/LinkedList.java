public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1 : Create new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 : New node's next = head
        newNode.next = head;
        // step3 : head = newNode
        head = newNode;

        // Time Complexity -> O(1) -> constant
    }

    public void addLast(int data) {
        // step1 : Create new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2: tail's next = head
        tail.next = newNode;
        // step3: tail = newNode
        tail = newNode;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("null");
        // Time Complexity -> O(n)
    }

    public void add(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node currNode = head;
        size++;
        for (int i = 0; i < index - 1; i++) {
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            return removeFirst();
        }
        if (size == 1) {
            return removeFirst();
        }
        Node currNode = head;
        for (int i = 0; i < size - 2; i++) {
            currNode = currNode.next;
        }
        int val = tail.data;
        currNode.next = null;
        tail = currNode;
        size--;
        return val;

    }

    public int iterSearch(int key) {
        // Time complexity -> O(n)
        if (head == null) {
            System.err.println("LL is empty");
            return -1;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }
            i++;
            temp = temp.next;
        }
        // key not found
        return -1;
    }

    public int recHelper(int key, Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = recHelper(key, head.next);
        if (index == -1) {
            return -1;
        }
        return index + 1;
    }

    public int recSearch(int key) {
        return recHelper(key, head);
    }

    public void reverse() {
        Node curr = tail = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        printLL();
    }

    public void deleteNthNodeFromEnd(int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next;
            return;
        }
        Node prev = head;
        for (int i = 1; i < size - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        tail = prev;
    }

    public Node getMid() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node prev = null;
        Node curr = getMid();
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;
        while (rightHead != null) {
            if (rightHead.data != leftHead.data) {
                System.out.println("Not Palindrome");
                return false;
            }
            rightHead = rightHead.next;
            leftHead = leftHead.next;
        }
        System.out.println("Palindrome");
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2, 3);
        // ll.printLL();
        // int index = ll.recSearch(1);
        // System.out.println(index);
        // ll.reverse();
        // ll.deleteNthNodeFromEnd(1);
        // ll.deleteNthNodeFromEnd(1);
        // ll.deleteNthNodeFromEnd(1);
        // ll.deleteNthNodeFromEnd(1);
        // ll.deleteNthNodeFromEnd(1);
        // System.out.println(tail.data);
        ll.printLL();
        ll.isPalindrome();
        ll.printLL();
    }
}