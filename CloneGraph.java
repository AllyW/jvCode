/*
 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

*/


import java.io.*;
import java.util.*;
public class CloneGraph {
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> hp = new HashMap();
        hp.put(res.label, res); 
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!hp.containsKey(neighbor.label)) {
                    hp.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
                hp.get(n.label).neighbors.add(hp.get(neighbor.label));
            }
        }
        return res;
    }
	
	public static void main(String[] args) { 
		UndirectedGraphNode root = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);
		root.neighbors.add(node2);
		root.neighbors.add(node3);
		node3.neighbors.add(node4);
		node3.neighbors.add(node5);
		node5.neighbors.add(node5);
		UndirectedGraphNode res = cloneGraph(root);
		System.out.println("result node label:" + res.label);
		return;
	}	
}
