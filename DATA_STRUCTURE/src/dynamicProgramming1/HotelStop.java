package dynamicProgramming1;

import java.util.ArrayList;
import java.util.List;

public class HotelStop {

	public static List<Character> hotelStop(int[] hotels) {
		/*1.state*/
		int n = hotels.length;
		int[] f = new int[n];//penalty
		int[] preHotel = new int[n];//record the previous hotel
		List<Character> hotelStop = new ArrayList<Character>();
		
		/*2.initialize*/
		f[0] = 0;
		preHotel[0] = 0;
		for (int i = 1 ; i < n; ++i) {
			f[i] = Integer.MAX_VALUE;
			preHotel[i] = 0;
		}
		
		/*3.function*/
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				int penalty = (int)Math.pow(200 - (hotels[i] - hotels[j]), 2);
				if(f[j] + penalty < f[i]) {
					f[i] = f[j] + penalty;
					preHotel[i] = j;
				}
			}
		}
		
		/*4.hotelStop*/
		int i = n-1;
		hotelStop.add(0, (char)(i+'A'));//destination
		int currHotel = n-1;
		while(i > 0) {
			currHotel = preHotel[i];
			hotelStop.add(0, (char)(currHotel+'A'));
			i = preHotel[i];
		}
		
		
		return hotelStop;
	}
	
	public static void main(String[] args) {
		int[] hotels = {0, 200, 400, 600, 601};// 0  1  2  3  4
		List<Character> result = hotelStop(hotels);
		System.out.println(result);
		
	}

}
