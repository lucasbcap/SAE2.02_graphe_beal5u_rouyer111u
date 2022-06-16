import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * Generer un graphe a partir d un labyrinthe
     * @return un graphe generer
     */
    public Graphe genererGraphe (){
        GrapheListe graphe =  new GrapheListe();
        for(int ligne = 0 ; ligne <this.getLength();ligne++){
            for(int colonne = 0 ; colonne <this.getLengthY();colonne++) {
                if (!this.getMur(ligne, colonne)) {
                    int[] haut = this.deplacerPerso(ligne, colonne, HAUT);
                    int[] bas = this.deplacerPerso(ligne, colonne, BAS);
                    int[] droite = this.deplacerPerso(ligne, colonne, DROITE);
                    int[] gauche = this.deplacerPerso(ligne, colonne, GAUCHE);

                    if(haut[0]!=ligne || haut[1]!=colonne) {
                        graphe.ajouterArc("<(" + ligne + "," + colonne + ")>", "<(" + haut[0] + "," + haut[1] + ")>", 1);
                    }
                    if(bas[0]!=ligne || bas[1]!=colonne) {
                        graphe.ajouterArc("<(" + ligne + "," + colonne + ")>", "<(" + bas[0] + "," + bas[1] + ")>", 1);
                    }
                    if(droite[0]!=ligne || droite[1]!=colonne) {
                        graphe.ajouterArc("<(" + ligne + "," + colonne + ")>", "<(" + droite[0] + "," + droite[1] + ")>", 1);
                    }
                    if(gauche[0]!=ligne || gauche[1]!=colonne) {
                        graphe.ajouterArc("<(" + ligne + "," + colonne + ")>", "<(" + gauche[0] + "," + gauche[1] + ")>", 1);
                    }

                }
            }
        }
        return  graphe;
    }

    /**
     * Generer un graphe a partir d un labyrinthe glace
     * @return un graphe generer
     */
    public Graphe genererGrapheGlace (String depart){
        GrapheListe graphe =  new GrapheListe();
        String[] coord= depart.split(",");
        int x =  Integer.parseInt(coord[0].substring(2)) ;
        int y =  Integer.parseInt(coord[1].substring(0,1)) ;

        boolean trouver = false;

        ArrayList<int[]> sommetImportant = new ArrayList<>();
        ArrayList<int[]> sommetPasser = new ArrayList<>();
        sommetImportant.add(new int[]{x,y});
        sommetPasser.add(new int[]{x,y});

        while (!sommetImportant.isEmpty()){
            ArrayList<int[]> haut = this.deplacerPersoGlace(sommetImportant.get(0)[0], sommetImportant.get(0)[1], HAUT);
            ArrayList<int[]> bas = this.deplacerPersoGlace(sommetImportant.get(0)[0], sommetImportant.get(0)[1], BAS);
            ArrayList<int[]> droite = this.deplacerPersoGlace(sommetImportant.get(0)[0], sommetImportant.get(0)[1], DROITE);
            ArrayList<int[]> gauche = this.deplacerPersoGlace(sommetImportant.get(0)[0], sommetImportant.get(0)[1], GAUCHE);


            if(haut.size()!=1) {
                trouver = false;
                for (int i = 1; i < haut.size(); i++) {
                    if(i==1){
                        graphe.ajouterArc("<(" + haut.get(i-1)[0] + "," + haut.get(i-1)[1] + ")>", "<(" + haut.get(i)[0] + "," + haut.get(i)[1] + ")>", 1);

                    }
                    else{
                        graphe.ajouterArc("<(" + haut.get(i-1)[0] + "," + haut.get(i-1)[1] + ")>", "<(" + haut.get(i)[0] + "," + haut.get(i)[1] + ")>", 0);
                    }
                }

                int i =0;
                while(!trouver && i<sommetPasser.size()){
                    if(haut.get(haut.size()-1)[0] == sommetPasser.get(i)[0] && haut.get(haut.size()-1)[1] == sommetPasser.get(i)[1]){
                        trouver = true;
                    }
                    i++;
                }

                if(!trouver){
                    sommetPasser.add(new int[]{haut.get(haut.size()-1)[0],haut.get(haut.size()-1)[1]});
                    sommetImportant.add(new int[]{haut.get(haut.size()-1)[0],haut.get(haut.size()-1)[1]});
                }
            }



            if(bas.size()!=1) {
                trouver = false;
                for (int i = 1; i < bas.size(); i++) {
                    if(i==1){
                        graphe.ajouterArc("<(" + bas.get(i-1)[0] + "," + bas.get(i-1)[1] + ")>", "<(" + bas.get(i)[0] + "," + bas.get(i)[1] + ")>", 1);
                    }
                    else{
                        graphe.ajouterArc("<(" + bas.get(i-1)[0] + "," + bas.get(i-1)[1] + ")>", "<(" + bas.get(i)[0] + "," + bas.get(i)[1] + ")>", 0);
                    }
                }
                int i =0;
                while(!trouver && i<sommetPasser.size()){
                    if(bas.get(bas.size()-1)[0] == sommetPasser.get(i)[0] && bas.get(bas.size()-1)[1] == sommetPasser.get(i)[1]){
                        trouver = true;
                    }
                    i++;
                }

                if(!trouver){
                    sommetPasser.add(new int[]{bas.get(bas.size()-1)[0],bas.get(bas.size()-1)[1]});
                    sommetImportant.add(new int[]{bas.get(bas.size()-1)[0],bas.get(bas.size()-1)[1]});
                }
            }



            if(droite.size()!=1) {
                trouver = false;
                for (int i = 1; i < droite.size(); i++) {
                    if(i==1){
                        graphe.ajouterArc("<(" + droite.get(i-1)[0] + "," + droite.get(i-1)[1] + ")>", "<(" + droite.get(i)[0] + "," + droite.get(i)[1] + ")>", 1);
                    }
                    else{
                        graphe.ajouterArc("<(" + droite.get(i-1)[0] + "," + droite.get(i-1)[1] + ")>", "<(" + droite.get(i)[0] + "," + droite.get(i)[1] + ")>", 0);
                    }
                }
                int i =0;
                while(!trouver && i<sommetPasser.size()){
                    if(droite.get(droite.size()-1)[0] == sommetPasser.get(i)[0] && droite.get(droite.size()-1)[1] == sommetPasser.get(i)[1]){
                        trouver = true;
                    }
                    i++;
                }

                if(!trouver){
                    sommetPasser.add(new int[]{droite.get(droite.size()-1)[0],droite.get(droite.size()-1)[1]});
                    sommetImportant.add(new int[]{droite.get(droite.size()-1)[0],droite.get(droite.size()-1)[1]});
                }
            }


            if(gauche.size()!=1) {
                trouver = false;
                for (int i = 1; i < gauche.size(); i++) {
                    if(i==1){
                        graphe.ajouterArc("<(" + gauche.get(i-1)[0] + "," + gauche.get(i-1)[1] + ")>", "<(" + gauche.get(i)[0] + "," + gauche.get(i)[1] + ")>", 1);
                    }
                    else{
                        graphe.ajouterArc("<(" + gauche.get(i-1)[0] + "," + gauche.get(i-1)[1] + ")>", "<(" + gauche.get(i)[0] + "," + gauche.get(i)[1] + ")>", 0);
                    }
                }
                int i =0;
                while(!trouver && i<sommetPasser.size()){
                    if(gauche.get(gauche.size()-1)[0] == sommetPasser.get(i)[0] && gauche.get(gauche.size()-1)[1] == sommetPasser.get(i)[1]){
                        trouver = true;
                    }
                    i++;
                }

                if(!trouver){
                    sommetPasser.add(new int[]{gauche.get(gauche.size()-1)[0],gauche.get(gauche.size()-1)[1]});
                    sommetImportant.add(new int[]{gauche.get(gauche.size()-1)[0],gauche.get(gauche.size()-1)[1]});
                }
            }
            sommetImportant.remove(0);

        }


        return  graphe;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public int[] deplacerPerso(int i, int j,String action) {
        // case courante
        int[] courante = {i,j};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            return suivante;
        }
        return courante;
    }


    /**
     * deplace le personnage en fonction de l'action sur de la glace.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public ArrayList<int[]> deplacerPersoGlace(int i, int j, String action) {
        // case courante
        int[] courante = {i,j};
        ArrayList<int[]> tab = new ArrayList<int[]>();

        boolean fin = false;
        // si c'est pas un mur, on effectue le deplacement
        while(!fin) {
            tab.add(new int[]{courante[0],courante[1]});
            int[] suivante = getSuivant(courante[0], courante[1], action);
            if (!this.murs[suivante[0]][suivante[1]]) {
                courante[0] = suivante[0];
                courante[1] = suivante[1];
            }
            else{
                fin = true;
            }
        }
        return tab;
    }

    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }
}
