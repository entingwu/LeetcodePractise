package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*题意：给定一个数组和两个单词word1,word2,返回两者最近的距离.word1不等于word2,但是两者可能在数组中出现多次*/
public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null) { return -1; }
		int index1 = -1, index2 = -1;
		int diff = words.length;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				index1 = i;
			}else if(words[i].equals(word2)) {
				index2 = i;
			}
			if(index1!=-1 && index2!=-1) {
				diff = Math.min(Math.abs(index1-index2), diff);
			}
		}
		return diff;
	}

	public int shortestDistance1(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        /* 1. word1 index and word2 index */
        for(int i = 0; i < words.length; i++) {
        	List<Integer> list = new ArrayList<Integer>();;
        	if(map.containsKey(words[i])) {
        		list = map.get(words[i]);
        	}
        	list.add(i);
        	map.put(words[i], list);
        }
        
        /* 2. shortest distance*/
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int a : l1) {
        	for(int b : l2) {
        		min = Math.min(min, Math.abs(b-a));
        	}
        }

		return min;
    }
	
	public static void main(String[] args) {
		String[] words = new String[5];
		words[0] = "practice"; words[1] = "makes"; words[2] = "perfect";
		words[3] = "coding"; words[4] = "makes";
		
		ShortestWordDistance swd = new ShortestWordDistance();
		int distance = swd.shortestDistance1(words, words[1], words[3]);
		System.out.println(distance);
	}

	
	
	/* 1. SLOW VERSION*/
	public int shortestDistance2(String[] words, String word1, String word2) {
		if(words == null || words.length == 0) { return 0; }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++) {
        	if(words[i].equals(word1)) {
        		map.put(word1, i);
        	}
        	for(int j = 0; j < words.length; j++) {
        		if(words[j].equals(word2)) {
        			if(!map.containsKey(word2)) {
        				map.put(word2, j);
        			}else {
        				if(map.containsKey(word1) && map.get(word1)-map.get(word2)<Math.abs(j-i)){
        					map.put(word2, j);
        				}
        			}
            	}
        	}
        }
		int distance = Math.abs(map.get(word1)-map.get(word2));
		return distance;
    }
	
}
