package TP2.fr.epu.bicycle;

/**
 * Classe utilisée dans GPS, représentant la position indiquée par un GPS.
 *
 * @author Michel K
 * @see GPS
 */
public class Position {

    /**
     * Position en abscisse
     */
    private int x;
    /**
     * Position en ordonnée
     */
    private int y;

    /**
     * Constante définissant la valeur en dessous de laquelle la différence entre deux points du même axe peuvent être
     * dits "confondus"
     */
    private static final double EPSILON = 0.001;

    /**
     * Constructeur de la classe Position, définissant les positions x et y.
     *
     * @param x la position en abscisse
     * @param y la position en ordonnée
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accesseur en lecture de la position en abscisse
     *
     * @return x, la position en abscisse
     */
    public int getX() {
        return this.x;
    }

    /**
     * Accesseur en lecture de la position en ordonnée
     *
     * @return y, la position en ordonnée
     */
    public int getY() {
        return this.y;
    }

    /**
     * accesseur en écriture de la position en abscisse, permet de fixer la position en abscisse
     *
     * @param x la position en abscisse à assigner.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * accesseur en écriture de la position en ordonnée, permet de fixer la position en ordonnée.
     *
     * @param y la position en ordonnée à assigner.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Permet de comparer deux positions et de savoir si vrai ou faux elles sont confondues (cf EPSILON).
     *
     * @param position la position à comparer avec la position courante.
     * @return Vrai si les deux positions sont confondues. False sinon.
     */
    public boolean isEquivalent(Position position) {
        int xEquiv = Math.abs(position.x - this.x);
        int yEquiv = Math.abs(position.y - this.y);
        return xEquiv <= EPSILON && yEquiv <= EPSILON;
    }

    /**
     * Méthode statique permettant de calculer la distance entre deux points.
     *
     * @param position Le premier point
     * @param pos      Le deuxième point
     * @return la distance entre le premier point et le deuxième point
     */
    public static double distanceBetweenTwoPositions(Position position, Position pos) {
        return Math.sqrt(Math.pow((double) position.x - pos.x, 2) + Math.pow((double) position.y - pos.y, 2));
    }
}
