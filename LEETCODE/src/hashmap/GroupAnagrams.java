package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0) { return result; }
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		Arrays.sort(strs);//使字符串数组按字符串首字母顺序排列
		
		for(int i = 0; i < strs.length; i++) {
			/* 1. 处理字符串成为sorted string key */
			String str = strs[i];//"eat"
			char[] strArr = str.toCharArray();
			Arrays.sort(strArr);//[a,e,t]
			String sortStr = new String(strArr);//"aet"
			
			/* 2. map中更新字符串数组 */
			if(map.containsKey(sortStr)) {
				map.get(sortStr).add(str);//List<string>后加
			}else {
				List<String> temp = new ArrayList<String>();
				temp.add(str);
				map.put(sortStr, temp);
			}
		}
		
		/* 3. value加到result中 */
		for(List<String> anagramList : map.values()) {
			result.add(anagramList);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> result = ga.groupAnagrams(strs);
		System.out.println(result);
	}

	
	public List<List<String>> groupAnagrams1(List<String> strs) {
		HashMap<int[], List<String>> map1 = new HashMap<int[], List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		for(int i = 0; i < strs.size(); i++) {
			String curr = strs.get(i);
			int[] count = countChar(curr);
			if(map1.containsKey(count)) {
				map1.get(count).add(curr);
			}else{
				map1.put(count, new ArrayList<String>());
			}
		}
		for(int[] count : map1.keySet()) {
			result.add(map1.get(count));
		}
		return result;
	} 

	private int[] countChar(String s) {
		int[] count = new int[256];
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		for(int i = 0; i < s.length(); i++) {
			count[(int)(s.charAt(i))]++;
		}
		return count;
	}


}
