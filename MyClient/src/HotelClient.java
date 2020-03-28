//321/2015217
//Χατζηγιαννάκος Αθανάσιος
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class HotelClient {

 
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");   //allazoume thn emfanish twn grafikwn
          
        } catch (UnsupportedLookAndFeelException ex) {   
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        new Gui().createAndShowGUI();  //ekkinhsh tou programmatos tou client
    }
    
}
