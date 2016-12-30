package dynamicProgramming;

public class SequenceDP {
	/** 1. CLIMBING STAIRS 
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top?*/
	public static int climbStairs(int n) {
		if(n <= 1){ return n;}
		//1. state
		int m = n + 1;//n steps, n+1 stairs
		int[] planSum = new int[m];
		
		//2. initialize
		for(int i = 0; i < m; i++){
			planSum[i] = 1;
		}
		
		//3. function
		for(int i = 2; i < m; i++){
			planSum[i] = planSum[i - 1] + planSum[i - 2];
		}
		
		//4.result
		return planSum[m - 1];
	}
	
	/** JUMP GAME */
	public boolean canJump(int[] nums) {
		int gridNum = nums.length;
        //1. state 
		boolean[] canJump = new boolean[gridNum];
		//2. initialize
        canJump[0] = true;
		
        //3. function
        for(int i = 1; i< gridNum; i++){//能否从起点跳到第i个位置
        	for(int j = 0; j < i; j++ ){//j在i前面
        		if(canJump[j] && j + nums[j] >= i){
        			canJump[i] = true;
        			break;
        		}
        	}
        }
        
        //4. answer
        return canJump[gridNum-1];
    }
	
	public boolean canJump1(int[] nums) {
		int gridNum = nums.length;
		int maxReach = 0;
		
        for(int i = 0; i < gridNum && i <= maxReach; i++){//能否从起点跳到第i个位置
        	maxReach = Math.max(maxReach, nums[i] + i);
        }
        
        return maxReach >= gridNum - 1;
    }
	
	/** JUMP GAME II */
	public int jump(int[] nums) {
        //1. state
		int gridNum = nums.length;
		int[] minSteps = new int[gridNum];
		
		//2. initialize
		minSteps[0] = 0;
		
		//3. function
		for(int i = 1; i < gridNum; i++){
			minSteps[i] = Integer.MAX_VALUE;//i处未被访问
			for(int j = 0; j < i; j++){
				if(minSteps[j] != Integer.MAX_VALUE && j + nums[j] >= i){
					minSteps[i] = minSteps[j] + 1;//i处被访问,从j一步到i
					break;
				}
			}
		}
		
		//4. answer
		return minSteps[gridNum-1];
    }
}
