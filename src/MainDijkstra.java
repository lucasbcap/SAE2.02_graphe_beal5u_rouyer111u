import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {

        GrapheListe grapheListe = new GrapheListe("Graphe/GrapheExemple1.txt");


        Valeur v = grapheListe.resoudre(new Dijkstra(),"A");

        System.out.println(v);

    }
}