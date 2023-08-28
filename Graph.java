/**
 * @author (Herbert Wenisch)
 * @version (1.a  Lösung)
 */

import java.util.Arrays;

public class Graph{
    private final int V_MAX;
    private int V = 0;  // augenblickliche Knotenanzahl
    private Knoten[] knotens;  // also: die Knoten
    
    
    // erzeugt einen leeren Graf:
    public Graph(int V_MAX){
        this.V_MAX = V_MAX;
        knotens = new Knoten[V_MAX];
    }
    
    
    public void knotenEinfügen(Knoten knoten){
        if (V == V_MAX) return;
        knotens[V] = knoten;
        V++;
    }

    // gibt einen vollen Array ohne Freiplätze zurück:
    public Knoten[] getKnotens(){
        return Arrays.copyOf(knotens, V);
    }
    
    public int getV(){
        return V;
    }
    
    
}
