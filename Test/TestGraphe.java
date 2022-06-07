import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestGraphe {

    @Test
    public void testSuivantExistant(){
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("A","B",1);
        gL.ajouterArc("A","C",2);
        assertEquals( gL.getEnsNoeuds().size(), 3 ," La taille est 3 ") ;
        assertEquals( gL.getEnsNom().size(), 3 ," La taille est 3 ") ;
    }

    @Test
    public void testSuivantInexistant(){
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("A","B",1);
        gL.ajouterArc("C","E",1);
        assertEquals( gL.getEnsNoeuds().size(), 4 ," La taille est 4 ") ;
        assertEquals( gL.getEnsNom().size(), 4 ," La taille est 4 ") ;
    }

    @Test
    public void testAjouterArc(){
        Noeud n = new Noeud("A");
        n.ajouterArc("B",4);
        assertEquals( n.getAdj().size(), 1 ," La taille est 1 ") ;
        assertEquals( n.getAdj().get(0).getDest(), "B" ," il doit aller vers B ") ;
        assertEquals( n.getAdj().get(0).getCout(), 4 ," il a une valeur de 4") ;
    }


    @Test
    public void testTailleListeNoeud(){
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("A","B",1);
        gL.ajouterArc("C","E",1);
        assertEquals( gL.getEnsNoeuds().size(), 4 ," La taille est 4 ") ;
        assertEquals( gL.getEnsNom().size(), 4 ," La taille est 4 ") ;
        gL.ajouterArc("C","E",2);
        assertEquals( gL.getEnsNoeuds().size(), 4 ," La taille est 4 ") ;
        assertEquals( gL.getEnsNom().size(), 4 ," La taille est toujours 4 ") ;
        gL.ajouterArc("D","E",2);
        assertEquals( gL.getEnsNoeuds().size(), 5 ," La taille est 4 ") ;
        assertEquals( gL.getEnsNom().size(), 5 ," La taille est 5 ") ;
    }
}
