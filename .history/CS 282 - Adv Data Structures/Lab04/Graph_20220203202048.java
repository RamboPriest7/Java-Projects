
//Project Finished by Christian Jarmon
import java.util.*;
import java.io.*;

public class Graph<V> {
	private List<V> vertices = new ArrayList<>();
	private List<List<Edge>> neighbors = new ArrayList<>(); // Adjacency lists

	public boolean[] visited;
	public Queue<V> traversalQueue;
	public Stack<V> vertexStack;
	public Queue<V> vertexQueue;

	public Graph(V[] vertices, int[][] edges) {
		this.vertices = new ArrayList<>(Arrays.asList(vertices));
		createGraph(this.vertices, edges);
	}

	public void createGraph(List<V> vertices, int[][] edges) {
		for (int i = 0; i < vertices.size(); ++i)
			neighbors.add(new ArrayList<Edge>());

		for (int i = 0; i < edges.length; ++i) {
			neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
		}

	}

	public void dfs(V startVertex) {
		visited = new boolean[vertices.size()];
		traversalQueue = new LinkedList<>();
		vertexStack = new Stack<>();
		vertexQueue = new LinkedList<>();
		visited[vertices.indexOf(startVertex)] = true;
		traversalQueue.offer(startVertex);
		vertexStack.push(startVertex);

		while (!vertexStack.isEmpty()) {
			V topVertex = vertexStack.peek();
			List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(topVertex));
			int i;
			for (i = 0; i < nextNeighbor.size(); ++i) {
				Edge edge = nextNeighbor.get(i);
				int index = edge.v;
				if (!visited[index]) {

					visited[index] = true;
					traversalQueue.offer(vertices.get(index));
					vertexStack.push(vertices.get(index));
					break;
				}
			}
			if (i == nextNeighbor.size())
				vertexStack.pop();

		}
		System.out.println(traversalQueue);
	}

	public void bfs(V startVertex) {
		visited = new boolean[vertices.size()];
		traversalQueue = new LinkedList<>();
		vertexStack = new Stack<>();
		vertexQueue = new LinkedList<>();
		visited[vertices.indexOf(startVertex)] = true;
		traversalQueue.offer(startVertex);
		vertexQueue.offer(startVertex);

		while (!vertexQueue.isEmpty()) {
			V frontVertex = vertexQueue.remove();
			List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(frontVertex));
			int i;
			for (i = 0; i < nextNeighbor.size(); ++i) {
				Edge edge = nextNeighbor.get(i);
				int index = edge.v;
				if (!visited[index]) {

					visited[index] = true;
					traversalQueue.offer(vertices.get(index));
					vertexQueue.offer(vertices.get(index));

				}
			}
		}

		System.out.println(traversalQueue);
	}

	public void primMST(V startVertex) {
		LinkedList<V> v = new LinkedList<>(vertices);
		LinkedList<V> t = new LinkedList<>();
		LinkedList<WeightedEdge> mst = new LinkedList<>();
		double totalWeight = 0;
		t.add(startVertex);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Edge> nextNeighbor = neighbors.get(vertices.indexOf(startVertex));
		for (int i = 0; i < nextNeighbor.size(); ++i)
			pq.offer(nextNeighbor.get(i));
		while (t.size() < vertices.size()) {
			WeightedEdge e = (WeightedEdge) pq.poll();
			while (t.contains(vertices.get(e.v)))
				e = (WeightedEdge) pq.poll();
			t.add(vertices.get(e.v));
			mst.add(e);
			totalWeight += e.weight;
			nextNeighbor = neighbors.get(e.v);
			for (int i = 0; i < nextNeighbor.size(); ++i)
				pq.offer(nextNeighbor.get(i));

		}

		// System.out.println(mst);
		System.out.print("[");
		for (int i = 0; i < mst.size() - 1; ++i) {
			System.out.print("{" + vertices.get(mst.get(i).u) + "," + vertices.get(mst.get(i).v) + ","
					+ mst.get(i).weight + "}, ");
		}
		System.out.println("{" + vertices.get(mst.get(mst.size() - 1).u) + "," + vertices.get(mst.get(mst.size() - 1).v)
				+ "," + mst.get(mst.size() - 1).weight + "}]");
		System.out.println("Total cost of MST " + totalWeight);

	}

	@SuppressWarnings("unchecked")
	public void kruskalMST() {
		PriorityQueue<Edge> edgeList = new PriorityQueue<>();

		// Graph<String> mst = new Graph<>();
		LinkedList<V> v = new LinkedList<>(vertices);
		Set<V> t = new LinkedHashSet<>();
		LinkedList<WeightedEdge> mst = new LinkedList<>();

		for (int i = 0; i < vertices.size(); ++i) {
			neighbors.get(i).forEach(e -> edgeList.add(e));

		}
		double totalWeight = 0;
		@SuppressWarnings("rawtypes")
		CycleDetector cd = new CycleDetector(vertices);
		while (mst.size() != v.size() - 1) {

			WeightedEdge e = (WeightedEdge) edgeList.remove();
			if (!cd.detectCycle(e.u, e.v)) {

				mst.add(e);
				totalWeight += e.weight;
				t.add(v.get(e.v));
				t.add(v.get(e.u));
			}

		}
		System.out.print("[");
		for (int i = 0; i < mst.size() - 1; ++i) {
			System.out.print("{" + vertices.get(mst.get(i).u) + "," + vertices.get(mst.get(i).v) + ","
					+ mst.get(i).weight + "}, ");
		}
		System.out.println("{" + vertices.get(mst.get(mst.size() - 1).u) + "," + vertices.get(mst.get(mst.size() - 1).v)
				+ "," + mst.get(mst.size() - 1).weight + "}]");
		System.out.println("Total cost of MST " + totalWeight);

	}

	public void shortestPath(V sV, V eV) {
		// in parent the value of the index is the parent of that index
		Map<V, Boolean> visited = new HashMap<>();
		for (int i = 0; i < vertices.size(); i++) {
			visited.put(vertices.get(i), false);
		}
		/*
		 * for (V a : vertices) { System.out.print(visited.get(a) + " -- "); }
		 * System.out.println();
		 */
		// visited.replace(sV, true);
		double[] cost = new double[vertices.size()];
		for (int i = 0; i < cost.length; i++) {
			cost[i] = Double.MAX_VALUE;
		}
		cost[0] = 0;
		int[] parent = new int[vertices.size()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		while (visited.get(eV) == false) {

			int U = min(cost, visited);
			visited.replace(vertices.get(U), true);
			/*
			 * for (V a : vertices) { System.out.print(visited.get(a) + " -- "); } for
			 * (double d : cost) { System.out.print(d + "  "); } System.out.println();
			 */
			for (int j = 0; j < vertices.size(); j++) {
				// boolean bool1 = isEdge(vertices.get(U), vertices.get(j));
				// boolean bool2 = visited.get(vertices.get(j));
				// boolean bool3 = cost[U] != Double.MAX_VALUE;
				// boolean bool4 = (cost[U] + getWeight(vertices.get(U), vertices.get(j)) <
				// cost[j]);
				// System.out.println(bool1 + "-" + bool2 + "-" + bool3 + "-" + bool4);
				if (isEdge(vertices.get(U), vertices.get(j)) == true && visited.get(vertices.get(j)) == false
						&& cost[U] != Double.MAX_VALUE
						&& (cost[U] + getWeight(vertices.get(U), vertices.get(j)) < cost[j])) {
					cost[j] = cost[U] + getWeight(vertices.get(U), vertices.get(j));
					parent[j] = U;
					// System.out.println(cost[j] + " " + cost[U] + " " + getWeight(vertices.get(U),
					// vertices.get(j)) + " " + parent[j]);
				} // if ends
			}

		} // while ends
			// System.out.print("while loop terminated");
			// in parent, the value of index i is the parent of vertices.get(i)
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int i = 0; i < parent.length; i++) {
			path.add(i, parent[i]);
		}
		int check = vertices.indexOf(eV);
		ArrayList<V> tP = new ArrayList<V>();
		while (check != -1) {
			tP.add(vertices.get(check));
			check = parent[check];
		}
		// System.out.println(tP);
		for (int i = tP.size() - 1; i != -1; i--) {
			System.out.print(tP.get(i));
			if (i != 0) {
				System.out.print("-->");
			}
		} // for ends
		System.out.println();
		System.out.println("Cost of shortest path is " + cost[vertices.indexOf(eV)]);
	}// shortest path ends

	public int min(double[] c, Map<V, Boolean> vis) {// this function finds the vertex that connects to the most
														// recently visited node that also has the smallest weight
		double minimum = Double.MAX_VALUE;
		int vertex = 0;
		// make a loop the continously finds the minimum weight for all neighbors given
		// a specific vertex
		for (int i = 0; i < vertices.size(); i++) {
			if (c[i] < minimum && vis.get(vertices.get(i)) == false) {
				minimum = c[i];
				vertex = i;
			}
		}
		// System.out.println("Vertex " + vertex + " weight " + c[vertex]);
		return vertex;
	}// min ends

	public Edge findEdge(int u, double w) {// finds the edge that contains the u and weight, finding v
		for (int i = 0; i < neighbors.size(); i++) {
			for (Edge q : neighbors.get(i)) {
				if (q.u == u && ((WeightedEdge) q).weight == w)
					return q;
			}
		}
		return neighbors.get(0).get(0);
	}// findEdge found

	public boolean isEdge(V a, V b) {// find matching index of neighbors
		for (Edge q : neighbors.get(vertices.indexOf(a))) {
			if (q.v == vertices.indexOf(b)) {}		
				return true;
			} // if ends
		} // for ends
	return false;

	// isEdge ends

	public int tOL(LinkedList<V> vl) {
		return (vl.size() - 1);
	}

	public V convertToVertex(int a) {
		return vertices.get(a);
	}

	public double getWeight(V a, V b) {
		for (Edge q : neighbors.get(vertices.indexOf(a))) {
			if (q.v == vertices.indexOf(b)) {
				return ((WeightedEdge) q).weight;
			} // if ends
		} // for ends
		System.out.println("Error, weight not found for Vertices: " + a + " and " + b + ".");
		return 0.0;
	}// getWeights ends

	public void printGraph() {
		for (int i = 0; i < vertices.size(); ++i) {
			System.out.print(vertices.get(i) + ":");
			System.out.println(neighbors.get(i));
		}
	}
}
