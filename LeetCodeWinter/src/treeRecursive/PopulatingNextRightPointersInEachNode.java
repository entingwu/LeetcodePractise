package treeRecursive;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    /** II */
    //based on level order traversal
    public void connectII(TreeLinkNode root) {
        TreeLinkNode head = null;// head of next level (leftmost)
        TreeLinkNode prev = null;// the leading node on the next level (right)
        TreeLinkNode curr = root;// current node of current level
        while (curr != null) {
            //iterate on the current level
            while (curr != null) {
                //left child
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                //right child
                if (curr.right != null) {
                    if (prev != null) {// 2 -> 3
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                //move to next node
                curr = curr.next;
            }
            //move to next level
            curr = head;
            prev = null;
            head = null;
        }
    }

    /** I */
    public void connectQ(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(true) {
            TreeLinkNode curr = queue.poll();
            if (curr != null) {
                curr.next = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } else {
                if (queue.peek() == null) {
                    return;
                }
                queue.offer(null);
            }
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = (root.next != null ? root.next.left : null);
        }
        connect(root.left);
        connect(root.right);
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode pnrp = new PopulatingNextRightPointersInEachNode();
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        node3.right = node7;
        pnrp.connectQ(node1);
    }
}
