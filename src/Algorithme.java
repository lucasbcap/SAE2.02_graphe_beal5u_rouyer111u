public interface Algorithme {

    /**
     * Methode des points fixes pour résoudre un graphe
     * @param g graphe a resoudre
     * @param depart sommet de depart
     * @return les valeurs minimal pour chaque sommet ainsi que son parent
     */
    public Valeur resoudre(Graphe g, String depart);

}
