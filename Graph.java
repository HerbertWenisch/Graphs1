/**
 * @author (Herbert Wenisch)
 * @version (1.b  Aufgabe)
 */

import java.util.Arrays;

public class Graph{
    private final int V_MAX;
    private int V = 0;  // augenblickliche Knotenanzahl
    private Knoten[] knotens;  // also: die Knoten
    private int[][] matrix; // besser: adj
    
    // erzeugt einen leeren Graf:
    public Graph(int V_MAX){
        this.V_MAX = V_MAX;
        knotens = new Knoten[V_MAX];
        matrix = new int [V_MAX][V_MAX];
    }
    
    
    public void knotenEinfügen(Knoten knoten){
        if (V == V_MAX) return;
        knotens[V] = knoten;
        V++;
    }

    public void kanteEinfügen(int von, int nach, int gewicht){
        // Your code!
    }
    
    
    // gibt einen vollen Array ohne Freiplätze zurück:
    public Knoten[] getKnotens(){
        return Arrays.copyOf(knotens, V);
    }
    
    public int getV(){
        return V;
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
    
}
