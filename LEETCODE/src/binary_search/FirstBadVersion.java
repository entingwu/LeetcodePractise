package binary_search;

class VersionControl{
	public boolean isBadVersion(int version){
		return version >= 7;
	}
}

class Solution extends VersionControl {
	public int[] version;
    public int firstBadVersion(int n) {
        version = new int[n];
        for(int i=0;i<n;i++){
        	version[i] = i+1;
        }
        return find1(0,n-1);
    }
    public int find(int lowerIndex,int upperIndex){
    	int midIndex = lowerIndex+(upperIndex-lowerIndex)/2;
    	while(lowerIndex<upperIndex){
    		if(isBadVersion(midIndex)){
    			upperIndex = midIndex;
    		}else{//Good version
    			lowerIndex = midIndex+1;
    		}
    	}
    	return midIndex;
    }
    
    public int find1(int lowerIndex,int upperIndex){
    	int midIndex = (lowerIndex+upperIndex)/2;
    	int badVersion = 0;
    	if(isBadVersion(version[midIndex])){
    		return midIndex;
    	}else if(lowerIndex>upperIndex){
    		return version.length;
    	}else{
    		if(isBadVersion(version[midIndex])){
        		badVersion = find1(lowerIndex,midIndex-1);
        	}else{
        		badVersion = find1(midIndex+1,upperIndex);
        	}
    	}
    	return badVersion;
    }
}

public class FirstBadVersion {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.firstBadVersion(10));

	}

}
