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
     * Cree une liste de String qui est la liste des noms des noeuds
     * @return tous les noeuds du graphe
     */
    @Override
    public List<String> listeNoeuds() {
        for(int i=0;i<this.ensNoeuds.size(); i++){
            this.ensNom.add(this.ensNoeuds.get(i).getNom());
        }
        return this.ensNom;
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

    /**
     * permet d ajouter un arc et c est 2 noeuds a un graphe
     * Si les noeuds n existe pas on les creent
     * On pense bien a ajouter tout ceci dans la liste ensNom
     * @param depart nom du noeud de depart
     * @param destination nom du noeud d arriver
     * @param cout valeur de l arc
     */
    public void  ajouterArc(String depart,String destination,double cout){
        if(this.ensNom.contains(depart)){
            boolean suivant = false;
            int i =0;
            while(!suivant){
                if(this.ensNoeuds.get(i).getNom().compareTo(depart)==0){
                    suivant = false;
                }
                i++;
            }
            this.ensNoeuds.get(i-1).ajouterArc(destination,cout);
            if(!this.ensNom.contains(destination)){
                this.ensNom.add(destination);
            }
        }
        else{
            this.ensNoeuds.add(new Noeud(depart));
            this.ensNoeuds.get(this.ensNoeuds.size()).ajouterArc(destination,cout);
            this.ensNom.add(depart);
            this.ensNom.add(destination);
        }
    }


}
