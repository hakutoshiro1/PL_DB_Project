import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui extends JPanel implements ActionListener{
    JLabel jcomp1;
    JLabel jcomp2;
    JTextField prn_tf;
    JTextField lname_tf;
    JLabel jcomp5;
    JTextField fname_tf;
    JLabel jcomp7;
    JTextField age_tf;
    JButton insert_bt;     //Insert
    JButton read_bt;    //Read
    JButton update_bt;    //Update
    JButton delete_bt;    //Delete
    JButton ok_bt;
    Student obj1;
    JLabel result_m;

    static char state;  //tells which state is selected

    public Gui() {
        obj1 = new Student();
        //construct components
        jcomp1 = new JLabel ("First Name");
        jcomp2 = new JLabel ("Last Name");
        prn_tf = new JTextField (5);
        lname_tf = new JTextField (5);
        jcomp5 = new JLabel ("PRN");
        fname_tf = new JTextField (5);
        jcomp7 = new JLabel ("Age");
        age_tf = new JTextField (5);
        insert_bt = new JButton ("Insert");
        read_bt = new JButton ("Read");
        update_bt = new JButton ("Update");
        delete_bt = new JButton ("Delete");
        ok_bt = new JButton("OK->");
        result_m=new JLabel();
        
        insert_bt.addActionListener(this);
        read_bt.addActionListener(this);
        update_bt.addActionListener(this);
        delete_bt.addActionListener(this);
        ok_bt.addActionListener(this);
        //adjust size and set layout
        setPreferredSize (new Dimension (788, 378));
        setLayout (null);

        

        //add components
        add (jcomp1);
        add (jcomp2);
        add (prn_tf);
        add (lname_tf);
        add (jcomp5);
        add (fname_tf);
        add (jcomp7);
        add (age_tf);
        add (insert_bt);
        add (read_bt);
        add (update_bt);
        add (delete_bt);
        add(ok_bt);
        add(result_m);

        //setting form invisible default
        jcomp1.setVisible(false);
        jcomp2.setVisible(false);
        prn_tf.setVisible(false);
        lname_tf.setVisible(false);
        jcomp5.setVisible(false);
        fname_tf.setVisible(false);
        jcomp7.setVisible(false);
        age_tf.setVisible(false);
        ok_bt.setVisible(false);
        result_m.setVisible(false);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (70, 120, 80, 25);
        jcomp2.setBounds (70, 160, 80, 25);
        prn_tf.setBounds (170, 85, 215, 25);
        lname_tf.setBounds (170, 160, 215, 25);
        jcomp5.setBounds (70, 85, 80, 25);
        fname_tf.setBounds (170, 120, 215, 25);
        jcomp7.setBounds (70, 200, 80, 25);
        age_tf.setBounds (170, 200, 100, 25);
        insert_bt.setBounds (65, 30, 100, 25);
        read_bt.setBounds (210, 30, 100, 25);
        update_bt.setBounds (355, 30, 100, 25);
        delete_bt.setBounds (505, 30, 100, 25);
        ok_bt.setBounds (600, 150, 100, 25);
        result_m.setBounds(30, 250, 500, 60);
    }

    public static void main (String[] args) {
        Student obj =new Student();
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Gui());
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==insert_bt){
            // System.out.println("Insert");
            jcomp1.setVisible(true);
            jcomp2.setVisible(true);
            prn_tf.setVisible(true);
            lname_tf.setVisible(true);
            jcomp5.setVisible(true);
            fname_tf.setVisible(true);
            jcomp7.setVisible(true);
            age_tf.setVisible(true);
            ok_bt.setVisible(true);
            result_m.setVisible(false);
            this.state='i';
            
        }else if(e.getSource()==read_bt){
            System.out.println("Read");
            jcomp1.setVisible(false);
            jcomp2.setVisible(false);
            prn_tf.setVisible(true);
            fname_tf.setVisible(false);
            jcomp5.setVisible(true);
            lname_tf.setVisible(false);
            jcomp7.setVisible(false);
            age_tf.setVisible(false);
            ok_bt.setVisible(true);
            result_m.setVisible(false);
            this.state='r';
        }else if(e.getSource()==update_bt){
            System.out.println("Update");
            jcomp1.setVisible(true);
            jcomp2.setVisible(true);
            prn_tf.setVisible(true);
            lname_tf.setVisible(true);
            jcomp5.setVisible(true);
            fname_tf.setVisible(true);
            jcomp7.setVisible(true);
            age_tf.setVisible(true);
            ok_bt.setVisible(true);
            result_m.setVisible(false);
            this.state='u';
        }else if(e.getSource()==delete_bt){
            System.out.println("Delete");
            jcomp1.setVisible(false);
            jcomp2.setVisible(false);
            prn_tf.setVisible(true);
            fname_tf.setVisible(false);
            jcomp5.setVisible(true);
            lname_tf.setVisible(false);
            jcomp7.setVisible(false);
            age_tf.setVisible(false);
            ok_bt.setVisible(true);
            result_m.setVisible(false);
            this.state='d';
        } 
        else if (e.getSource()==ok_bt){
            result_m.setVisible(true);
            if(this.state=='i'){
                int prn_tt = Integer.parseInt(prn_tf.getText());
                String lname_tt = lname_tf.getText();
                String fname_tt = fname_tf.getText();
                int age_tt = Integer.parseInt(age_tf.getText());
                lname_tf.setText("");
                fname_tf.setText("");
                prn_tf.setText("");
                age_tf.setText("");

                // System.out.println(prn_tt);
                // System.out.println(fname_tt);
                // System.out.println(lname_tt);
                // System.out.println(age_tt);
                
                obj1.Insert_data(prn_tt, fname_tt, lname_tt, age_tt);
                result_m.setText("Inserted Successfully.");
            }else if(this.state=='r'){
                int prn_tt = Integer.parseInt(prn_tf.getText());
                prn_tf.setText("");
                String rs= obj1.read_data( prn_tt);
                result_m.setText(rs);
            }else if(this.state=='u'){
                int prn_tt = Integer.parseInt(prn_tf.getText());
                String lname_tt = lname_tf.getText();
                String fname_tt = fname_tf.getText();
                int age_tt = Integer.parseInt(age_tf.getText());
                lname_tf.setText("");
                fname_tf.setText("");
                prn_tf.setText("");
                age_tf.setText("");

                // System.out.println(prn_tt);
                // System.out.println(fname_tt);
                // System.out.println(lname_tt);
                // System.out.println(age_tt);
                
                obj1.update_fname(prn_tt, fname_tt);
                obj1.update_lname(prn_tt,lname_tt);
                obj1.update_age(prn_tt, age_tt);
                result_m.setText("updated Successfully.");
            }else if(this.state=='d'){
                int prn_tt = Integer.parseInt(prn_tf.getText());
                prn_tf.setText("");
                obj1.delete_datarow(prn_tt);
                result_m.setText("Deleted Successfully.");
            } 
        }
    }
}