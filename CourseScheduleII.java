/*
 There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]

There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented. 
*/
import java.util.*;


// directed, multiple connected area graph

public class CourseScheduleII {
	public static Stack<Integer> st = new Stack<>();
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses==0 ) return null;
        int[] res = new int[numCourses];
		int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            res[index++] = node;
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == node){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return index == numCourses ? res : new int[0];   // if not enough prerequistites, return empty array here
        
    }    

	public static void main(String[] args) {
		int num = 4;
		int[][] pre = new int[][]{
			{0, 1},
			{2, 0},
			{3, 0},
			{3, 2}
		};
		int[] res = findOrder(num, pre);
		System.out.println("finish order: ");
		for(int i = 0; i < res.length; i++){
			System.out.print( res[i] + " -> ");
		}
		System.out.print("done");
		return;
	}	
}
