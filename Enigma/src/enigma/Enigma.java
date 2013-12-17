package enigma;

import enigma.cipher.CipherSubst;
import enigma.cipher.core.Cipher;


/**
 *
 * @author Olek Lamza
 */
public class Enigma {

    public static void main(String[] args) {
        Cipher cipher = new CipherSubst();
        System.out.println("key: " + cipher.getKey());        
        
        String plainText = "Tajna wiadomosc";
        
        System.out.println("plain:     " + plainText);       
        
        String encText = cipher.encrypt(plainText);
        System.out.println("encrypted: " + encText);
        
        String decText = cipher.decrypt(encText);
        System.out.println("decrypted: " + decText);
        
    }
}
