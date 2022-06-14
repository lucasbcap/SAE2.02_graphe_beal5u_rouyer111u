import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDijkstra {

    @Test
    public void testAlgo(){

        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);
        Dijkstra bf = new Dijkstra();
        Valeur v = bf.resoudre(graphe,"A");

        assertEquals( v.getValeur("A"), 0 ," la valeur en A est 0 ") ;
        assertEquals( v.getValeur("B"), 12 ," la valeur en B est 12 ") ;
        assertEquals( v.getValeur("C"), 76 ," la valeur en C est 76 ") ;
        assertEquals( v.getValeur("D"), 66 ," la valeur en D est 66 ") ;
        assertEquals( v.getValeur("E"), 23 ," la valeur en E est 23 ") ;

        assertEquals( v.getParent("A"), null ,"le parent en A est null ") ;
        assertEquals( v.getParent("B"), "A" ," le parent en B est A ") ;
        assertEquals( v.getParent("C"), "D" ," le parent en C est D ") ;
        assertEquals( v.getParent("D"), "E" ," le parent en D est E ") ;
        assertEquals( v.getParent("E"), "B" ," le parent en E est B ") ;
    }

}
