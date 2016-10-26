public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int next = prerequisites[i][0];
            if(graph[pre][next]==0)
                degree[next]++;
            graph[pre][next] = 1;
        }
        
        int count = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        for(int  i = 0; i < degree.length ; i++){
            if(degree[i]==0) que.offer(i);
        }
        int[] ret = new int[numCourses];
        int p = 0;
        while(!que.isEmpty()){
            int index = que.poll();
            count++;
            ret[p++] = index;
            for(int i = 0 ; i < numCourses ; i++){
                if(graph[index][i]==1){
                    if(--degree[i]==0)
                        que.offer(i);
                }
            }
        }
        if(count!=numCourses) return new int[0];
        return ret;
    }
}
