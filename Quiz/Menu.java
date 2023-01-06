/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

/**
 *
 * @author ZAHRA HM
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Menu implements ActionListener {
    int index_menu;
    
    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    
    JButton start = new JButton();
    JButton exit = new JButton();
    JLabel label_start = new JLabel();
    JLabel label_exit = new JLabel();
    JTextField konfirm_exit = new JTextField();
    
    //constructor
    public Menu(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,1010);
        frame.getContentPane().setBackground(new Color(114, 196, 250));
        frame.setLayout(null);
	frame.setResizable(false);
        
        textfield.setBounds(0,150,650,50);
        textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("Consolas",Font.BOLD,35));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        
        start.setBounds(0,350,100,100);
        start.setFont(new Font("Consolas",Font.BOLD,30));
        start.setFocusable(false);
	start.addActionListener(this);
	start.setText("Start");
        
        exit.setBounds(0,350,100,100);
        exit.setFont(new Font("Consolas",Font.BOLD,30));
        exit.setFocusable(false);
	exit.addActionListener(this);
	exit.setText("Exit");
        
        konfirm_exit.setBounds(225,225,200,100);
        konfirm_exit.setBackground(new Color(225,225,200,100));
        konfirm_exit.setForeground(new Color(0,0,0));
        konfirm_exit.setFont(new Font("Consolas",Font.BOLD,50));
        konfirm_exit.setBorder(BorderFactory.createBevelBorder(1));
        konfirm_exit.setHorizontalAlignment(JTextField.CENTER);
	konfirm_exit.setEditable(false);
        
        frame.add(start);
        frame.add(exit);
        frame.add(textfield);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        start.setEnabled(true);
	start.setEnabled(true);
        
        if (e.getSource()== start){
            index_menu = 1;
        }
        if (e.getSource()== exit){
            index_menu = 0;
        }
        start_game();
    }
    
    public void start_game(){
        if (index_menu == 0){
            //exit game
        } 
        else if (index_menu == 1){
            //masuk ke game
            //pake ini ?? Quiz quiz = new Quiz();
        }
    }
    
    public void display(){
        start.setEnabled(true);
	start.setEnabled(true);
        
        if(index_menu == 1)
		start.setForeground(new Color(0,134,13));
	if(index_menu == 0)
		exit.setForeground(new Color(0,134,13));
        
        
    }
}