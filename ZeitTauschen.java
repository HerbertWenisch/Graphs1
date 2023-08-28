
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
        graph.kanteEinfügen("Roy", "Mass", 8);
        graph.kanteEinfügen("Roy", "Jen", 4);
        graph.kanteEinfügen("Roy", "Terry", 13);
        graph.kanteEinfügen("Mass", "Delina", 9);
        graph.kanteEinfügen("Jen", "Mass", 2);
        graph.kanteEinfügen("Jen", "Delina", 8);
        graph.kanteEinfügen("Delina", "Roy", 12);
        graph.kanteEinfügen("Delina", "Terry", 5);
        graph.kanteEinfügen("Terry", "Jen", 9);
    }
}
