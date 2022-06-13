import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainDijkstra {

    public static void main(String[] args) throws IOException {


        String[] tabNomFichier = {"Graphe/Graphe1.txt","Graphe/Graphe11.txt","Graphe/Graphe21.txt",
                "Graphe/Graphe31.txt","Graphe/Graphe51.txt","Graphe/Graphe101.txt"};

        BufferedWriter bw = new BufferedWriter(new FileWriter("resultats/Dijkstra.txt"));

        for(int i=0 ; i < tabNomFichier.length;i++){

            GrapheListe grapheListe = new GrapheListe(tabNomFichier[i]);
            long debut = System.currentTimeMillis();
            Valeur v = grapheListe.resoudre(new Dijkstra(),"1");
            long fin = System.currentTimeMillis();
            bw.write (Double.toString((fin-debut)/1000.0));
            bw.newLine();
        }
        bw.close();
    }
}