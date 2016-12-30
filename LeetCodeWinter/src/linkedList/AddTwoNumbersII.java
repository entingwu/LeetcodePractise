package linkedList;

import java.util.Stack;

/* http://www.cnblogs.com/grandyang/p/6216480.html */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = new ListNode(0);
        int num1 = 0, num2 = 0;
        int sum = 0, carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            num1 = !stack1.isEmpty()? stack1.pop() : 0;
            num2 = !stack2.isEmpty()? stack2.pop() : 0;
            sum = num1 + num2;
            carry = (result.val + sum) / 10;
            result.val = (result.val + sum) % 10;
            ListNode head = new ListNode(carry);
            head.next = result;
            result = head;
        }
        return result.val == 0? result.next : result;
    }

    public static void main(String[] args) {
        // test1
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);
        l5.next = l6;
        l6.next = l7;
        // test2
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        l9.next = l10;

        AddTwoNumbersII atn = new AddTwoNumbersII();
        ListNode node = atn.addTwoNumbers(l1, l5);
        ListNode node1 = atn.addTwoNumbers(l8, l9);
        atn.printList(node);
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }
}
