package linkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode ptr1 = head.next;
            ListNode ptr2 = head.next.next;
            head.next = ptr2;
            ptr1.next = ptr2.next;//not to lost ptr2.next
            ptr2.next = ptr1;

            head = ptr1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SwapNodesInPairs swip = new SwapNodesInPairs();
        ListNode newNode = swip.swapPairs(node1);
        while (newNode != null) {
            System.out.print(newNode.val + ",");
            newNode = newNode.next;
        }
    }
}
