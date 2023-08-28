import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ZeitTauschenTest.
 *
 * @author  (Herbert Wenisch)
 * @version (08-20-23)
 */
public class ZeitTauschenTest {
    private ZeitTauschen zeitTauschen;
    private Graph graph;
    
    @BeforeEach
    public void setUp(){
        zeitTauschen = new ZeitTauschen();
        graph = zeitTauschen.getGraph(); 
    }

    
    @Test
    public void test_knotens(){
        System.out.println("V =  " + graph.getV());
        System.out.println("----- Knotenfeld:");
        for(Knoten knoten: graph.getKnotens())
            System.out.print(knoten + "  ");
    }
    
    @Test
    public void test_matrix(){
        System.out.println("Matrix: \n");
        System.out.println(graph);
    }
}


