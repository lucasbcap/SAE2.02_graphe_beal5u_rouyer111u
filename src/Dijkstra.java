import java.util.ArrayList;
import java.util.List;

public class Dijkstra implements Algorithme{


    public Dijkstra(){
    }

    /**
     *
     * Algo Dijkstra
     *
     * Debut
     * Q <- {} // utilisation d’une liste de noeuds a traiter
     * Pour chaque sommet v de G faire
     * v.distance <- Infini
     * v.parent <- Indefini
     * Q <- Q U {v} // ajouter le sommet v a la liste Q
     * Fin Pour
     * A.distance <- 0
     * Tant que Q est un ensemble non vide faire
     * u <- un sommet de Q telle que u.distance est minimale
     * Q <- Q \ {u} // enlever le sommet u de la liste Q
     * Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
     * D <- u.distance + poids(u,v)
     * Si D < v.distance
     * Alors v.distance <- D
     * v.parent <- u
     * Fin Si
     * Fin Pour
     * Fin Tant que
     * Fin
     *
     *
     *
     * @param g
     * @param depart
     * @return
     */
    public Valeur resoudre(Graphe g, String depart){
        List<String> q = new ArrayList<String>(g.listeNoeuds()) ;


        Valeur v = initialisation(g, depart);

        while (!q.isEmpty()){
            int min = (int)v.getValeur(q.get(0));
            int index = 0;
            for(int i = 0 ; i<q.size();i++){
                if(min>(int)v.getValeur(q.get(i))){
                    min = (int)v.getValeur(q.get(i));
                    index = i;
                }
            }
            String u = q.get(index);
            q.remove(index);

            if(g.suivants(u)!=null) {
                for (int i = 0; i < g.suivants(u).size(); i++) {
                    int d = (int) g.suivants(u).get(i).getCout() + (int) v.getValeur(u);
                    if (d < (int) (v.getValeur(g.suivants(u).get(i).getDest()))) {
                        v.setValeur(g.suivants(u).get(i).getDest(), d);
                        v.setParent(g.suivants(u).get(i).getDest(), u);
                    }
                }
            }
        }
        return v;
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
        }
        return v;
    }


}
