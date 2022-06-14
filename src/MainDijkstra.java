import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        //Question 20
        GrapheListe grapheListe = new GrapheListe("Graphe/GrapheExemple1.txt");
        Valeur v = grapheListe.resoudre(new Dijkstra(),"A");

        System.out.println("Calcule de chemin le plus court avec le graphe GrapheExemple1 ");
        System.out.println(v);
        System.out.println("Le chemin de A à E");
        System.out.println(v.calculerChemin("E"));
    }
}