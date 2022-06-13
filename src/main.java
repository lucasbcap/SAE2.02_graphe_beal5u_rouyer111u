import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        GrapheListe grapheListe = new GrapheListe("Graphe/GrapheBoucle.txt");

        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(grapheListe,"A");

        System.out.println(v);
    }
}
