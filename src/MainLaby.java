import java.io.IOException;
import java.net.http.HttpRequest;

public class MainLaby {

    public static void main(String[] args) throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");

        GrapheListe gl = (GrapheListe) laby.genererGraphe();

        Valeur v = gl.resoudre(new Dijkstra(),"<(1,1)>");
        System.out.println(v);


        GrapheLabyrinthe Glaby = new GrapheLabyrinthe(laby);
        Dijkstra dj =  new Dijkstra();
        Valeur v2 = dj.resoudre(Glaby,"<(1,1)>");
        System.out.println("= ?");
        System.out.println(v2);

        GrapheListe glg = (GrapheListe) laby.genererGrapheGlace("<(1,1)>");
        System.out.println(glg.toGraphViz());




    }
}
