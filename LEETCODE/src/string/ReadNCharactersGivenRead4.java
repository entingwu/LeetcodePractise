package string;

public class ReadNCharactersGivenRead4 {

	
	/*API : The return value is the actual number of characters read. */
	int read4(char[] buf) { return 0; }
	
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	/*  This seemingly easy coding question has some tricky edge cases.
		1. When read4 returns less than 4, we know it must reached the end of file. 
		   However, take note that read4 returning 4 could mean the last 4 bytes of the file.
	 * */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] buffer = new char[4];
        boolean canRead = true;
        while(total < n && canRead) {
        	int readByte = read4(buffer);//returns actual number of characters read
        	if(readByte < 4) {
        		canRead = false;
        	}
        	/*2. To make sure that the buffer is not copied more than n bytes, 
		         copy the remaining bytes (n – readBytes) or the number of bytes read, whichever is smaller.*/
        	int realRead = Math.min(n - total, readByte);
        	//把read4读下来的buffer数组内容存到buf数组
        	for(int i = 0; i < realRead; i++) {
        		buf[total + i] = buffer[i];
        	}
        	total += realRead;
        }
        return total;
    }
	
	public static void main(String[] args) {
		

	}

}
