package bfsGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> foundSet = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();//level
        foundSet.add(beginWord);
        queue.offer(beginWord);
        int step = 1;
        while(!queue.isEmpty()) {//1.
        	step++;
        	int size = queue.size();
        	for(int i = 0; i < size; i++) {//2.queue的node个数
        		String word = queue.poll();
        		for(String nextWord : getNextWords(word, wordList)) {//3. neighbors of word
        			if(foundSet.contains(nextWord)) {
        				continue;
        			}
        			if(nextWord.equals(endWord)) {
        				return step;
        			}
        			queue.offer(nextWord);
        			foundSet.add(nextWord);
        		}
        	}
        }
        return 0;
    }
	
	private ArrayList<String> getNextWords(String word, Set<String> wordList) {
		ArrayList<String> result = new ArrayList<String>();
		for(char c = 'a'; c <= 'z'; c++) {
			for(int pos = 0; pos < word.length(); pos++) {
				if(c == word.charAt(pos)) {
					continue;
				}
				String nextWord = replace(word,c,pos);
				if(wordList.contains(nextWord)) {
					result.add(nextWord);
				}
			}
		}
		return result;
	}
	
	private String replace(String word, char c, int pos) {
		char[] str = word.toCharArray();
		str[pos] = c;
		String res = new String(str);
		return res;
	}
	
	 public int ladderLength1(String start, String end, Set<String> dict) {
	        HashSet<String> foundSet = new HashSet<String>();//判断查回来的单词是否已出现过
	        Queue<String> queue = new LinkedList<String>();
	        foundSet.add(start);
	        queue.offer(start);
	        int step = 1;
	        while(!queue.isEmpty()) {//1
	            step++;
	            int size = queue.size();
	            for(int i = 0; i < size; i++) {//2
	               String word = queue.poll();
	               ArrayList<String> nextWords = getNextWords1(word, dict);
	               for(String next : nextWords) {//3
	                   if(foundSet.contains(next)) { 
	                       continue; 
	                   }
	                   if(next.equals(end)) {
	                       return step;
	                   }
	                   queue.offer(next);
	                   foundSet.add(next);
	               }
	            }
	        }
	        return 0;
	    }
	    
	    private ArrayList<String> getNextWords1(String word, Set<String> dict) {
	        ArrayList<String> nextWords = new ArrayList<String>();
	        for(int pos = 0; pos < word.length(); pos++) {
	            for(char c = 'a'; c <= 'z'; c++) {
	                if(c == word.charAt(pos)) { continue; }//与原word相同
	                String next = replace1(word, c, pos);
	                if(dict.contains(next)) {
	                    nextWords.add(next);
	                }
	            }
	        }
	        return nextWords;
	    }
	    
	    private String replace1(String word, char c, int pos) {
	        char[] str = word.toCharArray();
	        str[pos] = c;
	        String res = new String(str);
	        return res;
	    }
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		HashSet<String> wordList = new HashSet<String>();
		wordList.add("hot"); wordList.add("dot"); wordList.add("dog");
		wordList.add("lot"); wordList.add("log"); 
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
		
		ArrayList<String> nextWords = wl.getNextWords1("hot", wordList);
		System.out.println(nextWords);
		String str = wl.replace("hot", 'd', 0);
		System.out.println(str);
	}

}
