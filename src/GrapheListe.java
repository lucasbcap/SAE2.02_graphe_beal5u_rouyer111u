import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    /**
     * Constructeur de la classe GrapheListe
     */
    public GrapheListe() {
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    public GrapheListe (String nomFichier) throws IOException{
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
        BufferedReader bf = new BufferedReader(new FileReader(nomFichier));
        String line = bf.readLine();
        String depart;
        String arrivee;
        int cout;
        while (line != null){
            String[] tabLine = line.split("\t");
            depart = tabLine[0];
            arrivee = tabLine[1];
            cout = Integer.parseInt(tabLine[2]);
            this.ajouterArc(depart, arrivee, cout);
            line = bf.readLine();

        }

        bf.close();
    }


    /**
     * Cree une liste de String qui est la liste des noms des noeuds
     *
     * @return tous les noeuds du graphe
     */
    @Override
    public List<String> listeNoeuds() {
        for (int i = 0; i < this.ensNoeuds.size(); i++) {
            if (!this.ensNom.contains(this.ensNoeuds.get(i).getNom())) {
                this.ensNom.add(this.ensNoeuds.get(i).getNom());
            }
        }
        return this.ensNom;
    }

    public Valeur resoudre(Algorithme algo,String depart){
        Valeur v = algo.resoudre(this,depart);
        return v;
    }

    /**
     * Methode permettant de connaitre les acrs suivant un noeud
     *
     * @param n le nom du noeud
     * @return la liste d'arc
     */
    @Override
    public List<Arc> suivants(String n) {
        if (this.ensNom.contains(n)) {
            boolean suivant = false;
            int i = 0;
            while (!suivant) {
                if (this.ensNoeuds.get(i).getNom().compareTo(n) == 0) {
                    suivant = true;
                }
                i++;
            }
            return this.ensNoeuds.get(i - 1).getAdj();
        } else {
            return null;
        }
    }

    /**
     * permet d ajouter un arc et c est 2 noeuds a un graphe
     * Si les noeuds n existe pas on les creent
     * On pense bien a ajouter tout ceci dans la liste ensNom
     *
     * @param depart      nom du noeud de depart
     * @param destination nom du noeud d arriver
     * @param cout        valeur de l arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        this.trierList();
        if (this.ensNom.contains(depart)) {
            boolean suivant = false;
            int i = 0;
            while (!suivant) {
                if (this.ensNoeuds.get(i).getNom().compareTo(depart) == 0) {
                    suivant = true;
                }
                i++;
            }
            this.ensNoeuds.get(i - 1).ajouterArc(destination, cout);
        } else {
            this.ensNoeuds.add(new Noeud(depart));
            this.ensNoeuds.get(this.ensNoeuds.size()-1).ajouterArc(destination, cout);
            this.ensNom.add(depart);
        }

        if (!this.ensNom.contains(destination)) {
            this.ensNoeuds.add(new Noeud(destination));
            this.ensNom.add(destination);
        }
    }

    /**
     * Methode pour ajouter un noeud
     * @param nom le nom du noeud
     */
    public void ajouterNoeud(String nom){
        this.ensNoeuds.add(new Noeud(nom));
    }

    /**
     * permet de trier la liste de noeud dans l ordre alphabetique
     * donc A B C D E ...
     */
    public void trierList(){
        ArrayList<Noeud> newTab = new ArrayList<Noeud>();
        int lenght = this.ensNoeuds.size();
        for(int j =0 ;j<lenght;j++) {
            String min = this.ensNoeuds.get(0).getNom();
            int index = 0;
            for (int i = 0; i < this.ensNoeuds.size(); i++) {
                if (min.compareTo(this.ensNoeuds.get(i).getNom()) > 0) {
                    min = this.ensNoeuds.get(i).getNom();
                    index = i;
                }
            }
            newTab.add(this.ensNoeuds.get(index));
            this.ensNoeuds.remove(index);
        }
        this.ensNoeuds = newTab;
    }

    /////////////////////////
    //
    // toString / toGraphViz
    //
    /////////////////////////

    /**
     * toString de graphliste
     * @return la liste des noeuds et de leurs Arcs
     */
    public String toString(){
        String chaine = "";
        for(int i = 0; i<this.ensNoeuds.size();i++){
            chaine += this.ensNoeuds.get(i).toString()+"\n";
        }
        return chaine;
    }

    /**
     * toGraphViz de graphliste
     * @return la liste des noeuds et de leurs Arcs
     */
    public String toGraphViz(){
        String chaine = "digraph{\n";
        for(int i = 0; i<this.ensNoeuds.size();i++){
            chaine += this.ensNoeuds.get(i).toGraphViz();
        }
        chaine+="}";
        return chaine;
    }

    public void genererGraphe(String nom) throws IOException {
        BufferedWriter fich = new BufferedWriter(new FileWriter("Graphe/"+nom));
        String chaine = "digraph{\n";
        fich.write(chaine);
        fich.newLine();
        for(int i = 0; i<this.ensNoeuds.size();i++){
            chaine = this.ensNoeuds.get(i).toGraphViz();
            fich.write(chaine);
            fich.newLine();
        }
        chaine="}";
        fich.newLine();
        fich.write(chaine);
        fich.close();
    }

    /////////////////////////
    //
    // GETTER
    //
    /////////////////////////

    /**
     * getter pour la liste de noeuds
     * @return la liste de noeuds
     */
    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    /**
     * getter pour la liste des noms des noeuds
     * @return la liste des noms des noeuds
     */
    public List<String> getEnsNom() {
        return ensNom;
    }
}



