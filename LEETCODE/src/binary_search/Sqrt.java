package binary_search;

public class Sqrt {
	/* INT */
	public int mySqrt(int x) {
        long left = 0, right = x;//防溢出
		long mid = 0, square = 0;
		while(left <= right) {
			mid = left + (right - left) / 2;
			square = mid * mid;
			if(square == x) {
				return (int)mid;
			}else if(square < x) {
				left = mid + 1;
			}else{
				right = mid - 1; 
			}
		}
		return (int)right;//取小的,交换后right比left小
    }
	/* DOUBLE */
	public double sqrt(double x) {
		   double left = 0.0;
		   double right = x; 
		   while(right - left > 0.001) {
		     double mid = (right + left)/2; 
		     if (mid * mid > x) {
		        right = mid; 
		     } else {
		        left = mid; 
		     }
		   }
		   return left; 
		}
	
	public static void main(String[] args) {
		int sqrt = 9;
		Sqrt sq = new Sqrt();
		System.out.println(sq.sqrt(sqrt));

	}

}
