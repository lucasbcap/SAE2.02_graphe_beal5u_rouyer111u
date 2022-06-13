import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainCreationGraphe {

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new FileWriter("resultats/BellmanFord.txt"));

        for(int i=10 ; i < 500;i++){

            GenererGraphe gg = new GenererGraphe(50, "0", "4");
            GrapheListe gl = gg.creerGraphe();
            BellmanFord bf = new BellmanFord();
            long debut = System.currentTimeMillis();
            Valeur v = bf.resoudre(gl,"0");
            long fin = System.currentTimeMillis();
            bw.write (Double.toString((fin-debut)/1000.0));
            bw.newLine();
        }
        bw.close();


        BufferedWriter bw2 = new BufferedWriter(new FileWriter("resultats/Dijkstra.txt"));

        for(int i=10 ; i < 500;i++){

            GenererGraphe gg = new GenererGraphe(50, "0", "4");
            GrapheListe gl = gg.creerGraphe();
            Dijkstra bf = new Dijkstra();
            long debut = System.currentTimeMillis();
            Valeur v = bf.resoudre(gl,"0");
            long fin = System.currentTimeMillis();
            bw2.write (Double.toString((fin-debut)/1000.0));
            bw2.newLine();
        }
        bw2.close();

    }
}
