/***************************************************************************************
*	Class: Registration ,ClientSide
*	Project: On Line Voting System
*   Language: JAVA.
*	Year: 2007-2008
*
*	Use this project module for Used registration purposes.
*	The Result Can be show accourding its value ie hear result will show accourding to voting.
*	Feel free to distribute and re-distribute this project.
*	Feel free to add new features.
* -	Suggestions are welcomed.
*
*	Redistribution and use in source and binary forms, with or
*	without modification, are permitted provided that the following
*	conditions are met:
*
*   Feature: 
*	-the Code is Reusuable.
*   -the Code is Readable.
*	
*	You acknowledge that Software is not designed
*	intended for use in the design, construction, operation or
*	maintenance of any nuclear facility.
*   
******************************************************************************************/





import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class Register extends JFrame implements ActionListener
 {   
    private JMenu mnuHelp;
 	private JMenu mnuFiles;
	private JMenuBar menubar;
	private JMenuItem mnuForm;
	private JMenuItem mnuAbt;
	private JMenuItem mnuExit;
	private JMenuItem Help;
	private JButton button[]=new JButton[20];	
	private JTextField text[]=new JTextField[20];
	private JComboBox nationCombo = new JComboBox();
    private JLabel label[]=new JLabel[20];
	private int i=0,j=0,k=0;

/*******************Contructor Of mainClass***********************************************************/	
	
	public Register()
	{	
	
	   
		super("Voting System - Voter Registration");
		Container con = getContentPane();
		con.setLayout(null);
		 
/****************************set menubar**************************************************/
           
           menubar=new JMenuBar();
           setJMenuBar(menubar);
        
/************************* Add menu in menubar*********************************************/
 	 	
 	 	mnuHelp = new JMenu("Help");
		mnuHelp.setMnemonic('H');
		mnuFiles = new JMenu("Files");
		mnuFiles.setMnemonic('F');

/**************************Add menuitem in menubar****************************************/
 	 
 	 	mnuForm=new JMenuItem("New Registration Form");
 	 	mnuForm.setMnemonic('R');
 	 	mnuFiles.add(mnuForm);
 	 	mnuForm.addActionListener(this);
 	 
 	 	mnuAbt=new JMenuItem("About");
 	 	mnuAbt.setMnemonic('A');
 	 	mnuFiles.add(mnuAbt);
 	 	mnuAbt.addActionListener(this);
 	 	
 	 	mnuExit=new JMenuItem("Exit");
 	 	mnuExit.setMnemonic('E');
 	    mnuFiles.add(mnuExit);
 	    mnuExit.addActionListener(this);
 	    
 	    Help=new JMenuItem(" About help F1");
        //Help.addActionListener(this);
 	    Help.setMnemonic('F');
 	    mnuHelp.add(Help);
 	    
 	    menubar.add(mnuFiles);
 	 	menubar.add(mnuHelp);
 	 	
     	label[i]=new JLabel("VOTER    REGISTRATION    PROCESS");
 	 	label[i].setFont(new Font("TimesNewRoman",Font.BOLD,20));
 	 	label[i].setBounds(220,20,650,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	
 	 	label[i]=new JLabel("# A User has to Register Himself before He is ellegibe for Voting.");
 	 	label[i].setFont(new Font("MonoSpaced",Font.BOLD,15));
 	 	label[i].setBounds(45,63,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	 
 	 	label[i]=new JLabel("# A User Has to fill following Entries in order to Register Himself as Voter. ");
 	 	label[i].setFont(new Font("MonoSpaced",Font.BOLD,15));
 	 	label[i].setBounds(45,88,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	
 	 	label[i]=new JLabel("# A User Has to fill Correct Entries in  Corresponding TextFields in order to Register Himself as Voter. ");
 	 	label[i].setFont(new Font("MonoSpaced",Font.BOLD,12));
 	 	label[i].setBounds(45,120,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	
 	 	
 	 	label[i]=new JLabel("1.Voter Name:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,165,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	
 	 	text[j]=new JTextField(20);
 	 	text[j].setBounds(160, 165, 210, 20);//(z,y,w,h)
 	    text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
/**********************************Validation code For JtextField****************************/
 	    
 	    	text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ) && (c <='Z'||c <='z' ) ||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
				j=j+1;
 	    label[i]=new JLabel("3.VoterID:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,200,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	    text[j]=new JTextField(20);
 	 	text[j].setBounds(160, 200, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
 	    	text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ||c >= '0' ||c >= '9' ) && (c <='Z'||c <='z' ) ||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    
 	    
 	    j=j+1;
 	    
 	    label[i]=new JLabel("5.Password:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,250,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	    text[j]=new JPasswordField(20);
 	 	text[j].setBounds(160, 250, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    j=j+1;
 	    
 	    label[i]=new JLabel("6.Voter Phone No.:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,300,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	    text[j]=new JTextField(20);
 	 	text[j].setBounds(160, 300, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
 	    text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if(!((c >= '0' && c <='9' )||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    
 	    
 	    
 	    
 	    
 	    j=j+1;
 	    
 	    label[i]=new JLabel("7.Voter Adderess:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,350,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	    text[j]=new JTextField(20);
 	 	text[j].setBounds(160, 350, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ||c >= '0' ||c >= '9' ) && (c <='Z'||c <='z' ) ||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    j=j+1;
 	    
 	    label[i]=new JLabel("8.Date of Birth:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,400,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	   	text[j]=new JTextField(20);
 	 	text[j].setBounds(160, 400, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
 	    text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ||c >= '0' ||c >= '9' ) && (c <='Z'||c <='z' )||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    j=j+1;
 	    
 	    
 	    
 	    label[i]=new JLabel("9.Nationality:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(15,450,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	     	
 	    nationCombo.addItem("India");
 	    nationCombo.addItem("USA"); 
 	    nationCombo.addItem("England"); 
 	    nationCombo.addItem("Pakistan"); 
 	    nationCombo.addItem("Russia"); 
 	    nationCombo.addItem("Japan"); 
 	    nationCombo.addItem("China"); 
 	    nationCombo.addItem("Brazil");  
 	    nationCombo.addItem("Germany");
 	    nationCombo.setBounds(160, 450, 210, 20);
 	    con.add(nationCombo); 	
 	  
 	    j=j+1;
 	    
 	    label[i]=new JLabel("2.Voter Middle Name:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(400,165,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	 	 	    
 	    text[j]=new JTextField(20);
 	 	text[j].setBounds(560, 165, 210, 20);//(z,y,w,h)
 	    text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
 	    
 	    	text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ) && (c <='Z'||c <='z' ) ||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    j=j+1;
 	    
 	    label[i]=new JLabel("4.Voter Last Name:");
 	 	label[i].setFont(new Font("Arial",Font.ITALIC,15));
 	 	label[i].setBounds(400,200,750,30);
 	 	con.add(label[i]);
 	 	i=i+1;
 	    
 	    text[j]=new JTextField(20);
 	 	text[j].setBounds(560, 200, 210, 20);//(z,y,w,h)
 	 	text[j].setFont(new Font("Arial",Font.BOLD,13));
 	    con.add(text[j]);
 	    
 	    
 	    
 	    	text[j].addKeyListener(new KeyAdapter() {
 			    public void keyTyped(KeyEvent e) {
 			      char c = e.getKeyChar();
 			      
 			      if (!((c >= 'A' ||c >= 'a' ) && (c <='Z'||c <='z' ) ||
 			        (c == KeyEvent.VK_BACK_SPACE) ||
 			         (c == KeyEvent.VK_DELETE))) {
 			        getToolkit().beep();
 			        e.consume();
 			      }
 			    }
 			  });
 	    j=j+1;
 	    
 	    button[i]=new JButton("Register");
 	    button[i].setBounds(560,480,100,30);
 	    con.add(button[i]);
 	    
 	    System.out.println("I: "+i);
 	 	System.out.println("J: "+j);
 		System.out.println("K: "+k);
 		
  	 	
 	 
 	 	addWindowListener(new WindowAdapter()
        {	
                public void windowClosing(WindowEvent e)
                {
                     System.exit(0);
                }
        });
           
/******************************main Jframe***********************************************/
        
        setSize(800,600);
        setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae)
        {    
          
             
             
            
        	if(ae.getSource()==mnuForm)
        	{   
        	   for(k=0;k<20;k++)
        	   {
        	   
        		text[k].setText("");
               	}
              }
               if(ae.getSource()==mnuExit)
               {
               	
				int ai= JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", " Client Model", JOptionPane.YES_NO_OPTION);
				if(ai==0)
			  	System.exit(0);
               }
             /******************About****************/
			if(ae.getSource()==mnuAbt)
			{
				String msg ;
				msg = "#  This is a Voter Registration Panel \n";
				msg += "# This pannel can be Used by User to Register Himself as Voter.\n";
				msg += "#  The Voter id,phone no, should be a Integer value\n";
				msg += "#  The Birth Date of a Voter should be in format of   26Sep1987\n";
				JOptionPane.showMessageDialog(null, msg, " Client", JOptionPane.INFORMATION_MESSAGE );
			}
                         
              		      
         }			
        	
        	public static void main(String args[])
        {
                new Register();
        }
        	
/**********************Handle the KeyPressed Event with help of Verifier*****************/
        	
        	private class StrictInputVerifier extends InputVerifier {
        	    private String validString;

        	    public StrictInputVerifier(String validString) {
        	        this.validString = validString;
        	    }

        	    public boolean verify(JComponent input) {
        	    	System.out.println("FD");
        	        JTextField textField = (JTextField) input;
        	        boolean retCode = false;
        	        try {
        	        	Integer.parseInt(textField.getText());
        	        	retCode = true;
        	        }
        	        catch(Exception e) {
        	        	
        	        }
        	        return retCode;
        	        
        	        }
        	}
 }



