import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
import sun.audio.*;
import java.net.URL;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.midi.MidiDevice.Info;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.imageio.*;


class TaskScheduler extends TimerTask  implements ItemListener  {
	
TaskScheduler() {
//GUI OF MAIN FRAME STARTS****************************************************************************************************************************

JFrame jfrm = new JFrame("TASK SCHEDULER");
JPanel panel = new JPanel();
ImagePanel p = new ImagePanel(new ImageIcon("3d-wallpaper-12_ablmm7l.jpg").getImage());
//panel.setSize(100, 100);
jfrm.getContentPane().add(p);
//jfrm.setBackground(Color.red);
jfrm.setSize(950,640);
jfrm.setLocation(50,50);
jfrm.setLayout(new FlowLayout(FlowLayout.LEFT));
//jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jfrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jfrm.addWindowListener( new WindowAdapter()
{
    public void windowClosing(WindowEvent e)
    {
        JFrame frame = (JFrame)e.getSource();
 
        int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to exit the application without saving?","Exit Application", JOptionPane.YES_NO_OPTION);
 
        if (result == JOptionPane.YES_OPTION)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
});

Font font = new Font("Dialog" , Font.BOLD | Font.ITALIC ,15);
Font font2 = new Font("Dialog" , Font.BOLD | Font.ITALIC ,22);
JLabel jlab = new JLabel();
jlab.setForeground(Color.red);
jlab.setText("SELECT AN OPTION");
jlab.setFont(font2);
jlab.setForeground(Color.red);
jlab.setBounds(0, 0, 300,100);
jlab.setLocation(5, 5);

p.add(jlab);
jfrm.setVisible(true);

JButton jbtnAlpha = new JButton("SET AN ALARM");
jbtnAlpha.setForeground(Color.black);
JButton jbtnBeta = new JButton("SCHEDULE ANY TASK");
jbtnBeta.setForeground(Color.black);
jbtnAlpha.setFont(font);
jbtnBeta.setFont(font);
jbtnBeta.setLocation(10, 170);
jbtnBeta.setSize(200, 50);
jbtnAlpha.setLocation(10, 100);
jbtnAlpha.setSize(200, 50);
p.add(jbtnAlpha);
p.add(jbtnBeta);

//THE GUI OF MAIN FRAME HAS BEEN SET*****************************************************************************************************************


//THE GUI OF ALARM STARTS****************************************************************************************************************************


jbtnAlpha.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	Font font = new Font("Dialog" , Font.BOLD | Font.ITALIC ,16);
	jlab.setText("ALARM                                                                 ");
	jlab.setFont(font);
JFrame jfrm2 = new JFrame("ALARM");


JPanel panel1 = new JPanel();
ImagePanel p1 = new ImagePanel(new ImageIcon("maxresdefault.jpg").getImage());
panel1.setSize(100,100);
jfrm2.getContentPane().add(p1);

jfrm2.setSize(1000,700);

jfrm2.setLocation(100,10);
jfrm2.setLayout(new FlowLayout(FlowLayout.LEFT));
jfrm2.setVisible(true);

JLabel jlab2 = new JLabel();
jlab2.setText("Enter the time at which you want to set alarm" );
jlab2.setFont(font2);
jlab2.setForeground(Color.BLACK);
jlab2.setBounds(0, 0, 1000,100);
jlab2.setLocation(10, 10);
p1.add(jlab2);

JLabel jlab3 = new JLabel();
jlab3.setText("Enter hour in 24hr format :         ");
jlab3.setForeground(Color.black);
jlab3.setFont(font);
jlab3.setBounds(0, 0, 700,100);
jlab3.setLocation(10, 50);
p1.add(jlab3);

JTextField jtf = new JTextField();

jtf.setBounds(0,0 ,150,25 );
jtf.setLocation(250, 90);
p1.add(jtf);

JLabel jlabMIN = new JLabel();
jlabMIN.setText("Enter the minutes:          				             ");
jlabMIN.setForeground(Color.BLACK);
jlabMIN.setBounds(0, 0, 700,100);
jlabMIN.setLocation(10, 90);
p1.add(jlabMIN);
jlabMIN.setFont(font);

JTextField jtf1 = new JTextField();

jtf1.setBounds(0,0 ,150,25 );
jtf1.setLocation(250, 127);
p1.add(jtf1);

jtf1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {

	
	
}
});

//JLabel jlabStatus = new JLabel();

JLabel jlab = new JLabel("Select the dates:                                                                                                            ");
jlab.setForeground(Color.BLACK);
jlab.setBounds(0, 0, 700,100);
jlab.setLocation(10, 140);

p1.add(jlab);
jlab.setFont(font);
JCheckBox cb = new JCheckBox("MONDAY");
p1.add(cb);
cb.setFont(font);
cb.setBounds(0, 0, 100,25);
cb.setLocation(10, 220);
JLabel jlabMON = new JLabel();
JLabel jlabTUES= new JLabel();
JLabel jlabWED = new JLabel();
JLabel jlabTHURS = new JLabel();
JLabel jlabFRI = new JLabel();
JLabel jlabSAT = new JLabel();
JLabel jlabSUN = new JLabel();
jlabMON.setFont(font);
jlabTUES.setFont(font);
jlabWED.setFont(font);
jlabTHURS.setFont(font);
jlabFRI.setFont(font);
jlabSAT.setFont(font);
jlabSUN.setFont(font);

jlabMON.setForeground(Color.black);
jlabTUES.setForeground(Color.black);
jlabWED.setForeground(Color.black);
jlabTHURS.setForeground(Color.black);
jlabFRI.setForeground(Color.black);
jlabSAT.setForeground(Color.black);
jlabSUN.setForeground(Color.black);

cb.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabMON.setBounds(0, 0, 235,25);
		jlabMON.setLocation(10, 300);
		p1.add(jlabMON);
		if(cb.isSelected())
			jlabMON.setText(cb.getText() + " is selected");
		else
			jlabMON.setText( "");

	}
});


JCheckBox cb1 = new JCheckBox("TUESDAY");
p1.add(cb1);
cb1.setFont(font);
cb1.setBounds(0, 0, 115,25);
cb1.setLocation(120, 220);
cb1.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabTUES.setBounds(0, 0, 235,25);
		jlabTUES.setLocation(10, 330);
		p1.add(jlabTUES);
		
		if(cb1.isSelected())
			jlabTUES.setText(cb1.getText() + " is selected");
		else
			jlabTUES.setText("");

	}
});


JCheckBox cb2 = new JCheckBox("WEDNESDAY");
cb2.setFont(font);
cb2.setBounds(0, 0, 135,25);
cb2.setLocation(245, 220);

p1.add(cb2);
cb2.setFont(font);
cb2.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabWED.setBounds(0, 0, 235,25);
		jlabWED.setLocation(10, 360);
		p1.add(jlabWED);
		
		if(cb2.isSelected())
			jlabWED.setText(cb2.getText() + " is selected");
		else
			jlabWED.setText("");
	
	}
});


JCheckBox cb3 = new JCheckBox("THURSDAY");
p1.add(cb3);
cb3.setFont(font);
cb3.setBounds(0, 0, 125,25);
cb3.setLocation(395, 220);
cb3.setFont(font);
cb3.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabTHURS.setBounds(0, 0, 235,25);
		jlabTHURS.setLocation(10, 390);
		p1.add(jlabTHURS);
		
		if(cb3.isSelected())
			jlabTHURS.setText(cb3.getText() + " is selected");
		else
			jlabTHURS.setText("");

	}
});


JCheckBox cb4 = new JCheckBox("FRIDAY");
p1.add(cb4);
cb4.setFont(font);
cb4.setBounds(0, 0, 100,25);
cb4.setLocation(530, 220);
cb4.setFont(font);
cb4.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabFRI.setBounds(0, 0, 235,25);
		jlabFRI.setLocation(10, 420);
		p1.add(jlabFRI);
		
		if(cb4.isSelected())
			jlabFRI.setText(cb4.getText() + " is selected");
		else
			jlabFRI.setText("");

	}
});


JCheckBox cb5 = new JCheckBox("SATURDAY");
p1.add(cb5);
cb5.setFont(font);
cb5.setBounds(0, 0, 135,25);
cb5.setLocation(10, 260);
cb5.setFont(font);
cb5.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabSAT.setBounds(0, 0, 235,25);
		jlabSAT.setLocation(10, 450);
		p1.add(jlabSAT);
		
		if(cb5.isSelected())
			jlabSAT.setText(cb5.getText() + " is selected");
		else
			jlabSAT.setText("");

	}
});


JCheckBox cb6 = new JCheckBox("SUNDAY");
p1.add(cb6);
cb6.setFont(font);
cb6.setBounds(0, 0, 115,25);
cb6.setLocation(155, 260);
cb6.setFont(font);
cb6.addItemListener(new ItemListener(){
	public void  itemStateChanged(ItemEvent ie){
		jlabSUN.setBounds(0, 0, 235,25);
		jlabSUN.setLocation(10, 480);
		p1.add(jlabSUN);
		
		if(cb6.isSelected())
			jlabSUN.setText(cb6.getText() + " is selected");
		else
			jlabSUN.setText("");

	}	
});
JButton okBtn = new JButton("OK" );
okBtn.setBounds(0, 0, 100, 40);
okBtn.setLocation(500, 500);
p1.add(okBtn);
okBtn.setFont(font);
Font f3 = new Font("Dialog" , Font.BOLD | Font.ITALIC , 20);
okBtn.addActionListener(new ActionListener () {
	public void actionPerformed(ActionEvent ae){
		JLabel jlab3 = new JLabel();
		jlab3.setFont(font);
		jlab3.setBounds(0, 0, 600, 40);
		jlab3.setLocation(20, 500);
		jlab3.setFont(f3);
		p1.add(jlab3);
		jlab3.setText("THE ALARM HAS BEEN SET AT : " +jtf.getText() + ":" + jtf1.getText());
		String txt = jtf.getText();
		String txtMIN = jtf1.getText();
		
		Timer timer = new Timer();
		TimerTask tt = new TimerTask() {
			public void run() {
				Calendar cal = Calendar.getInstance();
				Integer hour = cal.get(Calendar.HOUR_OF_DAY);
				Integer min = cal.get(Calendar.MINUTE);
				String str = hour.toString();		
				String strMIN = min.toString();
				if (txt.equals(str))
				{
					if(txtMIN.equals(strMIN))
					{
						 ImagePanel panel = new ImagePanel(new ImageIcon("small_3600_Holding-an-old-black-and-white-clock-HD-wallpaper.jpg").getImage());

						    JFrame frame = new JFrame("RINGING");
						    frame.getContentPane().add(panel);
						    frame.pack();
						    frame.setSize(600,600);
						    frame.setVisible(true);
						    frame.setLayout(new FlowLayout());
						    JLabel jb = new JLabel();
						    frame.add(jb);
						    jb.setText("WAKE UP!! WAKE UP!! WAKE UP!!");
						    Font font = new Font("Dialog" , Font.BOLD ,20);
						    jb.setFont(font);
						    jb.setLocation(550, 550);
					//Clip sound = loadClip("Main_Rang_Sharbaton_Ka_RaagJatt.wav");
					//playClip(sound );
					
					//AUDIOCLIP
					File soundFile = new File("Main_Rang_Sharbaton_Ka_RaagJatt.wav");
					AudioInputStream sound = null;
					try {
					sound = AudioSystem.getAudioInputStream(soundFile);
					} catch (UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
					
				   // AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
				//	Info info = new DataLine.Info(Clip.class, sound.getFormat());
					
					
					javax.sound.sampled.DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
					Clip clip = null;
					
					try {
					clip = (Clip)AudioSystem.getLine(info);
					} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					try {
						clip.open(sound);
						} catch (LineUnavailableException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//clip.open(sound);
				    // load the sound into memory (a Clip)
					   // Clip clip = (Clip) AudioSystem.getLine(info);
				    //clip.open(sound);

				    // due to bug in Java Sound, explicitly exit the VM when
				    // the sound has stopped.
					
					
				    clip.addLineListener(new LineListener() {
				      public void update(LineEvent event) {
				        if (event.getType() == LineEvent.Type.STOP) {
				          event.getLine().close();
				          System.exit(0);
				        }
				      }
				    });

				    // play the sound clip
				    clip.start();
	//			    Thread.sleep(40000);
				    try {
				    	Thread.sleep(40000);
				    	} catch (InterruptedException e) {
				    	// TODO Auto-generated catch block
				    	e.printStackTrace();
				    	}		
				    
					}
					}
				}
				
			
		};
		timer.schedule(tt, 1000,1000);
	
	}	
});

}
});

//THE GUI OF ALARM STARTS*************************************************************************************************************************




//GUI OF REMINDER STARTS ***********************************************************************************************************************


jbtnBeta.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
	jlab.setFont(font);
jlab.setText("TASK                                                                          ");
setRem();
}
private void setRem() {
	
	JFrame f1 = new JFrame();
	JPanel panel = new JPanel();
	ImagePanel p2 = new ImagePanel(new ImageIcon("3D-Glass-Ubuntu-Logo-Wallpaper (800x450).jpg").getImage());
	//panel.setSize(100, 100);
	f1.getContentPane().add(p2);
	f1.setSize(800, 500);
	f1.setLocation(50,50);
	
	
	f1.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel TimeLabel = new JLabel();
	TimeLabel.setFont(font2);
	TimeLabel.setText(" ENTER THE TIME FOR PERFORMNING THE TASK ");
	TimeLabel.setBounds(0, 0, 600, 20);
	TimeLabel.setLocation(10,10);
	TimeLabel.setForeground(Color.black);;
	p2.add(TimeLabel);
	
	JLabel HOURLabel = new JLabel();
	HOURLabel.setBounds(0, 0, 600, 20);
	HOURLabel.setLocation(10,70);
	HOURLabel.setForeground(Color.black);;
	HOURLabel.setFont(font);
	p2.add(HOURLabel);
	HOURLabel.setText("ENTER THE HOUR  (24hr FORMAT) :     ");
	Font font1 = new Font("Dialog" , Font.PLAIN , 10);
	JTextField jtb1 = new JTextField( 5);
	jtb1.setBounds(0, 0, 100, 28);
	jtb1.setLocation(350,65);
	
	
	jtb1.setFont(font1);
	p2.add(jtb1);
	JTextField jtf1 = new JTextField( 5);
	
	JLabel MINLabel = new JLabel();
	MINLabel.setBounds(0, 0, 600, 20);
	MINLabel.setLocation(10,120);
	MINLabel.setForeground(Color.black);;
	MINLabel.setFont(font);
	p2.add(MINLabel);
	MINLabel.setText("ENTER THE MINUTES :                          ");
	jtf1.setBounds(0, 0, 100, 28);
	jtf1.setLocation(350,115);
	jtf1.setFont(font1);
	p2.add(jtf1);
	
	
	f1.setVisible(true);
	
	jtf1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
			JFrame f2 = new JFrame("DESCRIPTION");
			JPanel panel = new JPanel();
			ImagePanel p3 = new ImagePanel(new ImageIcon("bright-apple-logo_1920x1080_2127-hd.jpg").getImage());
			//panel.setSize(100, 100);
			f2.getContentPane().add(p3);
			f2.setSize(1200,685);
			f2.setLocation(20,20);
			f2.setVisible(true);
			f2.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel BackLabel = new JLabel();
			//JLabel LastLabel = new JLabel();
			
			
			//f1.add(LastLabel);
			Font f1 = new Font("Dialog" , Font.BOLD | Font.ITALIC , 16 );

			JLabel jlab = new JLabel();
			
			jlab.setBounds(0,0,730,100);
			jlab.setLocation(10,10);
			p3.add(jlab);
			jlab.setFont(font2);
			
			jlab.setText("THE TASK IS TO BE SCHEDULED FOR THE TIME: " + jtb1.getText() + ":" + jtf1.getText());
			JLabel jTask = new JLabel();
			jTask.setText("SELECT ANY ONE TASK:");
			jTask .setBounds(0, 0, 200,25);
			jTask.setLocation(10 , 105);
			jTask.setFont(f1);
			p3.add(jTask);
			
			JCheckBox cb = new JCheckBox("SHUTDOWN PC");
			p3.add(cb);
			cb.setFont(font);
			cb.setBounds(0, 0, 140,25);
			cb.setLocation(10, 150);
			JLabel jlabSHUTDOWN = new JLabel();
			JLabel jlabRESTART= new JLabel();
			JLabel jlabSDT = new JLabel();
			JLabel jlabEM = new JLabel();
			JLabel jlabSMS = new JLabel();
			JLabel jlabOPEN = new JLabel();
			JLabel jlabCLOSE= new JLabel();
			JLabel jlabPC= new JLabel();
			
			jlabSHUTDOWN.setFont(font);
			jlabRESTART.setFont(font);
			jlabSDT.setFont(font);
			jlabEM.setFont(font);
			jlabSMS.setFont(font);
			jlabOPEN.setFont(font);
			jlabCLOSE.setFont(font);
			jlabPC.setFont(font);
			
			
			jlabSHUTDOWN.setForeground(Color.black);
			jlabRESTART.setForeground(Color.black);
			jlabSDT.setForeground(Color.black);
			jlabEM.setForeground(Color.black);
			jlabSMS.setForeground(Color.black);
			jlabOPEN.setForeground(Color.black);
			jlabCLOSE.setForeground(Color.black);
			jlabPC.setForeground(Color.black);

			cb.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabSHUTDOWN.setBounds(0, 0, 320,25);
					jlabSHUTDOWN.setLocation(170, 150);
					p3.add(jlabSHUTDOWN);
					if(cb.isSelected())
						jlabSHUTDOWN.setText(cb.getText() + " is the task to be performed.");
					else
						jlabSHUTDOWN.setText( "");

				}
			});


			JCheckBox cb1 = new JCheckBox("RESTART PC");
			p3.add(cb1);
			cb1.setFont(font);	
			cb1.setBounds(0, 0, 130,25);
			cb1.setLocation(10, 190);
			cb1.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabRESTART.setBounds(0, 0, 325,25);
					jlabRESTART.setLocation(170, 190);
					p3.add(jlabRESTART);
					
					if(cb1.isSelected())
						jlabRESTART.setText(cb1.getText() + " is the task to be performed.");
					else
						jlabRESTART.setText("");

				}
			});


			JCheckBox cb2 = new JCheckBox("SERIAL DATA TRANSMISSION(via COM-PORT)");
			cb2.setFont(font);
			cb2.setBounds(0, 0, 370,25);
			cb2.setLocation(10, 230);

			p3.add(cb2);
			cb2.setFont(font);
			cb2.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabSDT.setBounds(0, 0, 635,25);
					jlabSDT.setLocation(390, 230);
					p3.add(jlabSDT);
					
					if(cb2.isSelected())
						jlabSDT.setText(cb2.getText() + " is the task to be performed.");
					else
						jlabSDT.setText("");
				
				}
			});


			JCheckBox cb3 = new JCheckBox("SEND AN EMAIL");
			p3.add(cb3);
			cb3.setFont(font);
			cb3.setBounds(0, 0, 175,25);
			cb3.setLocation(10, 270);
			cb3.setFont(font);
			cb3.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabEM.setBounds(0, 0, 435,25);
					jlabEM.setLocation(190, 270);
					p3.add(jlabEM);
					
					if(cb3.isSelected())
						jlabEM.setText(cb3.getText() + " is the task to be performed.");
					else
						jlabEM.setText("");

				}
			});


			JCheckBox cb4 = new JCheckBox("SEND AN SMS");
			p3.add(cb4);
			cb4.setFont(font);
			cb4.setBounds(0, 0, 170,25);
			cb4.setLocation(10, 310);
			cb4.setFont(font);
			cb4.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabSMS.setBounds(0, 0, 435,25);
					jlabSMS.setLocation(195, 310);
					p3.add(jlabSMS);
					
					if(cb4.isSelected())
						jlabSMS.setText(cb4.getText() + " is the task to be performed.");
					else
						jlabSMS.setText("");

				}
			});


			JCheckBox cb5 = new JCheckBox("OPEN ANY EXE FILE");
			p3.add(cb5);
			cb5.setFont(font);
			cb5.setBounds(0, 0, 195,25);
			cb5.setLocation(10, 350);
			cb5.setFont(font);
			cb5.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabOPEN.setBounds(0, 0, 435,25);
					jlabOPEN.setLocation(220, 350);
					p3.add(jlabOPEN);
					
					if(cb5.isSelected())
						jlabOPEN.setText(cb5.getText() + " is the task to be performed.");
					else
						jlabOPEN.setText("");

				}
			});


			JCheckBox cb6 = new JCheckBox(" CLOSE ANY EXE FILE");
			p3.add(cb6);
			cb6.setFont(font);
			cb6.setBounds(0, 0, 200,25);
			cb6.setLocation(10, 390);
			cb6.setFont(font);
			cb6.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabCLOSE.setBounds(0, 0, 435,25);
					jlabCLOSE.setLocation(220, 390);
					p3.add(jlabCLOSE);
					
					if(cb6.isSelected())
						jlabCLOSE.setText(cb6.getText() + " is the task to be performed.");
					else
						jlabCLOSE.setText("");

				}	
			});
			
			JCheckBox cb7 = new JCheckBox(" SEND DATA TO OTHER PC");
			p3.add(cb7);
			cb7.setFont(font);
			cb7.setBounds(0, 0, 230,25);
			cb7.setLocation(10, 430);
			cb7.setFont(font);
			cb7.addItemListener(new ItemListener(){
				public void  itemStateChanged(ItemEvent ie){
					jlabPC.setBounds(0, 0, 435,25);
					jlabPC.setLocation(250, 430);
					p3.add(jlabPC);
					
					if(cb7.isSelected())
						jlabPC.setText(cb7.getText() + " is the task to be performed.");
					else
						jlabPC.setText("");

				}	
			});
			
			JButton OKbtn = new JButton("OK");
			OKbtn.setBounds(0, 0, 150, 30);
			OKbtn.setLocation(400, 570);
			OKbtn.setFont(font);
			p3.add(OKbtn);
			
			JLabel jlab4 = new JLabel();
			jlab4.setFont(font);
			jlab4.setBounds(0,0,600,100);
			jlab4.setLocation(10,465);
			p3.add(jlab4);
			jlab4.setText("YOU CAN ADD THE DESCRIPTION OF THE TASK:  ");
			
			JTextField jtb3 = new JTextField(20);
			jtb3.setBounds(0,0,320,30);
			jtb3.setLocation(390,500);
			p3.add(jtb3);
			
			
			String desc = jtb3.getText();
			
			
			BackLabel.setFont(font);
			p3.add(BackLabel);
			BackLabel.setBounds(0,0,650,30);
			BackLabel.setLocation(10, 530);
			BackLabel.setText("Press BACK button for RESCHEDULING the task");
			
			
			JButton jbtn1 = new JButton("BACK");
			jbtn1.setBounds(0, 0, 150, 30);
			jbtn1.setLocation(550, 570);
			jbtn1.setFont(font);
			p3.add(jbtn1);
			
			jtb3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					JLabel jdesc = new JLabel();
					jdesc.setFont(font);
					jdesc.setBounds(0, 0, 550, 30);
					jdesc.setLocation(10, 560);
					p3.add(jdesc);
					jdesc.setText("The task description has been added");
					}
			});
			jbtn1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					jtb1.setText("");
					jtb3.setText("");
					jtf1.setText("");
					jlab.setText("");
					if(cb.isSelected()){
						cb.doClick();
					}
					if(cb1.isSelected()){
						cb1.doClick();
					}
					if(cb2.isSelected()){
						cb2.doClick();
					}
					if(cb3.isSelected()){
						cb3.doClick();
					}
					if(cb4.isSelected()){
						cb4.doClick();
					}
					if(cb5.isSelected()){
						cb5.doClick();
					}
					if(cb6.isSelected()){
						cb6.doClick();
					}
					if(cb7.isSelected()){
						cb7.doClick();
					}
					
					BackLabel.setFont(font);
					BackLabel.setText("Close this window and go to the previous window for RESCHEDULING your task");
					
				}
			});
			
			OKbtn.addActionListener(new ActionListener (){
				public void actionPerformed(ActionEvent ae){
					String txtHOUR = jtb1.getText();
					String txtMIN  = jtf1.getText();
					if(cb.isSelected()){
						Timer timer1 = new Timer();
						TimerTask tt1 = new TimerTask() {
							public void run() {
								
								Calendar cal = Calendar.getInstance();
								
								Integer hour = cal.get(Calendar.HOUR_OF_DAY);
								Integer min = cal.get(Calendar.MINUTE);
								
								String strHOUR ,strMIN;
								strHOUR = hour.toString();
								strMIN = min.toString();
								
								if(strHOUR.equals(txtHOUR) )
								{
									if(strMIN.equals(txtMIN) )
									{
										
										// Create Runtime object
										 Runtime r =Runtime.getRuntime();

										 // Shutdown system
										//Process proc =r.exec("shutdown -s");
										 try {
											r.exec("shutdown -s");
											 } catch (IOException e) {
											 // TODO Auto-generated catch block
											 e.printStackTrace();
											 }
										
									}
								}
							}
						};
						timer1.schedule(tt1, 1000,5000);
					}
				
					if(cb1.isSelected()){
						Timer timer2 = new Timer();
						TimerTask tt2 = new TimerTask() {
							public void run() {
								
								Calendar cal = Calendar.getInstance();
								
								Integer hour = cal.get(Calendar.HOUR_OF_DAY);
								Integer min = cal.get(Calendar.MINUTE);
								
								String strHOUR ,strMIN;
								strHOUR = hour.toString();
								strMIN = min.toString();
								
								if(strHOUR.equals(txtHOUR) )
								{
									if(strMIN.equals(txtMIN) )
									{
										
										// Create Runtime object
										 Runtime r1=Runtime.getRuntime();

										 // Shutdown system
										//Process proc =r.exec("shutdown -s");
										 try {
											 // Restart system
											  r1.exec("shutdown -r");

											 } catch (IOException e) {
											 // TODO Auto-generated catch block
											 e.printStackTrace();
											 }
										
									}
								}
							}
						};
						timer2.schedule(tt2, 1000,5000);
					}
					
					if(cb2.isSelected()){
						
						
						
					}
					
					if(cb3.isSelected()){
						
						
						
					}
					
					if(cb4.isSelected()){
						
						
						
						
					}
					
					if(cb5.isSelected()){
						
						JFrame frame = new JFrame("OPENFILE");
						JPanel jp = new JPanel();
						ImagePanel p4 = new ImagePanel(new ImageIcon("java_logo-1920x1080-88 (800x450).jpg").getImage());
						frame.getContentPane().add(p4);
						frame.setLocation(50, 50);
						frame.setSize(650, 400);
						frame.setVisible(true);
						
						JLabel jlabopen = new JLabel();
						jlabopen.setText("ENTER THE NAME OF THE FILE THAT YOU WANT TO OPEN");
						jlabopen.setBounds(0, 0, 700, 30);
						jlabopen.setLocation(20, 20);
						jlabopen.setFont(font);
						p4.add(jlabopen);
						
						JTextField jtfopen = new JTextField();
						jtfopen.setBounds(0,0,400,30);
						jtfopen.setLocation(20, 80);
						p4.add(jtfopen);
						
						jtfopen.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae){
								
								
								
							}
						});
						
						JButton openBtn = new JButton("OK");
						openBtn.setBounds(0,0,150,40);
						openBtn.setLocation(150,300);
						p4.add(openBtn);
						
						openBtn.addActionListener(new  ActionListener() {
							public void actionPerformed(ActionEvent ae){
								
								String openTxt = jtfopen.getText() + ".exe";
								Timer timer3 = new Timer();
								TimerTask tt3 = new TimerTask() {
									public void run() {
										
										Calendar cal = Calendar.getInstance();
										
										Integer hour = cal.get(Calendar.HOUR_OF_DAY);
										Integer min = cal.get(Calendar.MINUTE);
										
										String strHOUR ,strMIN;
										strHOUR = hour.toString();
										strMIN = min.toString();
											System.out.println(strHOUR);
											System.out.println(txtHOUR);
											System.out.println(strMIN);
											System.out.println(txtMIN);
											
										if(strHOUR.equals(txtHOUR) )
										{
											if(strMIN.equals(txtMIN) )
											{
												
												// Create Runtime object
												 Runtime r2  = Runtime.getRuntime();
												 
												 try {
													
													 r2.exec(openTxt);

													 } catch (IOException e) {
													 // TODO Auto-generated catch block
													 e.printStackTrace();
													 }
												
											}
										}
									}
								};
								timer3.schedule(tt3, 1000);
							
							}
						});
						
					}
					
					if(cb6.isSelected()){
						
						/*JFrame frame2 = new JFrame("CLOSEFILE");
						JPanel jp = new JPanel();
						ImagePanel p5 = new ImagePanel(new ImageIcon("java_logo-1920x1080-88 (800x450).jpg").getImage());
						frame2.getContentPane().add(p5);
						frame2.setLocation(50, 50);
						frame2.setSize(650, 400);
						frame2.setVisible(true);
						
						JLabel jlabclose = new JLabel();
						jlabclose.setText("ENTER THE NAME OF THE FILE THAT YOU WANT TO CLOSES");
						jlabclose.setBounds(0, 0, 700, 30);
						jlabclose.setLocation(20, 20);
						jlabclose.setFont(font);
						p5.add(jlabclose);
						
						JTextField jtfclose = new JTextField();
						jtfclose.setBounds(0,0,400,30);
						jtfclose.setLocation(20, 80);
						p5.add(jtfclose);
						
						jtfclose.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae){
								
								
								
							}
						});
						
						JButton closeBtn = new JButton("OK");
						closeBtn.setBounds(0,0,150,40);
						closeBtn.setLocation(150,300);
						p5.add(closeBtn);
						
						closeBtn.addActionListener(new  ActionListener() {
							public void actionPerformed(ActionEvent ae){
								*/
						Timer timer1 = new Timer();
						TimerTask tt1 = new TimerTask() {
							public void run() {
								
								Calendar cal = Calendar.getInstance();
								
								Integer hour = cal.get(Calendar.HOUR_OF_DAY);
								Integer min = cal.get(Calendar.MINUTE);
								
								String strHOUR ,strMIN;
								strHOUR = hour.toString();
								strMIN = min.toString();
								
								if(txtHOUR.equals(strHOUR) )
								{
									if(txtMIN.equals(strMIN) )
									{
										
									
									}
								}
							}
						};
						timer1.schedule(tt1, 1000);
						
					}
					
					if(cb7.isSelected()){
						
							
					}
				}
				
			});
		}
		});
}
});
}

public static void main(String args[]) {
		
	 Connection c = null;
	    Statement stmt = null;
	
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	    //  System.out.println("Opened database successfully");

	   
	SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		new TaskScheduler();
	}	  
});
}
}

class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

}

