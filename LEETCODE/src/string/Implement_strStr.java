package string;

public class Implement_strStr {
	public static int strStr(String haystack, String needle) {
        char h,n;
        int i,j;
        boolean found;
        if(haystack.equals("") && needle.equals("")){ return 0;}
		for(i=0;i<=haystack.length()-needle.length();i++){
        	found = true;
        	for(j=0;j<needle.length();j++){
           		n = needle.charAt(j);
           		h = haystack.charAt(i+j);
           		if(h!=n){ 
           			found = false;
           			break; 
           		}
           	}
       		if(found){return i;}
        }
		return -1;
    }
	
	public static void main(String[] args) {
		String haystack = "enting";
		String needle = "ti";
		int index = strStr(haystack,needle);
		System.out.println(index);
	}

}
