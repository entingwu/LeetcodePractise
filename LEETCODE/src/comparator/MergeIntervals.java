package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	private Comparator<Interval> intervalComparator = new Comparator<Interval>() {
		public int compare(Interval itv1, Interval itv2) {
			return itv1.start - itv2.start;
		}
	};
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) { return result; }
		Collections.sort(intervals, intervalComparator);
		
		Interval prev = intervals.get(0);//0
		for(int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			/* 1. 区间合并，保留prev，并查看下一区间是否需要合并 */
			if(prev.end >= curr.start) {
				prev.end = Math.max(curr.end, prev.end);
			}else {/* 2. 区间放入结果集，prev变为curr */
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);//加入最后一个
		return result;
	}
	
	public static void main(String[] args) {
		Interval itv1 = new Interval(1,4);
		Interval itv2 = new Interval(2,3);
		Interval itv3 = new Interval(8,10);
		Interval itv4 = new Interval(15,18);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(itv1);
		intervals.add(itv2);
		intervals.add(itv3);
		intervals.add(itv4);
		
		MergeIntervals mi = new MergeIntervals();
		List<Interval> result = mi.merge(intervals);
		for(Interval itv : result) {
			itv.print();
			System.out.print(" ");
		}
		
	}

}
