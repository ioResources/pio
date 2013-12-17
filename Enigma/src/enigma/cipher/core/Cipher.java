package enigma.cipher.core;

/**
 * Klasa bazowa dla wszystkich klas z implementacjami metod szyfrowania "znak po znaku"
 *
 * @author Olek Lamza
 */
abstract public class Cipher<T> {
    // Klucz szyfrujący
    protected T key;
 
    /*
     * Publiczny interfejs klasy
     */
    abstract public String encrypt(String text);
    abstract public String decrypt(String text);

    public T getKey() {
        return key;
    }
       
    /*
     * Metoda przetwarzająca cały łańcuch
     */
    protected String doJob(String text, CharProc cp) {
        StringBuilder encText = new StringBuilder();
        
        for (int i=0; i<text.length(); i++) {
            int c = text.charAt(i);

            c = cp.process(c, key);
            
            encText.append((char)c);
        }
        
        return encText.toString();
    }
    
}
