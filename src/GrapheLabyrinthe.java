import java.util.ArrayList;
import java.util.List;

public class GrapheLabyrinthe implements Graphe{

    public Labyrinthe laby;

    /**
     *
     * @param laby
     */
    public GrapheLabyrinthe(Labyrinthe laby){
        this.laby = laby;
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> listeNoeuds() {
        //ajoute tout les noeuds
        // ce sont toutes les cases vides / sans murs
        ArrayList<String> retour = new ArrayList<String>();
        for(int ligne = 0 ; ligne <this.laby.getLength();ligne++) {
            for (int colonne = 0; colonne < this.laby.getLengthY(); colonne++) {
                if(!this.laby.getMur(ligne,colonne)){
                    retour.add("<("+ligne+","+colonne+")>");
                }
            }
        }
        return retour;
    }

    /**
     *
     * @param n le nom du noeud
     * @return
     */
    @Override
    public List<Arc> suivants(String n) {
        //on regarde les suivants d un sommet et on cree un arc entre
        String[] coord= n.split(",");
        int x =  Integer.parseInt(coord[0].substring(2)) ;
        int y =  Integer.parseInt(coord[1].substring(0,1)) ;

        int[] haut = this.laby.deplacerPerso(x, y, Labyrinthe.HAUT);
        int[] bas = this.laby.deplacerPerso(x, y, Labyrinthe.BAS);
        int[] droite = this.laby.deplacerPerso(x, y, Labyrinthe.DROITE);
        int[] gauche = this.laby.deplacerPerso(x, y, Labyrinthe.GAUCHE);

        Arc arc1 = new Arc("<("+haut[0]+","+haut[1]+")>",1);
        Arc arc2 = new Arc("<("+bas[0]+","+bas[1]+")>",1);
        Arc arc3 = new Arc("<("+droite[0]+","+droite[1]+")>",1);
        Arc arc4 = new Arc("<("+gauche[0]+","+gauche[1]+")>",1);

        ArrayList<Arc> retour = new ArrayList<Arc>();

        retour.add(arc1);
        retour.add(arc2);
        retour.add(arc3);
        retour.add(arc4);

        return retour;

    }
}
