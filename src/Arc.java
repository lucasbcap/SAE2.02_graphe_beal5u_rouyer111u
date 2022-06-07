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
    public Arc(String d, int c){
        this.dest = d;
        this.cout = c;
    }
}
