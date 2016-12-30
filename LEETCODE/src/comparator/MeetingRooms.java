package comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {
	/** 1. Meeting Room I */
	private Comparator<Interval> intervalComparator = new Comparator<Interval>(){
		public int compare(Interval itv1, Interval itv2) {
			return itv1.start - itv2.start;
			//return Integer.compare(itv1.start, itv2.end);
		}
	};
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, intervalComparator);
		for(int i = 1; i < intervals.length; i++) {
			Interval i1 = intervals[i-1];
			Interval i2 = intervals[i];
			if(i1.end > i2.start) {
				return false;
			}
		}
		return true;
	}
	
	/** 2. Meeting Room II */
	/*	1. Using priorityQueue to store the end times, then we sort the intervals by its start time.
		2. Then iterate the Interval array, 
		   a. if the current start time is less than the earliest end time, minRoom++.
		   b. Else, remove the earliest end time from PriorityQueue
	*/
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) { return 0; }
		// 1. 排序
		Arrays.sort(intervals, comparator);
		
		// 2. minheap
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
		minheap.offer(intervals[0].end);//minheap is empty
		int room = 1;
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < minheap.peek()) {//curr.start < pre.end, overlap
				room++;
				minheap.add(intervals[i].end);
			}else {//curr.start >= pre.end, 间隔连片
				minheap.poll();//poll pre
				minheap.add(intervals[i].end);
			}
		}
		return room;
	}
	
	private Comparator<Interval> comparator = new Comparator<Interval>(){
		public int compare(Interval itv1, Interval itv2) {
			return itv1.start - itv2.start;
		}
	};
	
	
	
	public static void main(String[] args) {
		/** 1. Meeting Room I */
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		MeetingRooms mr = new MeetingRooms();
		System.out.println(mr.canAttendMeetings(intervals));
		
		/** 2. Meeting Room II */
		int room = mr.minMeetingRooms(intervals);
		System.out.println(room);
		
	}

}
