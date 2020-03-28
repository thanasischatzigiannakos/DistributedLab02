//321/2015217
//Χατζηγιαννάκος Αθανάσιος
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.ServerSocket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Server {

    private Socket socket = null;
    private ServerSocket server = null;
    private static final long serialVersionUID = 6529685098267757690L;  //eksasfalizoume oti kai o client kai o server exoyn to idio serialVersionUID

    ArrayList<Kratisi> list = new ArrayList<>();    //orismos enos arraylist sto opoio 8a apo8hkeuontai oi pelates
    

    public void runServer() throws IOException, ClassNotFoundException { //me8odos gia thn leitourgia tou server

        server = new ServerSocket(4444); //orizoume to port 
        long idp = 434235221;   //enas ari8mos pou 8a xrhsimoopioume gia th paragwgh monadikwn ID
        boolean run = true;
        while (true) {   //8eloume o server mas na trexei sunexws
            socket = server.accept();   //otan erxete aithma apo client 
            System.out.println("Connected");
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());   //orismos twn data streams
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

            Kratisi r = (Kratisi) is.readObject();    //diavazoume to antikeimeno pou stal8hke apo ton client

            
            if (r.getProcess().equals("reservation")) {   //analoga me to process pou exei to antikeimeno o server ektelei diaforetikh leitourgia 

                long cost = 0;
                long food = 0;

                long days = ChronoUnit.DAYS.between(r.returnADate(), r.returnDDate());  //upologizoume tis meres pou 8a diameinei o xrhsths
                days = days + 1;
                
                if (r.returnBreakfast() == true) {   //eelgxoume ean exei balei kai th paroxh prwinou
                    food = days * 8;
                }

                if (r.returnRoom().equals("Single bed") && (r.returnADate().getMonthValue() > 5 && r.returnADate().getMonthValue() < 10) && (r.returnDDate().getMonthValue() > 5 && r.returnDDate().getMonthValue() < 10)) {
                    cost = (days * 80) + food;   //upologizoume to kostos analoga me to dwmatio alla kai th periodo diamonhs

                } else if (r.returnRoom().equals("Two beds") && (r.returnADate().getMonthValue() > 5 && r.returnADate().getMonthValue() < 10) && (r.returnDDate().getMonthValue() > 5 && r.returnDDate().getMonthValue() < 10)) {
                    cost = (days * 120) + food;

                } else if (r.returnRoom().equals("Three Beds") && (r.returnADate().getMonthValue() > 5 && r.returnADate().getMonthValue() < 10) && (r.returnDDate().getMonthValue() > 5 && r.returnDDate().getMonthValue() < 10)) {
                    cost = (days * 150) + food;

                } else if (r.returnRoom().equals("Single bed") && (r.returnADate().getMonthValue() < 5 || r.returnADate().getMonthValue() > 10) && (r.returnDDate().getMonthValue() < 5 || r.returnDDate().getMonthValue() > 10)) {
                    cost = (days * 40) + food;

                } else if (r.returnRoom().equals("Two beds") && (r.returnADate().getMonthValue() < 5 || r.returnADate().getMonthValue() > 10) && (r.returnDDate().getMonthValue() < 5 || r.returnDDate().getMonthValue() > 10)) {
                    cost = (days * 70) + food;

                } else if (r.returnRoom().equals("Three Beds") && (r.returnADate().getMonthValue() < 5 || r.returnADate().getMonthValue() > 10) && (r.returnDDate().getMonthValue() < 5 || r.returnDDate().getMonthValue() > 10)) {
                    cost = (days * 85) + food;

                }

                Kratisi m = new Kratisi(r.returnName(), r.returnSurname(), r.returnNumber(), r.returnRoom(), r.returnADate(), r.returnDDate(), r.returnBreakfast(), r.getProcess(), idp, cost); //dhmiourgia antikeimenou me ta kainourgia stoixeia
                idp++;  //auksanoume to idp gia na eksasfalisoume monadikotita twn ID
                list.add(m); //pros8etoume to antikeimeno sto arraylist 
                os.writeObject(m); //stelnoume pisw to antikeimeno ston client

            } else if (r.getProcess().equals("search")) {  //periptwsh search 
                ArrayList<String> info = new ArrayList<>();  //orizoume kainoyrgia arraylist

                String breakf="";
                for (int i = 0; i < list.size(); i++) {  //diatrexoume to arraylist twn pelatwn
                    if(list.get(i)!=null){ //elegxoume wste na mhn einai keno kapoio keli
                    if (list.get(i).returnBreakfast() == true) {   //elegxoume gia to prwino
                        
                        breakf = "Yes";
                    } else {
                        breakf = "No";
                    }}
                     if(list.get(i)!=null){
                    if ((list.get(i).returnName().equals(r.returnName())) && list.get(i).returnSurname().equals(r.returnSurname())) {   //elegxoume ta krithria tou search

                        info.add("Name:" + list.get(i).returnName());   //pros8etoume ta stoixeia sto arraylist info
                        info.add("\nSurname:" + list.get(i).returnSurname());
                        info.add("\nPhone Number:" + list.get(i).returnNumber());
                        info.add("\nRoom Type:" + list.get(i).returnRoom());
                        info.add("\nBreakfast:" + breakf);
                        info.add("\nDate of arrival:" + list.get(i).returnADate().format(DateTimeFormatter.ofPattern("dd.MMMM yyyy")));
                        info.add("\nDate of departure:" + list.get(i).returnDDate().format(DateTimeFormatter.ofPattern("dd.MMMM yyyy")));
                        info.add("\nUsers ID:" + list.get(i).returnId()+"\n");
                        info.add("**********************\n");

                        

                    }
                }}
                Kratisi n = new Kratisi(info); //antikeimeno tou opoiou o constructor dexetai mono String arraylist
                os.writeObject(n);  //apostolh tou antikeimenou pou periexei oles tis plhrofories
               

            } else if (r.getProcess().equals("delete")) {   //periptwsh gia delete
                    int y=0;
                   
                for (int i = 0; i < list.size(); i++) {    //diatrexoume to arraylist twn pelatwn kai ean to id einai idio me to id tou pelath afairoume th krathsh tou pelath apo to arraylist
                    if (list.get(i).returnId() == r.returnId()) {

                        list.remove(i);
                        y++;

                    }
                }
                if(y==0)
                JOptionPane.showMessageDialog(null,"No reservation matches this User ID please try again"); //ean den bre8ei krathsh me to idio id emfanizoume analogo mhnyma

            }
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        new Server().runServer();   //ekinnhsh tou server

    }

}
