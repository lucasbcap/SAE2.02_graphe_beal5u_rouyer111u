public class MainCreationGraphe {

    public static void main(String[] args) {

        GenererGraphe gg = new GenererGraphe(50, "0", "5");
        GrapheListe gl = gg.creerGraphe();
        System.out.println(gl.toGraphViz());
    }
}
