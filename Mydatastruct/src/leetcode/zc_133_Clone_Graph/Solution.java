/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode root = copy(node,map);
        return root;
    }
    
    private UndirectedGraphNode copy(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node,root);
        root.neighbors = new ArrayList<UndirectedGraphNode>();
        for(UndirectedGraphNode subnode : node.neighbors){
            root.neighbors.add(copy(subnode,map));
        }
        return root;
    }
}
