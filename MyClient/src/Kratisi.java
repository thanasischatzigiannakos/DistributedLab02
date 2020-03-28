//321/2015217
//Χατζηγιαννάκος Αθανάσιος
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kratisi implements Serializable {  //ka8ws ta antikeimena ths klashs 8a pernane se DataStreams 8a prepei na kanoume implement Serializable

    private String name;
    private String surname;
    private String c_number;
    private String room;
    private LocalDate arrival;
    private LocalDate departure;
    private boolean breakfast;
    private String process;
    private long id;
    private long cost;
    private ArrayList<String> list;
     private static final long serialVersionUID = 6529685098267757690L;   //8a prepei kai apo th pleura tou client alla kai tou server na uparxei idio serialVersionUID
    public Kratisi(String cName, String cSurname, String cNumber,String uRoom, LocalDate cArrival, LocalDate cDeparture, boolean cBreakfast, String cProcess) {

        name = cName;
        surname = cSurname;                     //dhmiourgoume diaforetikous constructor analoga me th xrhsh tou en logo antikeimenou
        c_number = cNumber;
        room=uRoom;                             //ka8ws 8a prepei o client kai o server na stelnoun antikeimena metaksu tous
        arrival = cArrival;                     
        departure = cDeparture;
        breakfast = cBreakfast;
        process = cProcess;
        id = 0;
        cost = 0;
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

    public Kratisi(long u_id,String flag) {
        name = "";
        surname = "";
        arrival = LocalDate.now();
        departure = LocalDate.now();
        breakfast = false;
        process = flag;
        id = u_id;
        c_number = "";
        cost = 0;
        ArrayList<String> list = new ArrayList<String>() ;

    }

    public Kratisi(String uname, String usurname, String flag) {
        name = uname;
        surname = usurname;
        c_number = "";
        arrival = LocalDate.now();
        departure = LocalDate.now();
        breakfast = false;
        process = flag;
        id = 0;
        cost = 0;
        ArrayList<String> list = new ArrayList<String>() ;

    }

    public String returnName() {
                                    //me8odoi gia thn epistrofh twn timwn 
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

    public ArrayList<String> returnExtra() {
        return list;
    }
    public String returnRoom(){
    return room;
    }
    
    public long returnId(){
    return id;
    }
    
    public long returnCost(){
    return cost;
    }
}
