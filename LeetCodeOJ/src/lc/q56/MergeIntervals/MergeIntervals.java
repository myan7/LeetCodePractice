package lc.q56.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 56. Merge Intervals
 * Medium
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {

	public static void main(String[] args) {
		Interval inter1 = new Interval(1,3);
		Interval inter2 = new Interval(2,6);
		Interval inter3 = new Interval(8,10);
		Interval inter4 = new Interval(15,18);
		List<Interval> tc1 = new ArrayList<>();
		tc1.add(inter1);
		tc1.add(inter2);
		tc1.add(inter3);
		tc1.add(inter4);
	}

	public static List<Interval> merge(List<Interval> intervals) 
	{
		if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
    }
}
