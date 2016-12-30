package string;

public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		int len = Math.max(a.length, b.length);
		for(int i = 0; i < len; i++) {
			int bitA = i < a.length? Integer.parseInt(a[i]) : 0;
			int bitB = i < b.length? Integer.parseInt(b[i]) : 0;
			if(bitA > bitB) { return 1; }
			else { return -1; }
		}
		return 0;
	}
	
	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		int res = cvn.compareVersion("1", "0");
		System.out.println(res);
		
		String Str = new String("Welcome-to-Tutorialspoint.com");

	      System.out.println("Return Value :" );
	      for (String retval: Str.split("-", 3)){
	         System.out.println(retval);
	      }
		

	}

}
