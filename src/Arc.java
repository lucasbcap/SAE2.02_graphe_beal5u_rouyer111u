/**
 * Classe Arc
 */
public class Arc {

    private String dest;
    private double cout;

    /**
     * Constructeur de la classe Arc
     * @param d le nom d'un noeud
     * @param c le poid d'un noeud
     */
    public Arc(String d, double c){
        this.dest = d;
        this.cout = c;
    }

    /////////////////////////
    //
    // toString / toGraphViz
    //
    /////////////////////////

    /**
     * Methode toString de arc
     * @return dest(valeur)
     */
    public String toString(){
        return this.dest+"("+(int)this.cout+")";
    }

    /**
     * Methode toGraphviz de arc
     * @return dest(valeur)
     */
    public String toGraphViz(){
        return this.dest+" [label = "+(int)this.cout+"]";
    }


    /////////////////////////
    //
    // GETTER
    //
    /////////////////////////

    /**
     * getter pour la valeur de l arc
     * @return la valeur de l arc
     */
    public double getCout() {
        return cout;
    }

    /**
     * getter pour le noeud suivant
     * @return le noeud suivant
     */
    public String getDest() {
        return dest;
    }
}
