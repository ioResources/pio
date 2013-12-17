package generics.tree;

/**
 * Klasa reprezentująca węzeł drzewa binarnego.
 * Węzeł przechowuje wartość (value) oraz parę potomków (children).
 * 
 * @author Olek Lamża
 * @param <T> typ wartości przechowywanej przez węzeł
 */
public class Node<T> {
    // wartość przechowywana w węźle
    T value;
    // para potomków
    Pair<Node> children = new Pair<>();
 
    /*
     * Konstruktory
     */
    public Node() {
    }
    
    public Node(T value) {
        this.value = value;
    }
    
    public Node(T value, Pair<Node> children) {
        this.value = value;
        this.children = children;
    }
    
    /*
     * Setter i getter wartości
     */
    public void setValue(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    /*
     * Metody umożliwiające dodawanie potomków
     */
    public void setLeftChild(Node node) {
        children.setFirst(node);
    }
    
    public void setRightChild(Node node) {
        children.setSecond(node);
    }
    
    public void setChildren(Pair<Node> children) {
        this.children = children;
    }
    
    /*
     * Metoda wyszukująca wartość (w węźle i jego potomkach)
     */
    public Node<T> find(T value) {
        Node<T> node = null;
        if (value == this.value) {
            node = this;
        } else {
            if (children.getFirst() != null) {
                node = children.getFirst().find(value);
            }
            if (node == null && children.getSecond() != null) {
                node = children.getSecond().find(value);
            }
            
            
            
//            if (children.getFirst() != null && children.getFirst().find(value) != null) {
//                node = children.getFirst().find(value);
//            } else if (children.getSecond() != null && children.getSecond().find(value) != null) {
//                node = children.getSecond().find(value);
//            }            
        }
        return node;
    }
    
    /*
     * toString()
     */
    @Override
    public String toString() {
        return "#"+value+"( " +children.getFirst()+" , "+children.getSecond()+" )";
    }
}
