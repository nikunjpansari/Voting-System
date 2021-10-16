/****************************************************************************************
*	Class: Candidates , ServerSideGUI
*	Project: On Line Voting System
*   Language: JAVA.
*	Year: 2007-2008
*
*	Use this project module for Adding Candidate in any OnLine voting system purposes.
*	Feel free to distribute and re-distribute this project.
*	Feel free to add new features.
*	Suggestions are welcomed.
*
*	Redistribution and use in source and binary forms, with or
*	without modification, are permitted provided that the following
*	conditions are met:
*
*	-the Code is Readable.
*	-the Code is Reusuable.
*
*	Your acknowledge that Software is not designed
*	intended for use in the design, construction, operation or
*	maintenance of any nuclear facility.
*   
******************************************************************************************/




import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.sql.*;

public class Candidates extends JFrame implements ActionListener {

	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu helpMenu;
	protected JMenuItem mnuExit,mnuAbt,mnuHelp;	
    protected JTextField nText,dText;
	protected String cname,cdsc;	
	private JButton cAdd,cEdit,Edit; 
	private	int cnt =0,l =0,i =0,flag =0,editNo=1,cnt1,cnt2,f=0,q=0;
	
	private JButton storeEditBtn[] = new JButton[20];
	private JTextField canName[] = new JTextField[20];
	private JTextField canDsc[] = new JTextField[20];
	
	private JPanel mainPanel,fistPanel,scndPanel,thidPanel,fourthPanel,cPanel,namePanel,cButtonPanel,cAddPanel,nameAddPanel,cAddButtonPanel,newcPanel,cHeadPanel;
	private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String sql,s1,s2;	
	protected String candNameArray[] = new String[20]; 
	protected String candDscArray[] = new String[20];
 /************************************************************************************** 
  *Costructor of Class 
  ***************************************************************************************/
    
    public Candidates() {
		
	setTitle("Candidate Information");
	setSize(800,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	buildWindow();
	getConnection();
    setupMenuBar();
	setVisible(true);
	
	}
	
/****************************************************************************************
 * This Function purpose is for Getting Connection For pertucular DSN 
 ****************************************************************************************/
    
    protected void getConnection() {
		   
    try {
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:voting");
    System.out.println("DataBase is connected"); 
	}	       
    catch(Exception e){
 	
 	System.out.println("JDBC:ODBC driver failed to load.");
    return; }
    
    try{
                
    stmt = con.createStatement();}
 
 	catch(Exception e) {
 	               
 	e.printStackTrace();
    return;}
               
   }  

/***************************************************************************************** 
 *this Function can build Main GUI of System 
 ******************************************************************************************/	
 
  protected void buildWindow() {
	
  		mainPanel = new JPanel();
  	    mainPanel.setLayout(new BorderLayout());
		fistPanel = new JPanel();
		fistPanel.setLayout(new BoxLayout(fistPanel,BoxLayout.X_AXIS));
		fistPanel.setBorder(BorderFactory.createEtchedBorder());
		fistPanel.add(createProp());
		thidPanel = new JPanel();
		thidPanel.setLayout(new BoxLayout(thidPanel,BoxLayout.Y_AXIS));
		
		
		thidPanel.add(Box.createHorizontalStrut(20));
		JLabel title = new JLabel("CANDIDATE PANEL",JLabel.RIGHT);
		title.setForeground(Color.red);
		title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
		thidPanel.add(title);
		
	    
	    JButton btn;
        btn = new JButton( new ImageIcon( getClass().getResource("/icons/LINE42.gif") ) );
        thidPanel.add(btn);
		
		fourthPanel = new JPanel();
		fourthPanel.setLayout(new FlowLayout());
		cAdd = new JButton(new ImageIcon( getClass().getResource("/icons/BLANNEXT.gif") ) );
	    cAdd.setText("ADD");
		cAdd.addActionListener(this);
		fourthPanel.add(cAdd);
		scndPanel = new JPanel();
		scndPanel.setLayout(new BorderLayout());
		JButton Edit1 = new JButton("Edit");
		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);
		scndPanel.add("North",informationFields(Edit1,text1,text2));
		mainPanel.add("Center",scndPanel);
		mainPanel.add("North",thidPanel);
	    mainPanel.add("East",fourthPanel);
		getContentPane().add(mainPanel);
	}

/****************************************************************************************
 * this function can used to set the Property for perticular Candidate 
 ****************************************************************************************/	

protected  JPanel createProp() {
		
		JPanel propPanel = new JPanel();
		propPanel.setLayout(new BoxLayout(propPanel,BoxLayout.Y_AXIS));
		JLabel prop = new JLabel("Hello");
		propPanel.add(prop);
		JLabel prop1 = new JLabel("Hi");
		propPanel.add(prop1);
		JLabel prop2 = new JLabel("Hmmm");
		propPanel.add(prop2);
		return propPanel;
	}

/*****************************************************************************************
 *This function Cand Handle the Working of System 
 *****************************************************************************************/
	
protected JPanel informationFields(JButton edit,JTextField  k1,JTextField k2) {
		
		cHeadPanel = new JPanel();
		cHeadPanel.setLayout(new BoxLayout(cHeadPanel,BoxLayout.Y_AXIS));
	  	cPanel = new JPanel();
		cPanel.setLayout(new BorderLayout());
		cPanel.add(Box.createVerticalStrut(5));
		cPanel.setBorder(BorderFactory.createEtchedBorder());	
		namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(2,2,0,10));
		JLabel cName = new JLabel("Enter Candidate Name:");
		cName.setForeground(Color.blue);
		cName.setFont(new Font("MonoSpaced",Font.BOLD,15));
		namePanel.add(cName);
		namePanel.add(k1);
		JLabel cDsc = new JLabel("Enter Candidate Description:");
		cDsc.setForeground(Color.blue);
		cDsc.setFont(new Font("MonoSpaced",Font.BOLD,15));
		namePanel.add(cDsc);
		namePanel.add(k2);
		cButtonPanel =new JPanel();
		cButtonPanel.setLayout(new BoxLayout(cButtonPanel,BoxLayout.Y_AXIS));
		cButtonPanel.add(Box.createVerticalStrut(5));
		storeReference(edit,k1,k2);   
		edit.addActionListener(this);
		cButtonPanel.add(edit);
		cPanel.add("West",namePanel);
		cPanel.add("East",cButtonPanel);
		cHeadPanel.add(cPanel);
		
		return cHeadPanel;
	}  

/***************************************************************************************** 
 *This Function Can Working is stored in, Particular reference
 *i.e. All Edit button and  Name ,description 
 *with help of this we can easily understand the system,i.e which editing task is performed .
 ******************************************************************************************/
 	
 protected void storeReference(JButton edit,JTextField k3,JTextField k4) { 
	     
	    i = i+1;
	    storeEditBtn[i] = edit;
		canName[i] = k3;
	//	String s1=canName[0].getText();
	//	System.out.println("Nmae"+s1);
	    canDsc[i] = k4;
	}  

/*****************************************************************************************
 * this function is used to Set the menuBar 
 *****************************************************************************************/

protected void setupMenuBar() {

	menuBar = new JMenuBar();
	fileMenu = new JMenu("File");
	helpMenu = new JMenu("Help");
	
/*************************Add menu in menu bar******************************************/ 			
    
    mnuAbt=new JMenuItem("About");
 	mnuAbt.addActionListener(this);
 	mnuAbt.setMnemonic('A');
 	fileMenu.add(mnuAbt);
 	
/**************************Add menu item in menubar**************************************/ 	   
   
    mnuExit=new JMenuItem("Exit");
    mnuExit.addActionListener(this);
    mnuExit.setMnemonic('E');
    fileMenu.add(mnuExit);
 	       
    mnuHelp=new JMenuItem("help");
    mnuHelp.addActionListener(this);
    mnuHelp.setMnemonic('h');
    helpMenu.add(mnuHelp);
 	 	   
    menuBar.add(fileMenu);
	menuBar.add(helpMenu);
	
/*****************************Set menuBar**************************************************/

	setJMenuBar(menuBar);
  }

/*****************************This is our faivarate Main Method**************************/

/*public static void main(String [] args) {
	
Candidates c = new Candidates();
		
}*/

/*******************************Editable Function for particular Candidate****************/

 protected void SetEditable(int editRefCounter)	{
	
	int k1=editRefCounter;
	System.out.println("Enter In The FunctionEditabel"+editRefCounter);			  	
	if(flag==0) {
				  	
	  	canName[editRefCounter].setEditable(true);
		canDsc[editRefCounter].setEditable(true);
		canName[editRefCounter].requestFocus();
		flag++;
		}
	else {
			         
			try {	
			
				   sql = "UPDATE Candidate SET candidate_Name='"+canName[k1].getText()+"',candidate_Dsc='"+canDsc[k1].getText()+"' where candidate_id="+k1;
                   stmt.executeUpdate(sql);
                   System.out.println("Record updated successfully...");
                   
			    }
			catch(SQLException e) {
			 	
              	    System.out.println("Data Base is thoows exc...");
                
             } 
             canName[editRefCounter].setEditable(false);
			 canDsc[editRefCounter].setEditable(false);
			flag=0;  
	     }
			
    }

public void actionPerformed(ActionEvent ae) {
	
/********************************About information**************************************/
	 if(ae.getSource()==mnuAbt) {
		
		String msg ;
		msg  = "# This Panel Is Working on Server Side .\n";
		msg += "# The purpose of this panel to Add Candidate for Perticular VotingPanel.\n";
		msg += "# It maintain all Candidates Information\n";
		msg += "# Developed using New I/O technologies and doing voting\n";
		JOptionPane.showMessageDialog(null, msg, " Client", JOptionPane.INFORMATION_MESSAGE );
		}
	
	
/********************************Menu Exit************************************************/
	     	
       if(ae.getSource()==mnuExit) {
       	
         int ai= JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", " Client Model", JOptionPane.YES_NO_OPTION);
		 if(ai==0)
		 System.exit(0);
		 }
	
/*********************************Menu Help**********************************************/

	if (ae.getSource()==mnuHelp) 
	{
		
	String msg ;
		msg  = "# This Panel Is Working on Server Side .\n";
		msg += "# we can Add the one by one candidate by clicking add button \n";
		msg += "# If you want editing perticuler candidate then clicking on edit button\n";
	JOptionPane.showMessageDialog(null, msg, " Client", JOptionPane.INFORMATION_MESSAGE );
		}  
		
/***********************************Add Candidate****************************************/
	
	if(ae.getSource()==cAdd) {
				 
	     cnt=cnt+1;
	     
	     
		 nText = new JTextField(20);
		 dText = new JTextField(20);
		 nText.setEditable(true);
		 dText.setEditable(true);
		 Edit=new JButton("Edit");
		 cHeadPanel.add(informationFields(Edit,nText,dText));
		 validate();
		 
		 nText.requestFocus();
	     
		 s1=canName[cnt].getText();
		 s2=canDsc[cnt].getText();
		 
		 
		 candNameArray[f] = s1;
		 
		
		 
		 
		 candDscArray[q] = s2;
		 
		 
		// System.out.println(s1);
	//	 System.out.println(s2);
		 
		 //System.out.println("DDDDDDD"+candNameArray[f]);
		 f++;
		// System.out.println("DDDDDDD"+candDscArray[q]);
		 q++;
		 
		// System.out.println(cn[1]);
		 //System.out.println(cd[1]);
		 
		 
		 
		 
		 try {
		   			
		   	sql = "SELECT *FROM Candidate"; 
            rs = stmt.executeQuery(sql);
              while(rs.next()) {
               	cnt1=Integer.parseInt(rs.getString(1));
              }	
              
             		
   			cnt2=cnt1+1;
			sql="Insert into Candidate values("+cnt2+",'"+s1+"','"+s2+"')";
			stmt.executeUpdate(sql);
		    System.out.println("Record inserted successfully...");
		  }
	    catch(SQLException e) {
              	          
           System.out.println("Data Base is thoows exc...");
        }   
	    if(cnt>l) {
			
			canName[cnt].setEditable(false);
			canDsc[cnt].setEditable(false);
			l=l+1;
		}
	}
     		
/***********************************Edit TextField ie Update DataBase**********************/	
	    
	  
	    	if(ae.getSource()==storeEditBtn[1]) {	
		  
		        SetEditable(1);
		         candNameArray[1] =canName[1].getText();
		         candDscArray[1] = canDsc[1].getText();
		          System.out.println(candNameArray[1]);
		         
	        }
	        if(ae.getSource()==storeEditBtn[2]) {	
		  
		        SetEditable(2);
		         candNameArray[2] =canName[2].getText();
		         candDscArray[2] = canDsc[2].getText();
		          System.out.println(candNameArray[2]);
	        }
	        if(ae.getSource()==storeEditBtn[3]) {	
		  
		        SetEditable(3);
		         candNameArray[3] =canName[3].getText();
		         candDscArray[3] = canDsc[3].getText();
		          System.out.println(candNameArray[3]);
	        }
	        if(ae.getSource()==storeEditBtn[4]) {	
		  
		        SetEditable(4);
		         candNameArray[4] =canName[4].getText();
		         candDscArray[4] = canDsc[4].getText();
		          System.out.println(candNameArray[4]);
	        }
	        if(ae.getSource()==storeEditBtn[5]) {	
		  
		        SetEditable(5);
		         candNameArray[5] =canName[5].getText();
		         candDscArray[5] = canDsc[5].getText();
		          System.out.println(candNameArray[5]);
	        }
	        if(ae.getSource()==storeEditBtn[6]) {	
		  
		        SetEditable(6);
		         candNameArray[6] =canName[6].getText();
		         candDscArray[6] = canDsc[6].getText();
		          System.out.println(candNameArray[6]);
	        }
	        if(ae.getSource()==storeEditBtn[7]) {	
		  
		        SetEditable(7);
		         candNameArray[7] =canName[7].getText();
		         candDscArray[7] = canDsc[7].getText();
		          System.out.println(candNameArray[7]);
	        }
	        if(ae.getSource()==storeEditBtn[8]) {	
		  
		        SetEditable(8);
		         candNameArray[8] =canName[8].getText();
		         candDscArray[8] = canDsc[8].getText();
		          System.out.println(candNameArray[8]);
	        }
	        if(ae.getSource()==storeEditBtn[9]) {	
		  
		        SetEditable(9);
		         candNameArray[9] =canName[9].getText();
		         candDscArray[9] = canDsc[9].getText();
		          System.out.println(candNameArray[9]);
	        }			
	
/*****************************************************************************************/		
						
/*	if(ae.getSource()==j3[2])
				{
			if(flag==0)
			{
				System.out.println("HELLO EDIT ACTIVATED 2");
				canName[2].setEditable(true);
			    canDsc[2].setEditable(true);
			   flag++;
			   }
			    else
			        {
			         
			try {	
 	             
 	               sql = "UPDATE Candidate SET candidate_Name='"+canName[2].getText()+"',candidate_Dsc='"+canDsc[2].getText()+"' where candidate_id="+2;
                   stmt.executeUpdate(sql);
                   System.out.println("Record updated successfully...");
			    }
			     	
			catch(SQLException e) {
				
              	             System.out.println("Data Base is thoows exc...");
                
                                  } 
                  canName[2].setEditable(false);
				  canDsc[2].setEditable(false);
				  flag=0;  
			     	}
			     	
			    }
		*/
			   
  } /* End of Action Performed*/	
	
}  /* End of main Class*/	
	
	
	

	
	
	