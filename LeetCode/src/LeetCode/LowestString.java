package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class LowestString {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {0,0};
//		lowestString();
//		System.out.println(largestNumber(nums));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] ori = sc.nextLine().split(" ");
        List<Integer> o = new ArrayList<>();
        for (String n : ori) {
        	o.add(Integer.parseInt(n));
        }
        List<List<Integer>> wraper = new ArrayList<>();
        wraper.add(o);
        
        List<List<Integer>> matchList = new ArrayList<>();
        int matchNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < matchNum; i ++) {
        	String[] tmp = sc.nextLine().split(" ");
            List<Integer> t = new ArrayList<>();
            for (String n : tmp) {
            	t.add(Integer.parseInt(n));
            }
            matchList.add(t);
        }
        
        List<Integer> r = getLargestList(getAllPath(wraper,matchList));
        for (int i = 0;i < r.size(); i++) {
        	if (i == 0) {
        		System.out.print(r.get(i));
        	} else {
        		System.out.print(" " + r.get(i));
        	}
        }
        System.out.println();
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static List<List<Integer>> getAllPath(List<List<Integer>> l1, List<List<Integer>> l2) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> dup = new ArrayList<>();
		
		result.addAll(l1);
		dup.add(-1);
		int l2Len1 = l2.size();
		int l2Len2 = l2.size();
		int loopNum = 1;
		int loNum = 1;
		while (l2Len1 > 0) {
			loNum *= l2Len1;
			l2Len1 --;
		}
		int tmpNum = 1;
		for (int i = 1; i<= l2Len2; i++) {
			tmpNum *= i;
			loopNum += loNum / tmpNum;
		}
		
		for (int j = 0; j < loopNum; j ++) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < l2.size(); i++) {
				if (dup.get(j) != i) {
					tmp = replaceList(l1.get(j), l2.get(i));
					dup.add(i);
					l1.add(tmp);
					result.add(tmp);
				} else {
					loopNum--;
				}
			}
		}
		return result;
        
    }
	
	
	public static List<Integer> replaceList(List<Integer> l1, List<Integer> l2) {

//		List<List<Integer>> result = new ArrayList<>();
//		for (List<Integer> l1 : ln) {
			List<Integer> r = new ArrayList<>();
			for (int i = 0; i< l2.size(); i++) {
				int idx = l2.indexOf(i + 1) ;
				r.add(l1.get(idx));
			}
//			for (int l : l2) {
//				r.add(l1.get(l));
//			}
//			result.add(r);
//		}
		return r;       
    }
	
	public static List<Integer> getLargestList(List<List<Integer>> l) {
		Collections.sort(l, new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i).compareTo(o2.get(i)) == -1) {
						return -1;
					}
					if (o1.get(i).compareTo(o2.get(i)) == 1) {
						return 1;
					}
				}
				return 0;
			}
			
		});
		return l.get(0);
	}
	
}



