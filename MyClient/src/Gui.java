//321/2015217
//Χατζηγιαννάκος Αθανάσιος
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Gui implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addComponentToPane(Container pane) throws IOException {

        JTabbedPane tabbedPane = new JTabbedPane();             //dhlwnoume oti 8a xrhsimopoihsoume grid layout
        GridLayout experimentLayout = new GridLayout(0, 1);

        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2019", "2020", "2021"};                      //pinakes String gia ta combo boxes mas
        String[] room = {"Single bed", "Two beds", "Three Beds"};

        JTextField name = new JTextField("", 50);      //dhlwsh twn grafikwn mas
        JTextField surname = new JTextField("", 50);
        JTextField cellphone = new JTextField("", 50);
        JComboBox aDay = new JComboBox(days);
        JComboBox aMonth = new JComboBox(months);
        JComboBox aYear = new JComboBox(years);
        JComboBox dDay = new JComboBox(days);
        JComboBox dMonth = new JComboBox(months);
        JComboBox dYear = new JComboBox(years);
        JComboBox rooms = new JComboBox(room);
        JCheckBox breakfast = new JCheckBox("(8E per day)");
        breakfast.setSelected(false);
        JButton submit = new JButton("Submit");

        JTextField delete = new JTextField("", 40);
        JButton cancel = new JButton("Cancel Reservation");

        JTextField sname = new JTextField("", 50);
        JTextField ssurname = new JTextField("", 50);
        JComboBox saDay = new JComboBox(days);
        JComboBox saMonth = new JComboBox(months);
        JComboBox saYear = new JComboBox(years);
        JComboBox sdDay = new JComboBox(days);
        JComboBox sdMonth = new JComboBox(months);
        JComboBox sdYear = new JComboBox(years);
        JButton search = new JButton("Search");

        JPanel card1 = new JPanel();                    //ana8esh twn grafikwn se cards
        card1.setLayout(experimentLayout);
        card1.add(new JLabel("Name:"));
        card1.add(name);
        card1.add(new JLabel("Surname:"));
        card1.add(surname);
        card1.add(new JLabel("Phone Number:"));
        card1.add(cellphone);
        card1.add(new JLabel("The date of your arrival:"));
        card1.add(aDay);
        card1.add(aMonth);
        card1.add(aYear);
        card1.add(new JLabel("The date of your departure:"));
        card1.add(dDay);
        card1.add(dMonth);
        card1.add(dYear);
        card1.add(new JLabel("Select the room type:"));
        card1.add(rooms);
        card1.add(new JLabel("Breakfast included?"));
        card1.add(breakfast);
        card1.add(submit);

        JPanel card2 = new JPanel();
        card2.setLayout(experimentLayout);
        card2.add(new JLabel("Name:"));
        card2.add(sname);
        card2.add(new JLabel("Surname:"));
        card2.add(ssurname);

        card2.add(search);

        JPanel card3 = new JPanel();
        card3.setLayout(experimentLayout);
        card3.add(new JLabel("Enter reservation id and press the button to cancel it:"));
        card3.add(delete);
        card3.add(cancel);

        tabbedPane.addTab("Make a Reservation", card1);    //xrhsimopoioume tabs gia thn eukoloterh perihghsh sto programma mas
        tabbedPane.addTab("Search for a reservations information", card2);
        tabbedPane.addTab("Cancel a Reservation", card3);

        pane.add(tabbedPane, BorderLayout.CENTER);

        submit.addActionListener(new ActionListener() {   // se periptwsh pou pathsoume to koumpi orizoume tie energeies pou prepei na ginoyn gia na apo8hkeutei h krathsh sto ksenodoxeio
            public void actionPerformed(ActionEvent e) {

                try {
                    int ad, am, ay, da, dm, dy;
                    LocalDate arrive;
                    LocalDate depart;
                    boolean box = false;
                    String action = "reservation";
                    if (breakfast.isSelected()) {
                        box = true;
                    }
                    ad = Integer.parseInt(aDay.getSelectedItem().toString());     //metatrepoume st Integer tis times gia ths hmeromhnies 
                    am = Integer.parseInt(aMonth.getSelectedItem().toString());   //gia na dieukolhnoume th metatroph se LocalDate
                    ay = Integer.parseInt(aYear.getSelectedItem().toString());
                    da = Integer.parseInt(dDay.getSelectedItem().toString());
                    dm = Integer.parseInt(dMonth.getSelectedItem().toString());
                    dy = Integer.parseInt(dYear.getSelectedItem().toString());
                    if (name.getText().equals("") || surname.getText().equals("") || cellphone.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the required information");    //den ginete kapoio apo ta JTextFields na einai kena
                    } else if ((am == dm && ad > da && ay == dy) || (ay > dy) || ((am > dm) || ((am == 4 || am == 6 || am == 9 || am == 11) && (ad > 30))) || (am == 2 && ad > 28) || ((dm > dm) || ((dm == 4 || dm == 6 || dm == 9 || dm == 11) && (da > 30)) || (dm == 2 && da > 28)) || (ad == da) && (am == dm) && (ay == dy)) {

                        JOptionPane.showMessageDialog(null, "Please make sure your dates are correct"); //kapoioi periorismoi gia tiw hmeromhnies

                    } else {                //an den uparxei kapoio problhma dhmiourgoume to antikeimeno ths klashs Kratisi
                        arrive = LocalDate.of(ay, am, ad);
                        depart = LocalDate.of(dy, dm, da);
                        Kratisi obj = new Kratisi(name.getText(), surname.getText(), cellphone.getText(), rooms.getSelectedItem().toString(), arrive, depart, box, action);
                        Kratisi k = communicateServer(obj); //xrhsimopoioume th me8odo communicateServer h opoia epitrepei th sundesh mas kai thn allhlepidrash me to server,ws apotelesma pairnoume pisw ena object tupou Kratisi apo to server
                        JOptionPane.showMessageDialog(null, "Reservation Complete\nTotal Price:" + k.returnCost() + "\nClients ID:" + k.returnId());//emfanizoume tis kainourgies plhrofories pou mas edwse o server
                        name.setText(null); //adeiazoume ta pedia tou form mas
                        surname.setText(null);
                        cellphone.setText(null);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        search.addActionListener(new ActionListener() {   //otan aptame to koumpi search

            public void actionPerformed(ActionEvent e) {
                ArrayList<String> info = new ArrayList<>();

                try {

                    String type = "search";
                    if (sname.getText().equals("") || ssurname.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill all the required information");    //den ginete kapoio apo ta JTextFields na einai kena
                    } else {

                        Kratisi obj = new Kratisi(sname.getText(), ssurname.getText(), type);

                        Kratisi returnMessage = communicateServer(obj);  //opws kai sth prohgoumenh periptwsh me th me8odo communicateServer antallazoume plhrofories me ton server
                        info = returnMessage.returnExtra();
                        StringBuilder sb = new StringBuilder();
                        for (String s : info) {
                            sb.append(s);   //bazoume ola ta String tou arraylist se ena megalo String to opoio 8a emfanisoume

                        }
                        JOptionPane.showMessageDialog(null, sb);     //emfanish se ena para8uro grafikwn twn plhroforiwn

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        cancel.addActionListener(new ActionListener() {    //epilogh gia akurwsh ths krathshs 
            public void actionPerformed(ActionEvent e) {
                String type = "delete";
                if (delete.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the required information");    //den ginete kapoio apo ta JTextFields na einai kena
                } else {

                    try {
                        Socket socket = new Socket("localhost", 4444);      //sundesh sto socket 
                        InputStream inputStream = socket.getInputStream();   //dhmiourgia twn data streams

                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        OutputStream os = socket.getOutputStream();
                        
                       
                        
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);

                        Kratisi obj = new Kratisi(Integer.parseInt(delete.getText()), type);
                        objectOutputStream.writeObject(obj);   //apostolh tou id tou opoiou th krathsh 8eloume na akurwsoume
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });

        cellphone.addKeyListener(new KeyAdapter() {    //apagoreuoume thn eisodo xarakthrwn se pedia pou apaitoun noumera
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c < '0' || c > '9') && (c != '\b')) {

                    e.consume();
                    JOptionPane.showMessageDialog(null, "Οnly numbers allowed");
                }
            }
        });

        delete.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c < '0' || c > '9') && (c != '\b')) {

                    e.consume();
                    JOptionPane.showMessageDialog(null, "Οnly numbers allowed");
                }
            }
        });
    }

    public Kratisi communicateServer(Kratisi object) throws IOException, ClassNotFoundException {  //me8odos communicate with server
        Socket socket = new Socket("localhost", 4444);   //sundeomaste ston server "akougwntas" kai oi duo sto idia kanali(exoume balei localhost giati trexoun kaio client kai o server sto idio mhxanhma
        InputStream inputStream = socket.getInputStream();   //dhmiourgia twn data streams

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        OutputStream outputStream = socket.getOutputStream();
        
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);   //dhmiourgia objectoutputstream gia na mporoume na steiloyme antikeimena

        objectOutputStream.writeObject(object);   //apostolh tou antikeimenou

        Kratisi returnMessage = (Kratisi) objectInputStream.readObject(); //paralabh tou antikeimenou pou stelnei o server
        
        socket.close();   //kleinoume to socket ka8ws teleiwse h antallagh pou 8eleme na ektelesoume

        return returnMessage;

    }

    public static void createAndShowGUI() throws IOException {   //me8odos gia thn dhmiourgia kai thn emfanish twn grafikwn mas

        JFrame frame = new JFrame("Hotel ICSD15217");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Gui demo = new Gui();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.setPreferredSize(new Dimension(720, 720));
        frame.pack();
        frame.setVisible(true);
    }

}
