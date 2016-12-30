package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
	
	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	public WordDistance(String[] words) {
		for(int i = 0; i < words.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
        	if(map.containsKey(words[i])) {
        		list = map.get(words[i]);
        	}
        	list.add(i);
        	map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int diff = Integer.MAX_VALUE;
        for(int a : list1) {
        	for(int b : list2) {
        		diff = Math.min(Math.abs(b-a), diff);
        	}
        }
        return diff;
    }
	
	public static void main(String[] args) {
		String[] words = new String[5];
		words[0] = "practice"; words[1] = "makes"; words[2] = "perfect";
		words[3] = "coding"; words[4] = "makes";
		
		// Your WordDistance object will be instantiated and called as such:
		WordDistance wordDistance = new WordDistance(words);
		int diff = wordDistance.shortest(words[1], words[3]);
		System.out.println(diff);

	}

}
