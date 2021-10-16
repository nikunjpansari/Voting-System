/***************************************************************************************
*	Class: AddPanel , ServerSideGUI
*	Project: On Line Voting System
*   Language: JAVA.
*	Year: 2007-2008
*
*	Use this project module for Adding Panel in any OnLine voting system purposes.
*	Feel free to distribute and re-distribute this project.
*	Feel free to add new features.
*	Suggestions are welcomed.
*
*	Redistribution and use in source and binary forms, with or
*	without modification, are permitted provided that the following
*	conditions are met:
*
*	Future:-
*	-the Code is Reusuable.
*
*	You acknowledge that Software is not designed
*	intended for use in the design, construction, operation or
*	maintenance of any nuclear facility.
*   
******************************************************************************************/




import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.io.*; 

 
public class AddPanel extends JFrame implements ActionListener {
 
  protected JButton plus;
  protected String panelName,Pname;
  protected int id,cnt;
  protected JTextField votingPanelDscTxt,votingPanelTxt;
  protected JLabel votinPanel; 
  protected JLabel votinPanelDsc;
  protected JLabel votinHPanel;
  protected Connection con;
  protected Statement stmt;
  protected ResultSet rs;
  protected String sql;
  protected JPanel bigPanel = new JPanel();
  protected JPanel infoHPanel = new JPanel();
  protected JPanel infoLPanel = new JPanel();
  protected JPanel infoTPanel = new JPanel();
  protected JPanel infoL1Panel = new JPanel();
  protected JPanel infoT1Panel = new JPanel();
  protected JPanel infoPanel = new JPanel();
  protected JPanel vbuttonPanel = new JPanel(); 
  
/****************************************************************************************
   *Constructor of Class 
****************************************************************************************/

public AddPanel() {
	
  super("Add Voting Panel");
  getConnection();
  generateWindow();
  pack();
  setSize(400,500);
  setVisible(true);
  setResizable(false);
  setLocation((800-285)/2,(600-285)/2);
  pack();
}

/***************************************************************************************** 
 *This method Support the Connect to the DSN 
 ***************************************************************************************/ 
    
protected void getConnection() {
		   
 try  {
	  
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con=DriverManager.getConnection("jdbc:odbc:voting");
      System.out.println("DataBase is connected"); }
		       
 catch(Exception e){
 	
 		System.out.println("JDBC:ODBC driver failed to load.");
        return; }
 try{
                
     stmt = con.createStatement();}
 
 catch(Exception e) {
 	               
 	 e.printStackTrace();
     return;}
               
 }  
   
 /*******************************************************************************************
  *This Function is Builld the Main Gui of Class
  *****************************************************************************************/
    
protected void generateWindow() {
	
   	 bigPanel.setLayout(new BorderLayout());
   	 bigPanel.setBackground(Color.red);
   	 infoPanel.setLayout(new BoxLayout(infoPanel,BoxLayout.Y_AXIS));
     infoPanel.setBorder(BorderFactory.createEtchedBorder());
     infoPanel.add(Box.createVerticalStrut(10));
   	 infoHPanel.setLayout(new FlowLayout());
   	 infoHPanel.add(Box.createVerticalStrut(100));
   	 infoLPanel.setLayout(new FlowLayout());
   	 infoTPanel.setLayout(new FlowLayout());
   	 infoL1Panel.setLayout(new FlowLayout());
   	 infoT1Panel.setLayout(new FlowLayout());
   	 
   	 votinHPanel = new JLabel("ADD VOTING PANEL");
   	 votinHPanel.setForeground(Color.red);
   	 votinHPanel.setFont(new Font("Times New Roman",Font.BOLD,25));
   	 infoHPanel.add(votinHPanel);
   	 
   	 votinPanel = new JLabel("Voting Panel Name:");
   	 votinPanel.setForeground(Color.blue);
   	 votinPanel.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
   	 infoLPanel.add(votinPanel);
   	 
   	 votingPanelTxt = new JTextField(20);
   	 votingPanelTxt.setForeground(Color.red);
   	 infoTPanel.add(votingPanelTxt);
   	 
   	 votinPanelDsc = new JLabel("Voting Panel Description:") ;
   	  votinPanelDsc.setForeground(Color.blue);
   	 votinPanelDsc.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
   	 infoL1Panel.add(votinPanelDsc);
   	 
   	 votingPanelDscTxt = new JTextField(30);
   	 votingPanelDscTxt.setForeground(Color.red);
   	 infoT1Panel.add(votingPanelDscTxt);
   	 
   	 infoPanel.add(infoHPanel);
   	 infoPanel.add(infoLPanel);
   	 infoPanel.add(infoTPanel);
   	 infoPanel.add(infoL1Panel);
   	 infoPanel.add(infoT1Panel);
   	 
   	 bigPanel.add("North",infoPanel);
   	
     vbuttonPanel.setLayout(new FlowLayout());
   	 vbuttonPanel.setBorder(BorderFactory.createEtchedBorder());
   	 
   	plus = new JButton( new ImageIcon( getClass().getResource("icons/BLANHOME.gif") ) );
    plus.setText("Click Here To Add Panel");
    plus.setForeground(Color.DARK_GRAY);
    plus.addActionListener(this);
   	vbuttonPanel.add(plus);
   	bigPanel.add("Center",vbuttonPanel);
   	getContentPane().add(bigPanel);
   }
   
   /*************************************************************************************
    *This is most Favorite Method i.e. main method
    *************************************************************************************/
 
   public void actionPerformed(ActionEvent ae) {
   	
   	
/********************Add panel************************************************/
   	if(ae.getSource()==plus) {
   		
      panelName=votingPanelTxt.getText();
      String panelDesc=votingPanelDscTxt.getText();
      System.out.println(panelName);
   	  System.out.println(panelDesc);
   	  try {
   
            sql = "SELECT *FROM votingPanel"; 
            rs = stmt.executeQuery(sql);
            while(rs.next())
              {
              cnt=Integer.parseInt(rs.getString(1));
              System.out.println("COUNT:"+cnt);
              System.out.println(rs.getString(2)); 	
              }	
   	      id=cnt+1;
   	      System.out.println("No:"+id);
          sql= "INSERT INTO votingPanel VALUES("+id+",'"+panelName+"','"+panelDesc+"')";
          stmt.executeUpdate(sql);
          System.out.println("Record inserted successfully...");
          votingPanelTxt.setEditable(false);
          votingPanelDscTxt.setEditable(false);     	
   	}
     catch(SQLException e) {
     	
               System.out.println("Data Base is throws exc..."); }
               
     String msg ;
	 msg  = "# This Panel Is Set SucessFully .\n";
	 JOptionPane.showMessageDialog(null, msg, " Setpanel", JOptionPane.INFORMATION_MESSAGE );
   	   
              
    }
  }
}