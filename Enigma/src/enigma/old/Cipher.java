package enigma.old;

/**
 * Klasa szyfrująca i deszyfrująca tekst metodą Cezara
 * 
 * @author Olek Lamza
 */
public class Cipher {
    private int offset = 1;
    
    /*
     * Konstruktory
     */
    public Cipher() {}
    
    public Cipher(int offset) {
        this.offset = offset;
    }

    /*
     * Metoda szyfrująca
     */
    public String encrypt(String text) {
        StringBuilder encText = new StringBuilder();
        
        for (int i=0; i<text.length(); i++) {
            int c = text.charAt(i);

            c = c + offset;
            
            encText.append((char)c);
        }
        
        return encText.toString();
    }
    
    /*
     * Metoda deszyfrująca
     */
    public String decrypt(String text) {
        StringBuilder decText = new StringBuilder();
        
        for (int i=0; i<text.length(); i++) {
            int c = text.charAt(i);
            
            c = c - offset;
            
            decText.append((char)c);
        }
        
        return decText.toString();    
    }
}
