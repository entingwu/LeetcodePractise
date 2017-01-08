package linkedList;

public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, curr = head;
        dummy.next = head;
        int num = 0;
        while (curr != null) {
            num++;
            curr = curr.next;
        }
        while (num >= k) {
            curr = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = curr;
            num -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroups rnk = new ReverseNodesInKGroups();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int k = 3;
        ListNode result = rnk.reverseKGroup(node1, k);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }
}
