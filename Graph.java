/**
 * @author (Herbert Wenisch)
 * @version (verbesserte Endfassung mit Grafikausgabe)
 */

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import java.util.Arrays;

public class Graph{
    private final int V_MAX;
    private int V = 0;  // augenblickliche Knotenanzahl
    private Knoten[] knotens;  // also: die Knoten
    private int[][] matrix; // besser: adj
    private GraphStream graphStream;  // zur Visualisierung
    
    // erzeugt einen leeren Graf:
    public Graph(int V_MAX){
        this.V_MAX = V_MAX;
        knotens = new Knoten[V_MAX];
        matrix = new int [V_MAX][V_MAX];
        graphStream = new GraphStream();
    }
    
    
    public void knotenEinfügen(Knoten knoten){
        if (V == V_MAX) return;
        knotens[V] = knoten;
        V++;
    }

    private int knotenNummerGeben(String bezeichner){
        for(int i = 0; i < V; i++)
           if(bezeichner.equals(knotens[i].toString())) return i;
        return -1;   // Fehler!
    }
    
    
    public void kanteEinfügen(int von, int nach, int gewicht){
        if(von >= V ||  nach >= V) return;
        if(von < 0 ||  nach < 0 ) return;
        matrix[von][nach] = gewicht;
    }
    
    public void kanteEinfügen(String von, String nach, int gewicht){
        kanteEinfügen(knotenNummerGeben(von), knotenNummerGeben(nach), gewicht);
    }
    
    
    // gibt einen vollen Array ohne Freiplätze zurück:
    public Knoten[] getKnotens(){
        return Arrays.copyOf(knotens, V);
    }
    
    public int getV(){
        return V;
    }
    
    public int adj(int i, int j){
        return matrix[i][j];
    }
    
    // gibt die Matrix aus:
    @Override
    public String toString(){ 
       String whiteSpace6 = "      ";  // Länge: 6
       StringBuilder out = new StringBuilder(whiteSpace6);
       // Spaltenbezeichner:
       for(int i = 0; i < V; i++)
          out.append(knotens[i].toString(3,6));
       // Zeilen:   
       for(int i = 0; i < V; i++){
           out.append("\n" + knotens[i].toString(3,6)); // Zeilenbezeichner
           for(int j = 0; j < V; j++) 
              out.append( (matrix[i][j] == 0)? whiteSpace6 : (matrix[i][j] + whiteSpace6).substring(0,6));
       }      
       return out.toString();
    }
    
    public void display(){
        graphStream.display();
    }
    
    //-------------------------------------------------------------------------------------------
    
    private class GraphStream {
        private final org.graphstream.graph.Graph graph_ = new SingleGraph("showGraph");
        
        GraphStream(){
          setCSS_();  
        }
        
        public void display(){
          addNodes_();
          addEdges_();
          graph_.display();
        }
      
   
        private void addNodes_(){
          String id;
          org.graphstream.graph.Node node_;
          for(int i = 0; i < V; i++){
             id = knotens[i].toString();
             node_ = graph_.addNode(id);
             node_.setAttribute("ui.label", id);
           }
       }
       
       
       private String getEdgeId_(int v, int w){
           return knotens[v].toString() + "-" + knotens[w].toString();
        }
        
       private void addEdges_(){
       org.graphstream.graph.Edge edge_;
       for(int i = 0; i < V; i++)
          for(int j = 0; j < V; j++){
              if (matrix[i][j] > 0){
                  String id = getEdgeId_(i,j);
                  if(graph_.getEdge(id) == null){
                      edge_ = graph_.addEdge(id, knotens[i].toString(), knotens[j].toString(),true);
                      edge_.setAttribute("ui.label", matrix[i][j] + "");
                  }
              }
          }
       }
       
       private void setCSS_(){
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
}
