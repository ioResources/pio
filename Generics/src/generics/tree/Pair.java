package generics.tree;

/**
 * Klasa reprezentująca parę (np. krawędzie grafów, dzieci węzłów drzew, współrzędne itp.).
 * Założenie: w parze można zapisać dowolne obiekty (oba tej samej klasy).
 * 
 * @author Olek Lamża
 * @param <T> typ elementu pary
 */
public class Pair<T> {
    // członkowie pary
    private T first;
    private T second;
    
    /*
     * Konstruktory
     */
    public Pair() {}
    
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    /*
     * Settery i gettery
     */
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
    
    /*
     * toString()
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
