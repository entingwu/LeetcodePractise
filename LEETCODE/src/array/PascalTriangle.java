package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	/* Pascal's Triangle */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        if(numRows == 0) { return result; }
        int sum = 0;
        row.add(1);
        result.add(new ArrayList<Integer>(row));
        row.clear();
        for(int i = 2; i <= numRows; i++){
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i) {
                	row.add(1);
                }else {
                	sum = result.get(i-2).get(j-2) + result.get(i-2).get(j-1);
                	row.add(sum);
            	}
            }
            result.add(new ArrayList<Integer>(row));
            row.clear();
        }
        return result;
	}
	
	public static void main(String[] args) {
		int numRows = 5;
		PascalTriangle pt = new PascalTriangle();
		List<List<Integer>> pascal = pt.generate(numRows);
		System.out.println(pascal);
	}

}
