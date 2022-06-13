import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private ArrayList<Double> q;

    public Dijkstra(){
        q = new ArrayList<>();
    }

    public Valeur resoudre(Graphe g, String depart){

        Valeur v = initialisation(g, depart);

        while (!q.isEmpty()){
            for (int i = 0; i<g.listeNoeuds().size(); i++ ){
                int d;
            }
        }
    }

    /**
     * Permet d initialiser les sommet
     * @param g graphe fournit
     * @param depart Sommet de depart
     * @return la valeur d initialisation
     */
    public Valeur initialisation(Graphe g, String depart) {
        Valeur v = new Valeur();

        List<String> listeNoeuds = g.listeNoeuds();
        for (int i = 0; i < listeNoeuds.size(); i++) {
            if (listeNoeuds.get(i).compareTo(depart) == 0) {
                v.setValeur(listeNoeuds.get(i), 0);

            } else {
                v.setValeur(listeNoeuds.get(i), Double.MAX_VALUE);
            }
            q.add(i, v.getValeur(listeNoeuds.get(i)));
        }
        return v;
    }


}
