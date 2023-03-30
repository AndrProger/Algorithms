import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static Boolean search(HashMap<String, String[]> graph, String start,String end) {
        HashMap<String,Boolean> haveBeenVisited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (queue.peek()!=null) {
            String nodeCurrent = queue.poll();
            if(nodeCurrent.equals(end)) return true;
            String[] nodes=graph.get(nodeCurrent);
            if(nodes==null) throw new IllegalArgumentException("Graph have not a start node");
            //or return false?
            for (String node : nodes) {
                if(haveBeenVisited.get(node)==null) {
                    queue.offer(node);
                }
            }
            haveBeenVisited.put(nodeCurrent,true);
        }
        return false;

    }

}
