/**
 * Created by DebbiePao on 11/12/16.
 */
import java.util.*;
public class Molecule {
    private LinkedList<Edge>[] adjLists;
    private int vertexCount;
    private int startVertex;

    public Molecule(int numVertices) {
        adjLists = new LinkedList[numVertices];
        startVertex = 0;
        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    public void setStartVertex(int a) {
        if (a < vertexCount && a >= 0) {
            startVertex = a;
        } else {
            throw new IllegalArgumentException("Cannot iteration start vertex to " + a + "." );
        }
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2.
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, null);
    }
    // Add to the graph an undirected edge from vertex v1 to vertex v2,
    // with the given edge information.
    public void addUndirectedEdge(int v1, int v2, Object edgeInfo) {
        adjLists[v1].addFirst(new Edge(v1, v2, edgeInfo));
        adjLists[v2].addFirst(new Edge(v2, v1, edgeInfo));
    }

    // Return true if there is an edge from vertex "from" to vertex "to";
    // return false otherwise.
    public boolean isAdjacent(int from, int to) {
        for (Object b : neighbors(from)) {
            if (b.equals(to)) {
                return true;
            }
        }
        return false;
    }

    // Returns a list of all the neighboring  vertices 'u'
    // such that the edge (VERTEX, 'u') exists in this graph.
    public List neighbors(int vertex) {
        // your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int count = 0;
        while (count < adjLists[vertex].size()) {
            ans.add(adjLists[vertex].get(count).getto());
            count++;
        }
        return ans;
    }

    // Return the number of incoming vertices for the given vertex,
    // i.e. the number of vertices v such that (v, vertex) is an edge.
    public int inDegree(int vertex) {
        int ans = 0;
        for (int i = 0; i < vertexCount; i++) {
            for (Object m : neighbors(i)) {
                if (m.equals(vertex)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // A class that iterates through the vertices of this graph, starting with a given vertex.
    // Does not necessarily iterate through all vertices in the graph: if the iteration starts
    // at a vertex v, and there is no path from v to a vertex w, then the iteration will not
    // include w
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            fringe = new Stack<>();
            visited = new HashSet<>();
            setStartVertex(start);
            fringe.push(start);
            visited.add(start);
        }

        public boolean hasNext() {
            if (!(fringe.empty())) {
                return true;
            }
            return false;
        }

        public Integer next() {
            Integer curr = fringe.pop();
            List children = neighbors(curr);
            for (Object i : children) {
                if (!visited.contains(i)) {
                    fringe.push((Integer) i);
                    visited.add((Integer) i);
                }
            }
            return curr;
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    // Return the collected result of iterating through this graph's
    // vertices as an ArrayList.
    public ArrayList<Integer> visitAll(int startVertex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(startVertex);

        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }
    private class Edge {
        private Integer from;
        private Integer to;
        private Object edgeInfo;

        public Edge(int from, int to, Object info) {
            this.from = new Integer(from);
            this.to = new Integer(to);
            this.edgeInfo = info;
        }

        public Integer getto() {
            return to;
        }

        public Object getinfo() {
            return edgeInfo;
        }

        public String toString() {
            return "(" + from + "," + to + ",dist=" + edgeInfo + ")";
        }
    }
}
