package mergeSortQuickSort;

public class PartitionList {
	
	public int partitionArray(int[] nums, int k) {
		if(nums == null || nums.length == 0) { return 0; }
		int i = 0, j = nums.length - 1;
		while(i<=j) {
			while(i<=j && nums[i] < k) {
				i++;
			}
			while(i<=j && nums[j] >= k) {
				j--;
			}
			if(i<=j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		return j+1;
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head == null) { return head; }
		ListNode leftDummy = new ListNode(0);
		ListNode rightDummy = new ListNode(0);
		ListNode left = leftDummy, right = rightDummy;
		while(head != null) {
			if(head.val < x) {
				left.next = head;
				left = left.next;
			}else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = rightDummy.next;
		return leftDummy.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		PartitionList pl = new PartitionList();
		int x = 3;
		ListNode sort = pl.partition(node1, x);
		while(sort != null) {
			System.out.print(sort.val + " ");
			sort = sort.next;
		}
		System.out.println();
		
		int[] nums = {7,7,9,8,6,6,8,7,9,8,6,6};
		int k = 10;
		System.out.println(pl.partitionArray(nums, k));
	}

}
