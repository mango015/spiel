import java.lang.Object;
import java.util.Random;
public class Wuerfel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Random
     */
    public Wuerfel()
    {
        // Instanzvariable initialisieren
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int wurf()
    {
        // tragen Sie hier den Code ein
        Random r = new Random();
        
           int z= r.nextInt(6) + 1;
        
           return z;
        
    }
    public void fuenfzig()
    {
        // tragen Sie hier den Code ein
        Random r = new Random();
        for(int i =0; i<50; i++){
           int z= r.nextInt(6) + 1;
        
           System.out.println(z);
        }
    }
    public static void main(String[] args){
        Random r = new Random();
        
           int z= r.nextInt(6) + 1;
        
           System.out.println(z);
        
    }
}
