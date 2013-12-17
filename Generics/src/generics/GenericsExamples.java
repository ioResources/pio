package generics;

import generics.tree.Node;
import generics.tree.Pair;

/**
 *
 * @author Olek Lamża
 */
public class GenericsExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        /* 
         * Testy klasy Pair
         */
        System.out.println("----- Testy klasy Pair -----");
        // para stringów
        Pair<String> p1 = new Pair<>();
        p1.setFirst("jeden");
        p1.setSecond("dwa");
        System.out.println(p1);
        
        // para integerów
        Pair<Integer> p2 = new Pair<>();
        p2.setFirst(101);
        p2.setSecond(102);
        System.out.println(p2);
                
        // para par
        Pair<Pair> p3 = new Pair<>();
        p3.setFirst(p1);
        p3.setSecond(p2);
        System.out.println(p3);
        
        /*
         * Testy klasy Node
         */
        System.out.println("----- Testy klasy Node -----");
        
        // budujemy drzewo
        Node<Integer> tree = new Node<>(99);
        
        tree.setLeftChild( new Node<>(1) );
        
        Node<Integer> ch = new Node<>(2);
        ch.setChildren(new Pair<Node>( new Node<>(21), new Node<>(22) ));
        tree.setRightChild( ch );
        
        System.out.println(tree);
        
        /*
         * Na pierwszy rzut oka metoda find() działa dobrze. Ale to tylko złudzenie...
         */
        System.out.println( ".find(2): " + tree.find(2) );

        /*
         * Zobaczcie, co się dzieje tu:
         */
        System.out.println( ".find(new Integer(2)): " + tree.find( new Integer(2) ) );
        /*
         * Wynik powinien być taki sam jak wyżej, a nie jest - dostajemy null. Dlaczego?
         *
         * Zastanówcie się sami. Zwróćcie uwagę na sposób sprawdzania równości
         * w metodzie find() - co tam porównujemy: wartości czy obiekty (referencje)?
         * Spróbujcie to poprawić. Podpowiedź: zamiast operatora == trzeba zastosować
         * metodę compareTo(); żeby ją zastosować, trzeba trochę zmodyfikować kod,
         * ponieważ można ją wywołać tylko na obiektach klas implementujących
         * interfejs Comparable. Powodzenia :)
         */           
    }
    
    /*
     * Klasę ogólną możemy rozszerzyć do klasy o konkretnym typie.
     * Wtedy zamiast pisać Node<Integer> node = ..., możemy napisać NodeInt node = ...
     */
    static class NodeInt extends Node<Integer> {
        //...jedyne co trzeba zrobić, to uzupełnić konstruktury
        public NodeInt(Integer value) {
            super(value);
        }
    }
    
}
