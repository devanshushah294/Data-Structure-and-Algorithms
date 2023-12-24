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

    public boolean isCycle() {
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

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            slow = head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            prev.next = null;
            printLL();
        }
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void makeZigZag() {
        Node mid = getMid(head);
        Node currNode = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        // Now prev is out new Head
        Node lHead = head;
        Node rHead = prev;
        Node nextLeft, nextRigth;
        Node temp;
        while (rHead != null && lHead != null) {

            // temp = lHead.next;
            // lHead.next = rHead;
            // rHead = rHead.next;
            // lHead.next.next = temp;
            // lHead = lHead.next.next;

            nextLeft = lHead.next;
            nextRigth = rHead.next;
            lHead.next = rHead;
            rHead.next = nextLeft;

            lHead = nextLeft;
            rHead = nextRigth;
        }
        printLL();
    }

    public Node mergeSort(Node head) {
        // find mid
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
        // Time complexity -> O(nlogn)
    }

    public static void main(String[] args) {

        // Execution code for removeCycle()
        // LinkedList02 ll = new LinkedList02();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.head.next.next = new Node(3);
        // ll.head.next.next.next = new Node(4);
        // ll.head.next.next.next.next = new Node(5);
        // ll.head.next.next.next.next.next = new Node(6);
        // ll.head.next.next.next.next.next.next = new Node(7);
        // ll.head.next.next.next.next.next.next.next = new Node(8);
        // ll.head.next.next.next.next.next.next.next.next = ll.head.next.next.next;
        // ll.isCycle();
        // ll.removeCycle();
        // ll.isCycle();

        // execution code for isCycle()
        // if (ll.isCycle()) {
        // System.out.println("Is Cycle");
        // } else {
        // System.out.println("Not a Cycle");
        // }

        // Execution of MergeSort
        LinkedList02 ll = new LinkedList02();
        ll.head = new Node(1);
        ll.head.next = new Node(5);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(6);
        ll.head.next.next.next.next = new Node(3);
        ll.head.next.next.next.next.next = new Node(100);
        ll.head.next.next.next.next.next.next = new Node(4);
        // ll.head.next.next.next.next.next.next.next = new Node(65);
        ll.printLL();
        ll.mergeSort(ll.head);
        ll.printLL();
        ll.makeZigZag();
    }
}
