public class LinkedList02 {
    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    public boolean isLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList02 ll = new LinkedList02();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        // ll.head.next.next.next = ll.head;
        if (ll.isLoop()) {
            System.out.println("Is Loop");
        } else {
            System.out.println("Not a Loop");
        }
    }
}
