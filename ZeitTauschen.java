
/**
 * @author (Herbert Wenisch)
 * @version (08-18-23)
 */

// unser Beispielgraf:

public class ZeitTauschen {
    private Graph graph;
    
    public ZeitTauschen(){
        graph = new Graph(9);
        fillUpNodes();
    }
    
    public Graph getGraph(){
        return graph;
    }
    
    private void fillUpNodes(){
        graph.knotenEinfügen(new Knoten("Roy")); 
        graph.knotenEinfügen(new Knoten("Mass"));
        graph.knotenEinfügen(new Knoten("Jen"));
        graph.knotenEinfügen(new Knoten ("Delina"));
        graph.knotenEinfügen(new Knoten("Terry"));
    }
    
}
