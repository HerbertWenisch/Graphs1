
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
        fillUpEdges();
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
    
    private void fillUpEdges(){
        graph.kanteEinfügen(0, 1, 8);
        graph.kanteEinfügen(0, 2, 4);
        graph.kanteEinfügen(0, 4, 13);
        graph.kanteEinfügen(1, 3, 9);
        graph.kanteEinfügen(2, 1, 2);
        graph.kanteEinfügen(2, 3, 8);
        graph.kanteEinfügen(3, 0, 12);
        graph.kanteEinfügen(3, 4, 5);
        graph.kanteEinfügen(4, 2, 9);
    }
}
