package binary_search;

class Search2DMatrix{
	   public int searchInsert(int[] nums, int target) {
	        if(nums == null || nums.length == 0) { return 0; }
	        int start = 0, end = nums.length - 1;
	        while(start + 1 < end){
	            int mid = start + (end - start) / 2 ;   
	            if(nums[mid] == target){
	                return mid;
	            }else if(nums[mid] < target){
	                start = mid;
	            }else{
	                end = mid;
	            }
	        }
	        if(nums[start] >= target ){
	            return start;
	        }else if(nums[end] >= target){
	            return end;
	        }else {
	            return end + 1;
	        }
	    }
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {//2d
			return false;
		}
		if(matrix[0] == null || matrix[0].length == 0) {//1d
			return false;
		}
		/*
		// 1. find the row index, the last number <= target 
		int row = matrix.length, column = matrix[0].length;
		int start = 0, end = row - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(matrix[mid][0] == target){
				return true;//found
			}else if(matrix[mid][0] < target) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(matrix[end][0] <= target) {
			row = end;//target在end行
		}else if(matrix[start][0] <= target) {
			row = start;//target在start行
		}else {
			return false;
		}
		
		// 2. find the column index, the number equal to target
		start = 0;
		end = column - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(matrix[row][mid] == target){
				return true;
			}else if(matrix[row][mid] < target){
				start = mid;
			}else {
				end = mid;
			}
		}
		if(matrix[row][start] == target) {
			return true;
		}else if(matrix[row][end] == target){
			return true;
		}else{
			return false;
		}
    }
	*/
	
	int row = matrix.length, column = matrix[0].length;
	int start = 0, end = row * column - 1;
	while(start + 1 < end){
		int mid = start + (end - start) / 2;
		int number = matrix[mid / column][mid % column];
		if(number == target) {
			return true;
		} else if (number < target){
			start = mid;
		} else {
			end = mid;
		}
	}
	
	if(matrix[start / column][start % column] == target){
		return true;
	} else if(matrix[end / column][end % column] == target){
		return true;
	}
	return false;
	
	}
	
	/* searchMatrixII */
	public boolean searchMatrixII(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) { return false; }
		if(matrix[0] == null || matrix[0].length == 0) { return false; }
		int row = matrix.length;
		int col = matrix[0].length;
		int x = 0, y = col-1; 
		while(x>=0 && x<row && y>=0 && y<col) {
			if(matrix[x][y] == target) {
				return true;
			}else if (matrix[x][y] < target) {
				x++;//往下
			}else {
				y--;//往左
			}
		}
		return false;

	}
	
	public static void main(String[] args) {
		int[][] test = new int[5][5];
		test[0][0] = 1; test[0][1] = 4; test[0][2] = 7; test[0][3] = 11; test[0][4] = 15;
		test[1][0] = 2; test[1][1] = 5; test[1][2] = 8; test[1][3] = 12; test[1][4] = 19;
		test[2][0] = 3; test[2][1] = 6; test[2][2] = 9; test[2][3] = 16; test[2][4] = 22;
		test[3][0] = 10; test[3][1] = 13; test[3][2] = 14; test[3][3] = 17; test[3][4] = 24;
		test[4][0] = 18; test[4][1] = 21; test[4][2] = 23; test[4][3] = 26; test[4][4] = 30;
		
		Search2DMatrix sm = new Search2DMatrix();
		int target = 20;
		System.out.println(sm.searchMatrixII(test, target));
		
		
		
	}
	
	
}

