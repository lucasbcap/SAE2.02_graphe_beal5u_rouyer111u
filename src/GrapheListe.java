import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    /**
     *
     */
    public GrapheListe(){

    }



    /**
     *
     * @return
     */
    @Override
    public List<String> listeNoeuds() {
        return null;
    }

    /**
     *
     * @param n le nom du noeud
     * @return
     */
    @Override
    public List<Arc> suivants(String n) {
        return null;
    }


    public void  ajouterArc(String depart,String destination,double cout){}


}
