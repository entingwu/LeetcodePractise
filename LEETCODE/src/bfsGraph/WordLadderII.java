package bfsGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        //<word, nextWordList>
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//<word, the distance from beginWord to word>
        Map<String, Integer> distance = new HashMap<String, Integer>();
        /* bfs */
        wordList.add(beginWord);
        wordList.add(endWord);
		bfs(map, distance, beginWord, endWord, wordList);
		/* DFS */
		List<String> path = new ArrayList<String>();
		dfs(ladders, path, endWord, beginWord, map, distance);
		
		return ladders;
    }
	
	/** DFS:倒过来找，越来越近 */
	private void dfs(List<List<String>> ladders, List<String> path, String curr, String start, 
			Map<String, List<String>> map, Map<String, Integer> distance) {
		path.add(0, curr);//前插，add endWord
		if(curr.equals(start)) {
			ladders.add(new ArrayList<String>(path));
		}
		List<String> nextList = map.get(curr);
		for(String next : nextList) {
			if((distance.get(curr) == distance.get(next) + 1) && distance.containsKey(next)) {
				dfs(ladders, path, next, start, map, distance);
				path.remove(0);//往前删
			}
		}
	}
	
	/** bfs
	 * map : 算出字典里每一个词的相邻一位单词序列 
	 * distance : 算出所有单词距离start的距离 */
	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, 
			String start, String end, Set<String> wordList) {
		
		Queue<String> queue = new LinkedList<String>();
		//1.initialize
		queue.offer(start);
		distance.put(start, 0);
		for(String s : wordList) { 
			map.put(s, new ArrayList<String>()); //字典里的每一个词都有一个nextWordList序列,不考虑先后出现顺序
		}
		
		while(!queue.isEmpty()) {
			String currWord = queue.poll();
			for(String word : getNextWords(currWord, wordList)) {//word的相邻一位的单词序列
				map.get(currWord).add(word);//1. map, currWord只traverse一次，无需判断重复加入其list
				
				if(!distance.containsKey(word)) {//2. distance, 已加入的节点已算过距离，不能刷新距离
					Integer nextDistance = distance.get(currWord) + 1;
					distance.put(word, nextDistance);
					queue.offer(word);//3.queue
				}
			}
		}
		
	}
	
	private List<String> getNextWords(String word, Set<String> wordList) {
		List<String> nextList = new ArrayList<String>();
		for(int pos = 0; pos < word.length(); pos++) {
			for(char ch = 'a'; ch <= 'z'; ch++) {
				if(ch != word.charAt(pos)) {
					//replace word.charAt(pos) with ch
					String nextWord = word.substring(0, pos) + ch + word.substring(pos + 1);
					if(wordList.contains(nextWord)) {
						nextList.add(nextWord);
					}
				}
			}
		}
		return nextList;
	}
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot"); wordList.add("dot"); wordList.add("dog"); wordList.add("lot"); wordList.add("log"); 
		WordLadderII wl = new WordLadderII();
		List<List<String>> ladders = wl.findLadders(beginWord, endWord, wordList);
		System.out.println(ladders);
		

	}

}
