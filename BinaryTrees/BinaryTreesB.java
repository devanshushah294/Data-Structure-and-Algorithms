// import BinaryTreesB.Node.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            // Time Complexity O(n)
            Node temp = root;
            if (root == null) {
                // System.out.print("-1" + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static int getHeight(Node root) {
            if (root == null) {
                return 0;
            }
            int h1 = getHeight(root.left);
            int h2 = getHeight(root.right);
            if (h1 > h2) {
                return h1 + 1;
            } else {
                return h2 + 1;
            }
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                if (currNode == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }

                }
            }
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int lCount = countNodes(root.left);
            int rCount = countNodes(root.right);
            return lCount + rCount + 1;
        }

        public static int getSumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = getSumOfNodes(root.left);
            int rightSum = getSumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        // public int getMaxDiameter(Node root) {
        // // TC = O(n^2)
        // if (root == null) {
        // return 0;
        // }
        // int d1 = getHeight(root.left) + getHeight(root.right) + 1;
        // int d2 = getMaxDiameter(root.left);
        // int d3 = getMaxDiameter(root.right);
        // return Math.max(Math.max(d1, d2), d3);
        // }
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public Info getMaxDiameterHelper(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = getMaxDiameterHelper(root.left);
            Info rightInfo = getMaxDiameterHelper(root.right);
            return new Info(Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1),
                    Math.max(leftInfo.ht, rightInfo.ht) + 1);
        }

        public int getMaxDiameter(Node root) {
            if (root == null) {
                return 0;
            }
            Info ans = getMaxDiameterHelper(root);
            return ans.diam;
        }

        public boolean checkIdentical(Node treeNode, Node subNode) {
            if (treeNode == null && subNode == null) {
                return true;
            }
            if (treeNode == null || subNode == null) {
                return false;
            }
            return treeNode.data == subNode.data && checkIdentical(treeNode.left, subNode.left)
                    && checkIdentical(treeNode.right, subNode.right);

        }

        public boolean isSubtree(Node treeNode, Node subNode) {
            if (treeNode == null && subNode == null) {
                return true;
            }
            if (treeNode == null || subNode == null) {
                return false;
            }
            if (checkIdentical(treeNode, subNode)) {
                return true;
            }
            return isSubtree(treeNode.left, subNode) || isSubtree(treeNode.right, subNode);
        }

        static class NewInfo {
            Node node;
            int horizontalDistance;

            public NewInfo(Node node, int hd) {
                this.node = node;
                this.horizontalDistance = hd;
            }
        }

        public static void topView(Node root) {
            Queue<NewInfo> q = new LinkedList<NewInfo>();
            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0;
            int max = 0;

            // Add Root in Queue
            q.add(new NewInfo(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                NewInfo curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    if (!map.containsKey(curr.horizontalDistance)) {
                        map.put(curr.horizontalDistance, curr.node);
                    }
                    if (curr.node.left != null) {
                        q.add(new NewInfo(curr.node.left, curr.horizontalDistance - 1));
                        min = Math.min(min, curr.horizontalDistance - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new NewInfo(curr.node.right, curr.horizontalDistance + 1));
                        max = Math.max(max, curr.horizontalDistance + 1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.println(map.get(i).data + " ");
            }

        }
    }

    public static void main(String[] args) {
        HashMap<Character,Boolean> map = new HashMap<>()
        // int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree b = new BinaryTree();
        // Node root = b.buildTree(nodes);
        // System.out.println(root.data);
        // b.preOrder(root);
        // System.out.println("");
        // b.inOrder(root);
        // System.out.println("");
        // b.postOrder(root);
        // System.out.println();
        // b.levelOrder(root);
        // System.out.println(b.getHeight(root));
        // System.out.println("Count = " + b.countNodes(root));
        // System.out.println("Sum = " + b.getSumOfNodes(root));
        // System.out.println(b.getMaxDiameter(root));

        BinaryTree b = new BinaryTree();
        Node treeRoot = new Node(1);
        treeRoot.left = new Node(2);
        treeRoot.left.left = new Node(4);
        treeRoot.left.right = new Node(5);
        treeRoot.right = new Node(3);
        treeRoot.right.right = new Node(6);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.left.right = new Node(7);
        subRoot.right = new Node(5);
        if (b.isSubtree(treeRoot, subRoot)) {
            System.out.println("Yess");
        } else {
            System.out.println("Noo");
        }
        b.topView(treeRoot);
    }
}