package comparator;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	/* The List<Interval> can be divided into 3 parts, 
	   1. intervals.end < newInterval.start,
	      once find the intervals, we add it to result.
	   2. Math.min(newInterval.start, intervals.start), Math.max(newInterval.end, intervals.end)
	      min,max,using insertPos to record the place which newInterval need to be inserted, inserted finally.
	   3. intervals.start > newInterval.end
	      once find the intervals, we add it to result.
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) { 
			result.add(newInterval);
			return result; 
		}
		int insertPos = 0;
		for(Interval interval : intervals) {
			if(interval.end < newInterval.start) {//1
				result.add(interval);
				insertPos++;
			}else if(newInterval.end < interval.start) {//3
				result.add(interval);
			}else {//2
				newInterval.start = Math.min(newInterval.start,interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		result.add(insertPos, newInterval);
		return result;
	}
	
	public static void main(String[] args) {
		List<Interval> list1 = new ArrayList<Interval>();
		Interval iter1 = new Interval(1,2);
		Interval iter2 = new Interval(3,5);
		Interval iter3 = new Interval(6,7);
		Interval iter4 = new Interval(8,10);
		Interval iter5 = new Interval(12,16);
		list1.add(iter1); list1.add(iter2);
		list1.add(iter3); list1.add(iter4);
		list1.add(iter5);
		
		Interval newInterval = new Interval(4,9);
		InsertInterval it = new InsertInterval();
		List<Interval> result = it.insert(list1, newInterval);
		for(Interval iter : result) {
			iter.print();
		}
	}

}
