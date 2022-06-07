import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    public BellmanFord() {
    }

    public Valeur resoudre(Graphe g, String depart) {

        Valeur v = this.initialisation(g, depart);

        System.out.println(this.listAntecedentSommet(g, "D"));

        boolean finis = false;
        int iteration = 0;

        while (!finis && iteration < g.listeNoeuds().size()) {
            // creation des AL(X) ancienne valeur
            //v.getValeur(g.listeNoeuds().get(X)) = L(X)
            ArrayList<Integer> pointfixe = new ArrayList<>();
            for (int sommet = 0; sommet < g.listeNoeuds().size(); sommet++) {
                pointfixe.add((int) v.getValeur(g.listeNoeuds().get(sommet)));
            }


            // sommet = X
            for (int sommet = 0; sommet < g.listeNoeuds().size(); sommet++) {
                ArrayList<String> listParents = this.listAntecedentSommet(g, g.listeNoeuds().get(sommet));
                if(listParents.size()!=0) {
                    int min = (int) v.getValeur(listParents.get(0)) + this.valeurArc(v, g, g.listeNoeuds().get(sommet), listParents.get(0));
                    if(min<0){
                        min = Integer.MAX_VALUE;
                    }
                    int placeP = 0;

                    for (int parent = 0; parent < listParents.size(); parent++) {

                        int valeur = (int) v.getValeur(listParents.get(parent)) + this.valeurArc(v, g, g.listeNoeuds().get(sommet), listParents.get(parent));
                        if(valeur>0) {
                            if (min > valeur) {
                                min = (int) v.getValeur(listParents.get(parent)) + this.valeurArc(v, g, g.listeNoeuds().get(sommet), listParents.get(parent));
                                placeP = parent;
                            }
                        }
                    }
                    v.setValeur(g.listeNoeuds().get(sommet), min);
                    v.setParent(g.listeNoeuds().get(sommet), listParents.get(placeP));
                }
            }


            int i = 0;
            boolean trouverPointfixe = true;
            while (i < pointfixe.size() && trouverPointfixe) {
                if (v.getValeur(g.listeNoeuds().get(i)) != pointfixe.get(i)) {

                    trouverPointfixe = false;
                }
                i++;
            }

            if (trouverPointfixe) {
                finis = true;
            }
            iteration++;
        }
        return v;
    }


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


    public ArrayList<String> listAntecedentSommet(Graphe g, String sommet) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            int j = 0;
            boolean trouver = false;
            while (j < g.suivants(g.listeNoeuds().get(i)).size() && !trouver) {

                if (g.suivants(g.listeNoeuds().get(i)).get(j).getDest().compareTo(sommet) == 0) {
                    trouver = true;
                }
                j++;
            }
            if (trouver) {
                list.add(g.listeNoeuds().get(i));
            }
        }
        return list;
    }

    public int valeurArc(Valeur v , Graphe g,String arriver,String depart){

        List<Arc> listArcs=  g.suivants(depart);

        int i = 0;
        boolean trouver = false;
        while(!trouver && i<listArcs.size()){
            if(listArcs.get(i).getDest().compareTo(arriver)==0){
                trouver = true;
            }
            i++;
        }

        return (int)listArcs.get(i-1).getCout();
    }

}

