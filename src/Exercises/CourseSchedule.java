import java.util.*;

public class CourseSchedule {

    Stack<Integer> s = new Stack();
    Map<Integer, Integer> map = new HashMap();
    Map<Integer, List<Integer>> neighbours = new HashMap();
    List<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for( Integer i=0 ; i< prerequisites.length; i++){
            map.put(i, 0);
            neighbours.put(i,new ArrayList<Integer>());
        }


        for( Integer i=0 ; i< prerequisites.length; i++){

            List<Integer> currentList =  neighbours.get(prerequisites[i][0]);
            currentList.add(prerequisites[i][1]);

            neighbours.put(prerequisites[i][0], currentList);
            map.put(prerequisites[i][1], map.get(prerequisites[i][1])+1);
        }

        for(Integer i=0; i<= numCourses; i++){
            if(map.get(i)==0){
                s.push(i);
            }
        }

        while(!s.isEmpty()){
            Integer node = s.pop();

            visited.add(node);
            List<Integer> localNeighbours = neighbours.get(node);

            for(Integer neighbour : localNeighbours){
                map.put(neighbour, map.get(neighbour)-1);
                if(map.get(neighbour)==0){
                    s.push(neighbour);
                }
            }
        }

        if(visited.size() == numCourses)
        {return true;}

        return false;





    }
}
