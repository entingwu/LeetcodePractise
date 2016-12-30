package math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		String FIZZ = "Fizz";
		String BUZZ = "Buzz";
        List<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
        	if (i % 3 == 0 && i % 5 == 0) {
        		result.add(FIZZ + BUZZ);
        	} else if (i % 3 == 0) {
        		result.add(FIZZ);
        	} else if (i % 5 == 0) {
        		result.add(BUZZ);
        	} else {
        		result.add(Integer.toString(i));
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		List<String> result = fb.fizzBuzz(15);
		for(String str : result) {
			System.out.println(str + ",");
		}
	}

}
