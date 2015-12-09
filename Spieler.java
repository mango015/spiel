public class Spieler
{
    // instance variables - replace the example below with your own
    private int guthaben;
    private String name;
    private int rundenPunkte;

    /**
     * Constructor for objects of class Spieler
     */
    public Spieler(String newName)
    {
        // initialise instance variables
        name=newName;
        guthaben=20;
        rundenPunkte=0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    public int getGuthaben()
    {
        // put your code here
        return guthaben;
    }
    public int getRundenPunkte()
    {
        // put your code here
        return rundenPunkte;
    }
    public void setName(String nameAendern)
    {
        name=nameAendern;
    }
    public void setGuthaben(int guthabenAendern)
    {
        guthaben=guthabenAendern;
    }
    public void setRundenPunkte(int rundenPunkteAendern)
    {
        rundenPunkte=rundenPunkteAendern;
    }
    
}
