package bfsGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer> result = new ArrayList<Integer>();
		if (prerequisites.length == 0) { return true; }
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        /* 1. graph : map does not contain course (indegree == 0) */
        for(int[] order : prerequisites) {
        	int second = order[0];
        	int first = order[1];// indegree == 0
    		if (!map.containsKey(first)) {
    			map.put(first, new ArrayList<Integer>());
        	}
    		map.get(first).add(second);
    		indegree[second]++;
        }
        /* 2. Put course (indegree == 0) in queue */
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) {//0
        		queue.offer(i);
        		result.add(i);
        	}
        }
        /* 3. Topological Sort */
        while(!queue.isEmpty()) {
        	Integer course = queue.poll();//remove
        	if (! map.containsKey(course)) {//1 []
        		continue;
        	}
        	ArrayList<Integer> neighbors = map.get(course);//0 [1]
        	for(Integer neighbor : neighbors) {
        		indegree[neighbor]--;
            	if (indegree[neighbor] == 0) {
            		queue.offer(neighbor);
            		result.add(neighbor);
            	}
        	}
        	
        }
        System.out.println(result);
        return result.size() == numCourses;
    }
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> result = new ArrayList<Integer>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        /* 1. graph : map does not contain course (indegree == 0) */
        for(int[] order : prerequisites) {
        	int second = order[0];
        	int first = order[1];// indegree == 0
    		if (!map.containsKey(first)) {
    			map.put(first, new ArrayList<Integer>());
        	}
    		map.get(first).add(second);
    		indegree[second]++;
        }
        /* 2. Put course (indegree == 0) in queue */
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) {//0
        		queue.offer(i);
        		result.add(i);
        	}
        }
        /* 3. Topological Sort */
        while(!queue.isEmpty()) {
        	Integer course = queue.poll();//remove
        	if (! map.containsKey(course)) {//1 []
        		continue;
        	}
        	ArrayList<Integer> neighbors = map.get(course);//0 [1]
        	for(Integer neighbor : neighbors) {
        		indegree[neighbor]--;
            	if (indegree[neighbor] == 0) {
            		queue.offer(neighbor);
            		result.add(neighbor);
            	}
        	}
        	
        }
        
        if (result.size() != numCourses) {// loop
        	return new int[0];
        }
        
        int[] resultArray = new int[numCourses];
        for(int i = 0; i < result.size(); i++) {
        	resultArray[i] = result.get(i);
        }
        return resultArray;
    }

	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}};
		int numCourses1 = 2;
		int[][] prerequisites1 = {};
		int numCourses2 = 4;
		int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(cs.canFinish(numCourses2, prerequisites2));
		
		int numCourses3 = 2;
		int[][] prerequisites3 = {{0,1},{1,0}};
		int[] result = cs.findOrder(numCourses3, prerequisites3);
		System.out.println(result.length);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ",");
        }
	}

}
