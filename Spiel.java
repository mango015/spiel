import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Spiel extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private JTextArea textfeld;
    private JTextField eingabeFeld, eeingabeFeld;
    private JButton nameEintragen, geldSetzen, würfeln, stopp, aufgeben, restart, addLine;
    
    private boolean prim;
    private int z;
    private int teil;
    private int zahl;
    private String text;
    private int check;
    private int doublecheck;
    private Wurf wurf;
    private Spieler[] spieler;
    /**
     * Constructor for objects of class Schule
     */
    public Spiel()
    {
        wurf= new Wurf();
        spieler= new Spieler[2];
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    
    public void würfeln()
    {
        // put your code here
       zahl = wurf.doppelwurf();
       if(zahl!=7) {
           spieler[z].setRundenPunkte((spieler[z].getRundenPunkte()+ zahl));
           
           text= spieler[z].getName()+", du hast eine " + zahl +" gewürfelt. |  Deine aktuelle RundenPunkte: "+spieler[z].getRundenPunkte()+"\n";
           addText(text);
        }
        else{
            spieler[z].setRundenPunkte((spieler[z].getRundenPunkte()-7));
            text="Leider eine 7... :/ |  Deine aktuelle RundenPunkte: "+spieler[z].getRundenPunkte()+"\n";
            addText(text);
          würfeln.setEnabled(false);
          wechsel();
        }
        
        
    }
    public String geldSetzen(int zahl){
        if(zahl<=20){
            text= "Der Einsatz der aktuellen Runde beträgt: "+ zahl + "  |  Gewinn: "+(2*zahl);
            
            addText(spieler[z].getName()+", bitte würfle.\n");    
            nameEintragen.setEnabled(false);
            geldSetzen.setEnabled(false);
            würfeln.setEnabled(true);
            stopp.setEnabled(true);
            aufgeben.setEnabled(false);
            restart.setEnabled(false);    
        }
        else{
            text="Betrag ungültig!";
        }
        return text;
    }
    public void wechsel()
    {
        // put your code here
        if(teil==1){
            addText("WECHSEL\n");
            teil=2;
        
            
            if(z==1){
                z=0;
            }
            else{
                z=1;
            }
           
            addText(spieler[z].getName()+", bitte würfle.\n");    
            nameEintragen.setEnabled(false);
            geldSetzen.setEnabled(false);
            würfeln.setEnabled(true);
            stopp.setEnabled(true);
            restart.setEnabled(true);
            aufgeben.setEnabled(false);
            restart.setEnabled(false); 
        }
        else{
            addText("\nNeue Runde\n");
            addText("Hallo "+spieler[0].getName()+" und "+spieler[1].getName()+"!\nEuer Aktueller Kontostand: "+spieler[0].getName()+": 20 "+spieler[1].getName()+": 20\n");
            nameEintragen.setEnabled(false);
            geldSetzen.setEnabled(true);
            würfeln.setEnabled(false);
            stopp.setEnabled(false);
            aufgeben.setEnabled(true);
            restart.setEnabled(false);
            
            teil=1;
            addText(spieler[z].getName()+", bitte setze einen Betrag an Geld. \n");
        }
        
    }
    public void restart()
    {
        deleteText();
        addText("VERFLIXTE SIEBEN\n");
        spielVerlauf();
    }       
    public void cancel()
    {
        
        addText("\n SPIEL BEENDET \n\n Euer Aktueller Kontostand: "+spieler[0].getName()+": "+spieler[0].getGuthaben()+ " "+spieler[1].getName()+": "+spieler[1].getGuthaben()+"\n");
        eeingabeFeld.setEnabled(false);
        eeingabeFeld.setEnabled(false);
        nameEintragen.setEnabled(false);
        geldSetzen.setEnabled(false);
        würfeln.setEnabled(false);
        stopp.setEnabled(false);
        aufgeben.setEnabled(false);
        restart.setEnabled(true);
    }                  
    
    public static void main(String[] args) {
     Spiel beispiel1 = new Spiel();

     beispiel1.createTextArea();
     beispiel1.addText("VERFLIXTE SIEBEN\n");
     beispiel1.spielVerlauf  ();
     
    }
    
    public void spielVerlauf(){
        addText("Spieler, bitte gebt Eure Namen ein.\n");
        eeingabeFeld.setEnabled(true);
        nameEintragen.setEnabled(true);
       geldSetzen.setEnabled(false);
       würfeln.setEnabled(false);
       stopp.setEnabled(false);
       aufgeben.setEnabled(false);
       restart.setEnabled(false);
    }
    public void createTextArea() {
      JFrame meinJFrame = new JFrame();
      meinJFrame.setTitle("JTextArea Beispiel");
      meinJFrame.setSize(1000, 700);
      JPanel panel = new JPanel();
 
      //20-zeiliges und 50-spaltiges Textfeld wird erzeugt
      textfeld = new JTextArea(30, 80);
 
      //Text für das Textfeld wird gesetzt
      textfeld.setText("");
      //Zeilenumbruch wird eingeschaltet
      textfeld.setLineWrap(true);
 
      //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
      textfeld.setWrapStyleWord(true);
 
      //Ein JScrollPane, der das Textfeld beinhaltet, wird erzeugt
      JScrollPane scrollpane = new JScrollPane(textfeld);       
 
      //Scrollpane wird unserem Panel hinzugefügt
      panel.add(scrollpane);
 
      meinJFrame.add(panel);
      meinJFrame.setVisible(true);
      
      //Eingabefeld und Buttons hinzufügen
      eingabeFeld = new JTextField("Spieler1");
      eingabeFeld.setColumns(10); 
      panel.add(eingabeFeld);
      eeingabeFeld = new JTextField("Spieler2");
      eeingabeFeld.setColumns(10); 
      panel.add(eeingabeFeld);
      
      nameEintragen = new JButton("Name.");
      nameEintragen.addActionListener(this);
      geldSetzen = new JButton("Geld setzen");
      geldSetzen.addActionListener(this);
      würfeln = new JButton("Würfeln");
      würfeln.addActionListener(this);
      stopp = new JButton("Stopp");
      stopp.addActionListener(this);
      aufgeben = new JButton("Aufgeben");
      aufgeben.addActionListener(this);
      restart = new JButton("Neues Spiel!");
      restart.addActionListener(this);
      
      panel.add(nameEintragen);
      panel.add(geldSetzen);
      panel.add(würfeln);
      panel.add(stopp);
      panel.add(aufgeben);
      panel.add(restart);
      
      }
    
      public void actionPerformed(ActionEvent e){
      if(e.getSource() == this.nameEintragen){
          
            String name1 = eingabeFeld.getText();
            
            String name2 = eeingabeFeld.getText();
            deleteText();
            spieler[0]=new Spieler(name1);
            spieler[1]=new Spieler(name2);
            addText("Hallo "+spieler[0].getName()+" und "+spieler[1].getName()+"!\nEuer Aktueller Kontostand: "+spieler[0].getName()+": 20 "+spieler[1].getName()+": 20\n");
            nameEintragen.setEnabled(false);
            eeingabeFeld.setEnabled(false);
            geldSetzen.setEnabled(true);
            würfeln.setEnabled(false);
            stopp.setEnabled(false);
            aufgeben.setEnabled(true);
            restart.setEnabled(false);
            z = 0;
            teil=1;
            addText(spieler[z].getName()+", bitte setze einen Betrag an Geld. \n");
      }
      if(e.getSource() == this.geldSetzen){
          
            int zahl = Integer.parseInt(eingabeFeld.getText());
            
            addText(geldSetzen(zahl)+" .\n");
            
            
        }
        else if(e.getSource() == this.würfeln){
            int zahl = Integer.parseInt(eingabeFeld.getText());
            würfeln();
        }
        else if(e.getSource() == this.stopp){
            wechsel();
        }
        else if(e.getSource() == this.aufgeben){
            cancel();
        }
        else if(e.getSource() == this.restart){
            restart();
        }
            
  }
    
    public void addText(String newText) {
      textfeld.append(newText);
    }
    
     public void deleteText() {
      textfeld.selectAll();
      textfeld.cut();
    }
    
     public void newLine() {
      textfeld.append("\n");
    }
}
