package enigma.cipher;

import enigma.cipher.core.CharProc;
import enigma.cipher.core.Cipher;
import java.util.Random;

/**
 * Klasa implementująca szyfrowanie metodą podstawieniową
 * 
 * @author Olek Lamza
 */
public class CipherSubst extends Cipher<String> {

    /*
     * Konstruktory
     */
    public CipherSubst() {
        key = generateKey();
    }
    
    public CipherSubst(String key) {
        this.key = key;
    }

    /*
     * Metoda szyfrująca
     */
    @Override
    public String encrypt(String text) {
        return doJob(text, new CharProc<String>() {

            @Override
            public int process(int c, String key) {
                if (c < ' ' || c > 'z') {
                    return '~';
                } else {
                    return key.charAt(c-' ');
                }
            }
        
        });
    }

    /*
     * Metoda deszyfrująca
     */
    @Override
    public String decrypt(String text) {
        return doJob(text, new CharProc<String>() {

            @Override
            public int process(int c, String key) {
                if (c == '~') {
                    return '~';
                } else {
                    return key.indexOf(c)+' ';
                }
            }
        
        });        
    }
    
    /*
     * Metoda generująca i zwracająca klucz szyfrujący
     */
    public final String generateKey() {
        // dla znaków od spacji (32) do małego 'z' (122)
        char min = ' ';
        char max = 'z';
        int count = max-min+1;
        
        key = "";
        
        Random rand = new Random();
        
        for (int i=0; i<count; i++) {
            int d = 0;
            do {
                d = rand.nextInt(count);
            } while (key.indexOf((char)(min+d)) != -1);
            
            key += (char)(min+d);
        }
        
        return key;
    }
    
}
