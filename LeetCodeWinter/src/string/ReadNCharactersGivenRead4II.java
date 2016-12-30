package string;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenRead4II {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    /** ReadNCharactersGivenRead4II
     *  buf = "a", [read[0], read[1], read[2]], return ["", "a", ""] */
    private Queue<Character> queue = new LinkedList<>();
    public int read(char[] buf, int n) {
        int count = 0;
        char[] tempBuffer = new char[4];
        while(true) {
            int readNum = read4(tempBuffer);//read[1], read4 move forward. Since "a" is already in queue, read4(tempBuffer) returns 0
            for (int i = 0; i < readNum; i++) {
                queue.offer(tempBuffer[i]);
            }
            readNum = Math.min(n - count, queue.size());//read[1], readNum = 0, queue.size() = 1
            for (int i = 0; i < readNum; i++) {
                buf[count + i] = queue.poll();
            }
            count += readNum;
            if (readNum < 4) {
                break;
            }
        }
        return count;
    }

    // ReadNCharactersGivenRead4I
    public int readI(char[] buf, int n) {
        int count = 0;
        char[] tempBuffer = new char[4];
        while (true) {
            int readNum = read4(tempBuffer);
            readNum = Math.min(n - count, readNum);
            for (int i = 0; i < readNum; i++) {
                buf[count + i] = tempBuffer[i];
            }
            count += readNum;
            if (readNum < 4) {
                break;
            }
        }
        return count;
    }

    private int read4(char[] buffer) {
        return 4;
    }

}