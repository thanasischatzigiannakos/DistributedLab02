//321/2015217
//Χατζηγιαννάκος Αθανάσιος
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thanasis
 */
public class Kratisi implements Serializable {          //idia klash me auth tou server

    private String name;
    private String surname;
    private String c_number;                            //kai se auth th periptwsh exoume constructors gia diaforetikes leitourgies
    private String room;
    private LocalDate arrival;
    private LocalDate departure;
    private boolean breakfast;
    private String process;
    private long id;
    private long cost;
    private ArrayList<String> list;
    private static final long serialVersionUID = 6529685098267757690L;
            
    public Kratisi(String cName, String cSurname, String cNumber, String uRoom, LocalDate cArrival, LocalDate cDeparture, boolean cBreakfast, String cProcess, long uid, long ucost) {

        name = cName;
        surname = cSurname;
        c_number = cNumber;
        room = uRoom;
        arrival = cArrival;
        departure = cDeparture;
        breakfast = cBreakfast;
        process = cProcess;
        id = uid;
        cost = ucost;
       ArrayList<String> list = new ArrayList<String>() ;
      
    }
    
    public Kratisi(String cName, String cSurname, String cNumber, String uRoom, LocalDate cArrival, LocalDate cDeparture, boolean cBreakfast, String cProcess, long uid, long ucost,String uloyo) {

        name = cName;
        surname = cSurname;
        c_number = cNumber;
        room = uRoom;
        arrival = cArrival;
        departure = cDeparture;
        breakfast = cBreakfast;
        process = cProcess;
        id = uid;
        cost = ucost;
        ArrayList<String> list = new ArrayList<String>() ;

    }

    public Kratisi(ArrayList<String> forreal) {
        name = "";
        surname = "";
        c_number = "";
        room = "";
        arrival = LocalDate.now();
        departure = LocalDate.now();;
        breakfast = false;
        process = "";
        id = 1;
        cost = 11;
        list = forreal;

    }

    public String returnName() {

        return name;
    }

    public String returnSurname() {

        return surname;
    }

    public String returnNumber() {

        return c_number;
    }

    public LocalDate returnADate() {

        return arrival;
    }

    public LocalDate returnDDate() {

        return departure;
    }

    public boolean returnBreakfast() {

        return breakfast;
    }

    public String getProcess() {
        return process;
    }

    public long returnId() {
        return id;
    }

    public String returnRoom() {
        return room;
    }
}
