import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        GrapheListe grapheListe = new GrapheListe();

        grapheListe.ajouterArc("A","B",12);
        grapheListe.ajouterArc("A","D",87);
        grapheListe.ajouterArc("C","A",19);
        grapheListe.ajouterArc("D","B",23);
        grapheListe.ajouterArc("D","C",10);
        grapheListe.ajouterArc("E","D",43);
        grapheListe.trierList();




        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(grapheListe,"E");


        System.out.println(v);

        System.out.println("FIN");

    }
}
