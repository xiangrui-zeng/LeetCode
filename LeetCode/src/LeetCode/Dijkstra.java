package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class Dijkstra {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] p = line.split(" ");
        int y = Integer.parseInt(p[0]);
        int x = Integer.parseInt(p[1]);
        
        
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        List<List<Integer>>  a = new ArrayList<List<Integer>>();
        for (int i = 0; i < x; i++){
        	ArrayList<Integer> b = new ArrayList<Integer>();
        	String row = sc.nextLine();
        	String [] r = row.split(" ");
        	for (int j = 0; j < y; j++){
        		if (r[j].equals("s")) {
        			b.add(-1);
        			startX = i;
        			startY = j;
        		} else if (r[j].equals("g")) {
        			b.add(0);
        			endX = i;
        			endY = j;
        		} else {
        			b.add(Integer.parseInt(r[j]));
        		}
        	}
        	a.add(b);
        }
        
        List<List<Integer>> result = getShortestDistance(a, startX, startY);
        int dis = result.get(endX).get(endY);
        System.out.println(dis == Integer.MAX_VALUE - 1 ? "Fail" : dis);
    }
    
    public static List<List<Integer>> getShortestDistance(List<List<Integer>> arr, int x, int y){
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<String, Integer> caled = new HashMap<String, Integer>();
    	for (int i = 0; i < arr.size(); i ++) {
    		List<Integer> poi = new ArrayList<Integer>();
    		for (int j = 0; j < arr.get(i).size() ; j ++) {
    			if (i == x && j == y) {
    				poi.add(0);
    				caled.put(x + "," + y, 0);
    			} else if(i == x && ( j == y - 1 || j == y + 1)) {
    				if (arr.get(i).get(j) == 0) {
    					poi.add(1);
    					caled.put(i + "," + j, 1);
    				} else {
    					poi.add(Integer.MAX_VALUE - 1);
    					caled.put(i + "," + j, Integer.MAX_VALUE - 1);
    				}
    			} else if(j == y && ( i == x - 1 || i == x + 1)) {
    				if (arr.get(i).get(j) == 0) {
    					poi.add(1);
    					caled.put(i + "," + j, 1);
    				} else {
    					poi.add(Integer.MAX_VALUE - 1);
    					caled.put(i + "," + j, Integer.MAX_VALUE - 1);
    				}
    			} else {
    				poi.add(Integer.MAX_VALUE - 1);
    			}
    		}
    		result.add(poi);
    		
    	}
    	
    	boolean finished = false;
    	for(int i = 0; i < result.size() * result.get(0).size() && !finished; i++) {
    		Map<String, Integer> tmp = new TreeMap<String, Integer>();
        	for(Entry<String, Integer> entry : caled.entrySet()) {
        		String[] caledP = entry.getKey().toString().split(",");
        		int x1 = Integer.parseInt(caledP[0]);
        		int y1 = Integer.parseInt(caledP[1]);
        			
        		if (!caled.containsKey((x1 + 1) + "," + y1) &&  
        				x1 + 1 < result.size() && arr.get(x1 + 1).get(y1) == 0 &&
        				result.get(x1 + 1).get(y1) > (Integer)entry.getValue() + 1) {
        			result.get(x1 + 1).set(y1, (Integer)entry.getValue() + 1);
        			tmp.put(x1 + 1 + "," + y1, (Integer)entry.getValue() + 1);
        		}
        		if (!caled.containsKey((x1 - 1) + "," + y1) &&  
        				x1 - 1 >= 0 && arr.get(x1 - 1).get(y1) == 0 &&
        				result.get(x1 - 1).get(y1) > (Integer)entry.getValue() + 1) {
        			result.get(x1 - 1).set(y1, (Integer)entry.getValue() + 1);
        			tmp.put(x1 - 1 + "," + y1, (Integer)entry.getValue() + 1);
        		}
        		if (!caled.containsKey(x1 + "," + (y1 + 1)) &&  
        				y1 + 1 < result.get(0).size() && arr.get(x1).get(y1 + 1) == 0 &&
        				result.get(x1).get(y1 + 1) > (Integer)entry.getValue() + 1) {
        			result.get(x1).set(y1 + 1, (Integer)entry.getValue() + 1);
        			tmp.put(x1 + "," + (y1 + 1), (Integer)entry.getValue() + 1);
        		}
        		if (!caled.containsKey(x1 + "," + (y1 - 1)) &&  
        				y1 - 1 >= 0 && arr.get(x1).get(y1 - 1) == 0 &&
        				result.get(x1).get(y1 - 1) > (Integer)entry.getValue() + 1) {
        			result.get(x1).set(y1 - 1, (Integer)entry.getValue() + 1);
        			tmp.put(x1 + "," + (y1 - 1), (Integer)entry.getValue() + 1);
        		}
        	}
        	if (tmp.isEmpty()) {
        		finished = true;
        		break;
        	}
        	SortedSet<Map.Entry<String,Integer>> sortedTmp = entriesSortedByValues(tmp);
        	@SuppressWarnings("rawtypes")
			Iterator iter = sortedTmp.iterator();
        	Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
        	if(entry.getValue() < Integer.MAX_VALUE) {
        		caled.put((String)entry.getKey(), (Integer)entry.getValue());
        	}else {
        		finished = true;
        	}
    	}
    	
    	return result;
    }
    
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    
}
