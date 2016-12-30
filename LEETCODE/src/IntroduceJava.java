import java.util.ArrayList;

/*1. Fizz Buzz*/
public class IntroduceJava {
	public ArrayList<String> fizzBuzz(int n){
		ArrayList<String> numList = new ArrayList<String>();
		for(int i = 1; i <= n; i++){
			if(i % 3 == 0 && i % 5 == 0){
				numList.add("fizz buzz");
			}else if( i % 5 == 0){
				numList.add("buzz");
			}else if( i % 3 == 0){
				numList.add("fizz");
			}else{
				numList.add(String.valueOf(i));
			}
		}
		return numList;
	}
	public static void main(String[] args) {
		

	}

}
