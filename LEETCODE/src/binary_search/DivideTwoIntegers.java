package binary_search;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		boolean isNeg = false;
		if(dividend > 0&& divisor < 0 || dividend < 0&& divisor > 0) { isNeg = true; }
		long dividendL = Math.abs((long)dividend);
		long divisorL = Math.abs((long)divisor);
		if(dividendL < divisorL) { return 0; }
		
		long start = 1, end = dividendL;
		while(start + 1 < end) {
			long mid = start + (end - start) / 2;
			long product = mid * divisorL;
			if(product == dividendL) {
				return isNeg? overflow(-mid) : overflow(mid);
			}else if(product < dividendL) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(start * divisorL == dividendL) {
			return isNeg? overflow(-start) : overflow(start);
		}else if(end * divisorL == dividendL || end * divisorL < dividendL){//==  <
			return isNeg? overflow(-end) : overflow(end);
		}else {//start * divisorL < dividendL
			return isNeg? overflow(-start) : overflow(start);
		}
	}
	
	private int overflow(long pos) {
		if(pos >= (long)Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int)pos;
	}
	
	public static void main(String[] args) {
		int dividend = -2147483648, divisor = -1;
		DivideTwoIntegers dt = new DivideTwoIntegers();
		int result = dt.divide(dividend, divisor);
		System.out.println(result);
	}

}
