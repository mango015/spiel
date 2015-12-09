public class Wurf
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;
    private int y;
    private Wuerfel wuerfel1;
    private Wuerfel wuerfel2;

    /**
     * Konstruktor für Objekte der Klasse Wurf
     */
    public Wurf()
    {
        // Instanzvariable initialisieren
        wuerfel1 = new Wuerfel();
        wuerfel2 = new Wuerfel();
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int doppelwurf()
    {
        // tragen Sie hier den Code ein
        x = wuerfel1.wurf();
        y = wuerfel2.wurf();
        return (x+y);
    }
    public void doppelwurfRechner()
    {
        // tragen Sie hier den Code ein
        x = wuerfel1.wurf();
        y = wuerfel2.wurf();
        System.out.println("Wurf 1: " + x + " Wurf 2: " + y + "   Wurf 1&2:" + (x+y));
    }
}
