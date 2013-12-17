package enigma.cipher;

import enigma.cipher.core.CharProc;
import enigma.cipher.core.Cipher;

/**
 * Klasa implementująca szyfrowanie metodą Cezara
 * 
 * @author Olek Lamza
 */
public class CipherCaesar extends Cipher<Integer> {

    /*
     * Konstruktory
     */
    public CipherCaesar() {
        key = new Integer(1);
    }
    
    public CipherCaesar(int key) {
        this.key = new Integer(key);
    }
    
    /*
     * Metoda szyfrująca
     */
    @Override
    public String encrypt(String text) {
        return doJob(text, new CharProc<Integer>() {

            @Override
            public int process(int c, Integer key) {
                return c + key.intValue();
            }
            
        });
    }

    /*
     * Metoda deszyfrująca
     */
    @Override
    public String decrypt(String text) {
        return doJob(text, new CharProc<Integer>() {

            @Override
            public int process(int c, Integer key) {
                return c - key.intValue();
            }
            
        });
    }
    
}
