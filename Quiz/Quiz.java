/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{ //implementasi antarmuka karena bakalan ada mencet tombol"
	//paka array set(?)
	String[] questions = 	{
								"Which company created Java?",
								"Which year was Java created?",
								"What was Java originally called?",
								"Who is credited with creating Java?",
							};
        
        
        
        //ini array 2 dimensi
	String[][] options = 	{
								{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
								{"1989","1996","1972","1492"},
								{"Apple","Latte","Oak","Koffing"},
								{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"},
							};
	//jawaban yang bener
        char[] answers = 		{
								'A',
								'B',
								'C',
								'C',
							};
        //variabel yang dipake
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length; //jumlah pertanyaaan
	int result;
	int seconds = 15;
        int seconds2 = 5;
	
        //untuk inisiasi komponen-komponen GUI
	JFrame frame = new JFrame(); //yang menampung semuanya
	JTextField textfield = new JTextField(); //menampuung pertanyaan yang aktif saat ini 
	JTextArea textarea = new JTextArea();//menampung pertaanyaan ssat ini
	//tombol jawaban
        JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
        JButton buttonRe = new JButton();
        JButton buttonQuit = new JButton();
        //label jawaban
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
        //label timer
	JLabel time_label = new JLabel(); //menampilkan timer
	JLabel seconds_left = new JLabel(); //countdown timer
        //result
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField(); //prsentase skor
	 
	Timer timer = new Timer(1000, new ActionListener() {
		
            //hitung mundur
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
        //konstruktor
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,900); //ukuran tampilan gamenya mau segimana lebar, panjang
		frame.getContentPane().setBackground(new Color(114, 196, 250)); //warna background
		frame.setLayout(null);
		frame.setResizable(false); //ukuran frame jadi gak bisa diubah
		
                //tulisan questions
		textfield.setBounds(0,0,650,50); //penempatan text (x,y), panjang dan tingginya bidang text
		textfield.setBackground(new Color(255,255,255)); //warna bg tulisannya
		textfield.setForeground(new Color(0,0,0)); //warna tulisan
		textfield.setFont(new Font("Consolas",Font.BOLD,35)); //jenis font,dibold,size  
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER); //penempatan tulisan
		textfield.setEditable(false); //biar gk bisa diedit
		
                //pertanyaannya
		textarea.setBounds(0,50,650,100);
		textarea.setLineWrap(true); //biar tulisannya nyesuain ukuran, gk kepotong, next line
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(114,196,250));
		textarea.setForeground(new Color(255,255,255));
		textarea.setFont(new Font("Consolas",Font.BOLD,30));
		//textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,150,100,100); //posisi (x, y, ukuran)
		buttonA.setFont(new Font("Consolas",Font.BOLD,30));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this); //biar kebaca gt klo ke klik
		buttonA.setText("A");//tulisannya
		
		buttonB.setBounds(0,250,100,100);
		buttonB.setFont(new Font("Consolas",Font.BOLD,30));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,350,100,100);
		buttonC.setFont(new Font("Consolas",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,450,100,100);
		buttonD.setFont(new Font("Consolas",Font.BOLD,30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
                
                buttonRe.setBounds(0,600,200,100);
		buttonRe.setFont(new Font("Consolas",Font.BOLD,30));
		buttonRe.setFocusable(false);
		buttonRe.addActionListener(this);
		buttonRe.setText("Reattempt");
		
                buttonQuit.setBounds(240,600,120,100);
		buttonQuit.setFont(new Font("Consolas",Font.BOLD,30));
		buttonQuit.setFocusable(false);
		buttonQuit.addActionListener(this);
		buttonQuit.setText("Exit");
                
		answer_labelA.setBounds(125,150,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(255,255,255));
		answer_labelA.setFont(new Font("Consolas",Font.PLAIN,30));
		
		answer_labelB.setBounds(125,250,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(255,255,255));
		answer_labelB.setFont(new Font("Consolas",Font.PLAIN,30));
		
		answer_labelC.setBounds(125,350,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(255,255,255));
		answer_labelC.setFont(new Font("Consolas",Font.PLAIN,30));
		
		answer_labelD.setBounds(125,450,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(255,255,255));
		answer_labelD.setFont(new Font("Consolas",Font.PLAIN,30));
		
                //timer
		seconds_left.setBounds(535,600,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0)); //tulisan
		seconds_left.setFont(new Font("Consolas",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds)); //ini jadi str secondsnya
		
		//time_label.setBounds(535,475,100,25);
		//time_label.setBackground(new Color(50,50,50));
		//time_label.setForeground(new Color(255,0,0));
		//time_label.setFont(new Font("Consolas",Font.BOLD,16));
		//time_label.setHorizontalAlignment(JTextField.CENTER);
		//time_label.setText("! Timer !"); //atur tulisan yang ditampilin
		
                //result
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(0,0,0));
		number_right.setFont(new Font("Consolas",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(255,255,255));
		percentage.setForeground(new Color(0,0,0));
		percentage.setFont(new Font("Consolas",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
                //dimasukin ke framenya
		//frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
                frame.add(buttonRe);
                frame.add(buttonQuit);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true); //nampilin
		
		nextQuestion();
	}
        
        //method untuk pindah ke pertanyaan yang berikutnya
	public void nextQuestion() {
		
            //dijalanin gamenya
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Soal "+(index+1)); 
                        //manggil pertanyaannya
			textarea.setText("\n  " + questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
        
        
        //pokoknya ttg pencel tombol
	@Override
	public void actionPerformed(ActionEvent e) {
		//akses tombol
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
                        buttonRe.setEnabled(false);
                        buttonQuit.setEnabled(false);
			
                        //klo pencet tombol A
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
                        if(e.getSource()==buttonRe) {
                                frame.dispose();
                                Quiz quiz = new Quiz();
                                
                        }
                        if(e.getSource()==buttonQuit) {
                                frame.dispose();
                                
                        }
			displayAnswer();
	}
        
        
        //menampilkan jawaban yang benar
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
                
                if(answers[index] == 'A')
			answer_labelA.setForeground(new Color(0,134,13));
		if(answers[index] == 'B')
			answer_labelB.setForeground(new Color(0,134,13));
		if(answers[index] == 'C')
			answer_labelC.setForeground(new Color(0,134,13));
		if(answers[index] == 'D')
			answer_labelD.setForeground(new Color(0,134,13));
		
                //buat objek
		Timer pause = new Timer(2000, new ActionListener() {//2000 milidetik
			
                    //balikin warna jawabannya
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(255,255,255));
				answer_labelB.setForeground(new Color(255,255,255));
				answer_labelC.setForeground(new Color(255,255,255));
				answer_labelD.setForeground(new Color(255,255,255));
				
                                //ini sebenerny user bisa mulainya baru dari sini
				answer = ' '; //atur ulang jawaban
				seconds=15;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
        
        //menampilkan hasil
	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonRe.setEnabled(true);
		buttonQuit.setEnabled(true);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}
