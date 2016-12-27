package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(3,4);
		intervals[1] = new Interval(2,3);
		intervals[2] = new Interval(1,2);
		System.out.println(findRightInterval(intervals));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Interval[] sortedIntervals = intervals;
        Arrays.sort(sortedIntervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
        	
        });
        Arrays.fill(result, -1);
        for (int i = 0; i < intervals.length - 1; i++) {
        	for (int j = sortedIntervals.length - 1; j > i; j--) {
        		if (intervals[i].start <= intervals[j].end) {
        			result[i] = j;
        		} else {
        			break;
        		}
        	}
        }
        return result;
    }
	   
}

class Interval {
	 int start;
	 int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */



