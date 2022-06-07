import java.util.ArrayList;
import java.util.List;

/**
 * Classe Noeud
 */
public class Noeud {

    //Variables

    private String nom;
    private List<Arc> adj;

    /**
     * Constructeur de noeud avec un nom en parametre
     * @param nom nom du noeud
     */
    public Noeud (String nom){
        this.nom = nom;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Deux noeud sont egaux si ils ont le meme nom
     * @param o l objet noeud
     * @return
     */
    public boolean equals(Object o){
        Noeud n = (Noeud)o;
        return this.nom.compareTo(n.getNom())==0;
    }

    /**
     * permet d ajouter un arc a la liste adj
     * @param destination prochain noeud
     * @param cout la valeur de l arc
     */
    public void ajouterArc(String destination, double cout){
        Arc a = new Arc(destination,cout);
        this.adj.add(a);
    }

    /////////////////////////
    //
    // toString / toGraphViz
    //
    /////////////////////////

    /**
     * le toString des Noeuds
     * @return nomDuNoeud -> list des Arcs
     */
    public String toString(){
        String chaine = this.nom+" -> ";

        for(int i =0 ; i<this.adj.size();i++){
            chaine += this.adj.get(i).toString()+" ";
        }
        return chaine;
    }

    /**
     * le toString des Noeuds
     * @return nomDuNoeud -> list des Arcs
     */
    public String toGraphViz(){
        String chaine ="";

        for(int i =0 ; i<this.adj.size();i++){
            chaine += this.nom+" -> ";
            chaine += this.adj.get(i).toGraphViz()+"\n";
        }
        return chaine;
    }

    /////////////////////////
    //
    // GETTER
    //
    /////////////////////////


    /**
     * getter pour avoir le nom
     * @return le nom du noeud
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter pour la liste des Arcs
     * @return la liste des Arcs
     */
    public List<Arc> getAdj() {
        return adj;
    }
}
