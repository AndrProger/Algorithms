import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class BreadthFirstSearchTest {
    @Test
    public void testSearch() {
        // Test with a graph where the start and end nodes are directly connected
        HashMap<String, String[]> graph1 = new HashMap<>();
        graph1.put("A", new String[]{"B", "C"});
        graph1.put("B", new String[]{"A", "D"});
        graph1.put("C", new String[]{"A", "D"});
        graph1.put("D", new String[]{"C", "B"});
        Boolean result1 = BreadthFirstSearch.search(graph1, "A", "C");
        Assertions.assertEquals(true, result1);

        // Test with a graph where the start and end nodes are not directly connected
        HashMap<String, String[]> graph2 = new HashMap<>();
        graph2.put("A", new String[]{"B", "C"});
        graph2.put("B", new String[]{"A", "D"});
        graph2.put("C", new String[]{"A", "E"});
        graph2.put("D", new String[]{"B", "E"});
        graph2.put("E", new String[]{"C", "D"});
        Boolean result2 = BreadthFirstSearch.search(graph2, "A", "E");
        Assertions.assertEquals(true, result2);

        // Test with a graph where the start and end nodes are the same
        HashMap<String, String[]> graph3 = new HashMap<>();
        graph3.put("A", new String[]{"B", "C"});
        graph3.put("B", new String[]{"A", "D"});
        graph3.put("C", new String[]{"A", "E"});
        graph3.put("D", new String[]{"B", "E"});
        graph3.put("E", new String[]{"C", "D"});
        Boolean result3 = BreadthFirstSearch.search(graph3, "B", "B");
        Assertions.assertEquals(true, result3);

        // Test with a graph where the start and end nodes are not in the graph
        HashMap<String, String[]> graph4 = new HashMap<>();
        graph4.put("A", new String[]{"B", "C"});
        graph4.put("B", new String[]{"A", "D"});
        graph4.put("C", new String[]{"A", "E"});
        graph4.put("D", new String[]{"B", "E"});
        graph4.put("E", new String[]{"C", "D"});
        Boolean result4 = BreadthFirstSearch.search(graph4, "F", "G");
        Assertions.assertEquals(false, result4);
    }
}