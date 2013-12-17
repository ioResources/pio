/**
 * Klasa szyfrująca i deszyfrująca metodą z tabelą podstawień.
 */
package enigma.old;

import java.util.Random;

/**
 *
 * @author Olek Lamza
 */
public class Cipher3 {
    // tabela podstawień (klucz)
    private String key = "";
    
    /*
     * Konstruktory
     */
    public Cipher3() {
        
    }
    
    public Cipher3(String key) {
        this.key = key;
    }
    
    /*
     * Metoda generująca i zwracająca klucz szyfrujący.
     */
    public String generateKey() {
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
    
    /*
     * Metoda zwracająca klucz szyfrujący.
     */
    public String getKey() {
        return key;
    }
    
    //*************************************************************************
    
    /**
     * Metoda szyfrująca
     * 
     * @param text tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */    
    public String encrypt(String text) {
        return doJob(text, new CharProc() {
            public int process(int c, String key) {
                if (c < ' ' || c > 'z') {
                    return '~';
                } else {
                    return key.charAt(c-' ');
                }
            }
        });
    }    
    
    
    /**
     * Metoda deszyfrująca
     * 
     * @param text tekst do odszyfrowania
     * @return odszyfrowany tekst
     */    
    public String decrypt(String text) {
        return doJob(text, new CharProc() {
            public int process(int c, String key) {
                if (c == '~') {
                    return '~';
                } else {
                    return key.indexOf(c)+' ';
                }
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

            c = cp.process(c, key);
            
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
        public int process(int c, String key);
    }
    
}
