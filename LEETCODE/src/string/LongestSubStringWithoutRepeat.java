package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {
	
	/*3. LongestSubStringWithoutRepeat */
	public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){  return 0; }
        Map<Character,Integer> map = new HashMap<>();
        int left = -1;
        int res = 1;
        for(int i = 0; i < s.length(); i++){
        	if(map.containsKey(s.charAt(i))){
        		left = Math.max(left, map.get(s.charAt(i)));//更新最左端
        	}
        	map.put(s.charAt(i), i);
        	res = Math.max(res, i - left);//回文，res
        }
        return res;
    }
	
	/*5. longestPalindrome */
	public static String longestPalindrome(String s){
		int start = 0;
		int end = 0;
		String res = s.substring(0,1);
		for(int i = 0; i < s.length(); ++i){
			/*1. 奇数回文 */
			start = i;
			end = i;
			while(start >= 0 && end < s.length()){
				if(s.charAt(start) == s.charAt(end)){
					if(res.length() < end-start+1){//找到更长的子串
						res = s.substring(start,end + 1);//substring不取最后一位
					}
					--start;
					++end;
				}else{
					break;//从下一个index开始两边展开
				}
				
			}
			/*2. 偶数回文 */
			start = i - 1;
			end = i;
			while(start >= 0 && end < s.length()){
				if(s.charAt(start) == s.charAt(end)){
					if(res.length() < end-start+1){
						res = s.substring(start,end + 1);
					}
					++start;
					--end;
				}else{
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		

	}

}
