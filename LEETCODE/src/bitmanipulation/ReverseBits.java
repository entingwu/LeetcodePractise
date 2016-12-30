package bitmanipulation;

public class ReverseBits {
	
	/* nth bit is 1? */
	boolean isOne(int num, int n) {
		num= num >> (n -1); 
		return (num & 1) == 1;
	}
	
	public static void main(String[] args) {
		

	}

}
