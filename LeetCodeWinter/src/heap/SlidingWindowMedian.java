package heap;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new double[0];
        }
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> minheap = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((x, y) -> y - x);
        int median = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                if (nums[i] > median) {
                    minheap.offer(nums[i]);
                } else {
                    maxheap.offer(nums[i]);
                }
            }

            if (i >= k) {
                if (nums[i - k] == median) {
                    if (maxheap.size() > minheap.size()) {// left
                        median = maxheap.poll();
                    } else {// right
                        median = minheap.poll();
                    }
                } else if (nums[i - k] < median) {// left, maxheap
                    maxheap.remove(nums[i - k]);
                } else {// right, minheap
                    minheap.remove(nums[i - k]);
                }
            }
            while (minheap.size() < maxheap.size()) {
                minheap.offer(median);
                median = maxheap.poll();
            }
            while (maxheap.size() < minheap.size()) {
                maxheap.offer(median);
                median = minheap.poll();
            }

            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = median;
                } else {
                    if (maxheap.size() > minheap.size()) {
                        result[i - k + 1] = median + (maxheap.peek() - median) / 2.0;
                    } else {
                        result[i - k + 1] = median + (minheap.peek() - median) / 2.0;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] nums1 = {1, 4, 2, 3};
        int k1 = 4;
        int[] nums2 = {7, 0, 3, 9, 9, 9, 1, 7, 2, 3};
        int k2 = 6;
        int[] nums3 = {2147483647, 2147483647};
        int k3 = 2;
        int[] nums4 = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k4 = 3;
        double[] result = swm.medianSlidingWindow(nums4, k4);
        for (double i : result) {
            System.out.print(i + ",");
        }
    }
}
