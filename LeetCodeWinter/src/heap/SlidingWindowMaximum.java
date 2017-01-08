package heap;

import java.util.*;

public class SlidingWindowMaximum {
    /**
     * [1, 2, 7, 7, 5, 3, 8]
     *  k = 3 */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {// [1] 0
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {// [1, 2, 7]
            inQueue(deque, nums[i]);//[2]
        }
        // 第k个放第二部分,可放入result
        for (int i = k - 1; i < nums.length; i++) {//[2, 7]
            // Add next num: poll out from tail
            inQueue(deque, nums[i]);//[7, 7, 5, 3]
            result[i - k + 1] = deque.peekFirst();

            // Sliding window: poll out from head
            if (nums[i - k + 1] == deque.peekFirst()) {// Full
                deque.pollFirst();
            }
        }
        return result;
    }

    private void inQueue(Deque<Integer> deque, int nextNum) {
        while (!deque.isEmpty() && deque.peekLast() < nextNum) {
            deque.pollLast();
        }
        deque.offer(nextNum);
    }

    public int[] maxSlidingWindowI(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (x, y) -> y - x);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() == k) {
                list.add(pq.peek());
                pq.remove(nums[i - k + 1]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 2, 7, 7, 5, 3, 8};
        int k = 3;

        int[] nums1 = {1, -1};
        int k1 = 1;

        int[] nums2 = {7, 2, 4};
        int k2 = 2;
        int[] result = swm.maxSlidingWindowI(nums2, k2);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
