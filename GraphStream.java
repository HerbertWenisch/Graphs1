/**
 * Visualise graph,using org.graphstream;
 *
 * @author (Herbert Wenisch)
 * @version (08-18-23)
 */

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GraphStream {
   private final static org.graphstream.graph.Graph graph_ = new SingleGraph("showGraph");
   private static Knoten[] knotens;
   private static int V;
   private static Graph graph;
   
   private GraphStream(){}
   
   public static void display(Graph graph0){
       graph = graph0;
       knotens = graph.getKnotens();
       V = graph.getV();
       setCSS();
       addNodes();
       addEdges();
       graph_.display();
   }
   
   
   private static void addNodes(){
       String id;
       org.graphstream.graph.Node node_;
       for(int i = 0; i < V; i++){
          id = knotens[i].toString();
          node_ = graph_.addNode(id);
          node_.setAttribute("ui.label",id);
        }
   }
   
   private static String getEdgeId(int v, int w){
       String result = knotens[v].toString();
       result += "-";
       result += knotens[w].toString();
       return result;
   }
   
   private static void addEdges(){
       org.graphstream.graph.Edge edge_;
       for(int v = 0; v < V; v++)
          for(int w = 0; w < V; w++){
              if (graph.adj(v,w) > 0){
                  String id = getEdgeId(v,w);
                  if(graph_.getEdge(id) == null){
                      edge_ = graph_.addEdge(id, knotens[v].toString(), knotens[w].toString(),true);
                      edge_.setAttribute("ui.label", graph.adj(v,w) + "");
                  }
                  
              }
          }
   }
   
   private static void setCSS(){
        graph_.addAttribute("ui.antialias");
        graph_.addAttribute("ui.quality");
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        String styleSheet =  "node{" +
            "   size: 30px, 30px;" +
            "   text-size: 30;" +
            "   fill-color: #eddeab;" +
            "}" +
            "edge{"+
            " text-size: 25; }";
        graph_.addAttribute("ui.stylesheet", styleSheet);
   }
   
}

