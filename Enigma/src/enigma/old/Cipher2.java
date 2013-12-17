
package enigma.old;

/**
 * Udoskonalona klasa szyfrująca i deszyfrująca szyfrem Cezara
 * 
 * @author Olek Lamza
 */
public class Cipher2 {
    private int offset = 1;
    
    /*
     * Konstruktory
     */
    public Cipher2() {}
    
    public Cipher2(int offset) {
        this.offset = offset;
    }
    
    /**
     * Metoda szyfrująca
     * 
     * @param text tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */    
    public String encrypt(String text) {
        /*
         * Rozwiązanie A: zlecamy wykonanie zadania szyfrowania prywatnej
         * metodzie doJob(). W wywołaniu przekazujemy obiekt (prywatnej
         * klasy Encryptor) realizujący jednostkową operację szyfrowania
         * pojedynczego znaku.       
         */
        return doJob(text, new CharProcEnc());
        
        /*
         * Alternatywne rozwiązanie - patrz opis metody decrypt()
         */
//        return doJob(text, new CharProc() {
//            public int proc(int in, int offset) {
//                return in + offset;
//            }        
//        });         
    }
    
    /**
     * Metoda deszyfrująca
     * 
     * @param text tekst do odszyfrowania
     * @return odszyfrowany tekst
     */    
    public String decrypt(String text) {
        /*
         * Patrz opis metody encrypt().
         */
//        return doJob(text, new Decryptor());
        
        /*
         * Rozwiązanie B: podobnie jak w rozwiązaniu A, ale zamiast definiowania
         * klasy Encryptor i Decryptor korzystamy z klasy anonimowej.
         */         
        return doJob(text, new CharProc() {
            public int process(int c, int offset) {
                return c - offset;
            }
        });
    }
    
    
    /**
     * Metoda wykonująca zadanie szyfrowania. W pętli przechodzimy znak po znaku.
     * Przetworzenie pojedynczego znaku zlecamy obiektowi cp klasy implementującej
     * interfejs CharProc.
     */    
    private String doJob(String text, CharProc cp) {
        StringBuilder encText = new StringBuilder();
        
        for (int i=0; i<text.length(); i++) {
            int c = text.charAt(i);

            //c = c + offset;
            c = cp.process(c, offset);
            
            encText.append((char)c);
        }
        
        return encText.toString();
    }
    
    /**
     * Interfejs CharProc zawiera tylko jedną metodę - process().
     * Dzięki niemu możemy być pewni, że na obiekcie przekazanym metodzie doJob()
     * można wywołać metodę process().
     */
    interface CharProc {
        public int process(int c, int offset);
    }

    
    /**
     * Klasa CharProcEnc implementuje interfejs CharProc.
     * Zawierająca metodę przetwarzającą pojedynczy znak - process().
     * Odpowiada za zaszyfrowanie znaku.
     */    
    class CharProcEnc implements CharProc {
        public int process(int c, int offset) {
            return c + offset;
        }
    }
  
    /*
     * Klasa CharProcDec odpowiada za odszyfrowanie znaku (patrz klasa CharProcEnc).
     */
//    class CharProcDec implements CharProc {
//        public int process(int c, int offset) {
//            return c - offset;
//        }
//    }
    
}
