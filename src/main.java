import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {


        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A","B",12);
        graphe.ajouterArc("C","A",19);
        graphe.ajouterArc("D","C",10);
        graphe.ajouterArc("A","D",87);
        graphe.ajouterArc("D","B",23);
        graphe.ajouterArc("B","E",11);
        graphe.ajouterArc("E","D",43);

        System.out.println(graphe.toGraphViz());



        //question 15
        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(graphe,"A");

        System.out.println(v);

    }
}
