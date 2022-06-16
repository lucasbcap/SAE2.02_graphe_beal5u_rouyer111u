import java.util.Random;
import java.util.concurrent.SynchronousQueue;

public class GenererGraphe {

    private int nbNoeuds;
    private String depart;
    private String arrivee;

    /**
     * Constructeur de la classe GenererGraphe
     *
     * @param n le nombre de noeuds
     * @param d le noeud de depart
     * @param a le noeud d'arrivee
     */
    public GenererGraphe(int n, String d, String a) {
        this.nbNoeuds = n;
        this.depart = d;
        this.arrivee = a;
    }

    /**
     * Methode permettant de choisir aleatoirement un nombre
     *
     * @param fois le nombre max
     * @return le nombre choisi
     */
    public int alea(int fois) {
        //choisit un nombre aleatoire
        Random r = new Random();
        return r.nextInt(fois);
    }

    /**
     * Methode permetant de creer un Graphe
     */
    public GrapheListe creerGraphe() {
        // on tire 2 sommets aleatoires et on cree un arc
        Noeud n;
        GrapheListe gl = new GrapheListe();

        // on ajoute tout les noeuds
        for (int i = 0; i < nbNoeuds; i++) {
            n = new Noeud(Integer.toString(i));
            gl.listeNoeuds().add(n.getNom());
            gl.ajouterNoeud(Integer.toString(i));
        }

        int nbArc = alea(nbNoeuds) + nbNoeuds;
        int depart = alea(nbNoeuds);
        int arrivee = alea(nbNoeuds);

        for (int i = 0; i < nbArc; i++) {
            // on regarde qu aucun arc arrive sur le depart et pars de l arriver
            while (this.depart.compareTo(Integer.toString(arrivee)) ==0 || this.arrivee.compareTo(Integer.toString(depart)) ==0) {
                depart = alea(nbNoeuds);
                arrivee = alea(nbNoeuds);
            }
            gl.ajouterArc(Integer.toString(depart), Integer.toString(arrivee), alea(nbNoeuds));
            depart = alea(nbNoeuds);
            arrivee = alea(nbNoeuds);

        }
        return gl;
    }


}
