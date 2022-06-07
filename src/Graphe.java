import java.util.ArrayList;
import java.util.List;

/**
 * Interface Graphe
 */
public interface Graphe {

    /**
     * methode listeNoeuds
     * @return tous les noeuds du graphe
     */
    public List<String> listeNoeuds();

    /**
     * Methode suivant
     * @param n le nom du noeud
     * @return la liste des arcs partant du noeud n
     */
    public List<Arc> suivants(String n);
}
