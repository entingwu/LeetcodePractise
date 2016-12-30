package bitmanipulation;

public class NumberOf1Bits {
	
	public int hammingWeight(int n) {
		int count = 0;
        int flag = 1;
        while(flag != 0) {
            if((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 1 Can you give me the solution for this question: 

			// Count the bit 1 for an integer

			// 5 00000101 = 2

			// 1 0000001 = 1
			// negative 

			// 1000000000000 11 = 3 

			// Integer 32 bits
			// ^ | & ? 

			// 0^1 = 1, 0^0=0 

			//  >> <<  & 1  // 000101 & 1  = 1 >> 00010 & 1 = 0 .
			// >> | << 

			// >> operator?
			/*int calcuateOneBit(int n) {
			   int count = 0;
			   for(int i = 0; i < 8; ++i) { 
			       count += ((n>>i) & 1);
			   }
			   return count;
			}
			 
			int calcuateOneBit(int n) {

			int count = 0;
			int flag = 1;
			while(flag != 0) { 
			  if(n & flag != 0){
			     ++count;
			  }
			  flag = flag << 1; 
			}
			  return count;
			}

			costs 32 operations? 

			Can you do it in 4 operations? 

			32 bits = 4 bytes 

			00000000 10000100 011110111 00000001001

			[] key is the byte value is how many 1's in the byte

			000000001 => 1 
			000000010 => 1

			count[]
			256 values. 

			2^8 ? 
			int [] count; 
			for (int i = 0 ;i < 256 ; ++i) { 
			    count[i] = calcuateOneBit(i); 
			}


			int countOnes(int n) {
			   return count[n] + count[n>>8] + count[n>>16] + count[n>>24]; 
			}*/ 
}
