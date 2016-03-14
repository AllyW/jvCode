/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented. 
*/
import java.util.*;


// directed, multiple connected area graph

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <= 0 || numCourses <=1) return true;
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) graph[i] = new ArrayList();
        for(int i = 0 ; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            if(hasCycle(visited, graph, i) == true) return false;
        }
        return true;
        
    }
    //dfs
    public static boolean hasCycle(int[] visited, ArrayList[] graph, int i){
        if(visited[i] == 1){
            return true;
        }
        visited[i] = 1;
        for(int j = 0; j < graph[i].size(); j++){
            if(hasCycle(visited, graph, (int)graph[i].get(j)) == true) return true;
        }
        visited[i] = 0;
        return false;
    }	
	
	public static void main(String[] args) {
		int num = 4;
		int[][] pre = new int[][]{
			{1, 0},
			{2, 0},
			{3, 1},
			{3, 2}
		};
		boolean res = canFinish(num, pre);
		System.out.println("can finish: " + res);
		return;
	}	
}
