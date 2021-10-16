import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.io.*;



import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;


class ServerModule extends JFrame implements ActionListener {

protected JPanel mainpanel,highPanel,mainSubPanel;
protected JButton vote4,vote1,vote2,vote3,Details1,Details2,Details3,Details4,Send;
private JMenu mnuView;
private JMenu mnuFiles;
private JMenuBar menubar;
private JMenuItem mnuConnect;
private JMenuItem mnuAbt;
private JMenuItem mnuExit;
private JMenuItem Help;
private JMenuItem addPanel;
protected JToolBar tbClient;

protected JButton btbExit,AddCand1,AddCand2;
protected JButton btbConfigure;
protected JButton btbHelp;
protected JButton btbOnTheWeb;
private JDialog dia,diaconfig;
private JTextField dtxtHost,iconfig,hostad, dtxtIp ;
private JTextField votingPanelTxt; 
private JLabel passlbl,Ipname;
private JButton cmdConnect,getadd1,getadd2,getadd3,getadd4;
protected JPanel firstbuttonPanel;

int flag1=0,flag=0;
int flag2=0;
int flag3=0;
int flag4=0;
int m=1,id,cnt,cnt1,cnt2;
int a=0,b=1,c=2,d=3,e=0,f=0,g=0,h=0,f1=0;	
protected String candNameArray[] = new String[20]; 
	protected String candDscArray[] = new String[20];
String panelName,Pname;
Connection con;
                 Statement stmt;
                  ResultSet rs;
                  String sql;	
				int i=0,vpid;
				
				String j1[]=new String[100];
       String StoreCandNameArr[]=new String[20];
       String  StoreCandDscArr[]=new String[20];
       String Header[]=new String[100];
       String Dsc[]=new String[100];
       String info[]=new String[100];
      
       JButton Detail[]=new JButton[100];
       JButton select[]=new JButton[100];
       JButton Cand[]=new JButton[100]; 		
	    JButton sendBtn[]=new JButton[100]; 	
	    				
    public ServerModule()     {


    	setTitle("Active Panel");
    	 buildframe();
		setSize(800,600);
        pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
		setupMenuBar();
        setUpToolbar();
       // setButton();
        setVisible(true);
	    //dialogsini();
	    //setvisibleFalse();
	    getConnection();
	    
        }
   /* protected void setvisibleFalse() {
       mainpanel.setVisible(false);
       menubar.setVisible(false);
       btbExit.setVisible(false);
     }?*/

     protected void buildframe(){
      highPanel = new JPanel();
      
      highPanel.setLayout(new BorderLayout());
      mainpanel=new JPanel();
      
     mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
     // mainpanel.add(Box.createVerticalStrut(5));

      String FirstPanelText1="# ELECTION COMMISION OF INDIA :";
      String FirstPanelText2="Here You Can Join the Process of Selecting and Voting a Candidate from Political Parties.\n" ;
      String FirstPanelText3=" You Can Checkout Criterias from the Details button .\n";
      
      vote1 =new JButton("Select");
      Details1 =new JButton("Detail");
       
      
      

      
    // mainpanel.add(createClientPanel(FirstPanelText1,FirstPanelText2,FirstPanelText3,Details1,vote1));

      mainpanel.add(Box.createVerticalStrut(5));
      String SecondPanelText1="# BEST OF SEVEN WONDERS :";
      String SecondPanelText2=" Here You Can Vote for One of the Wonders of the World  & Be a Part Of this Selection." ;
      String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
      //String ForthPanelText3="You Can Checkout Criterias from the Detail button .\n "; 
       Details2 =new JButton("Detail");
       
       vote2 =new JButton("Select");
        
      
     //mainpanel.add(createClientPanel(SecondPanelText1,SecondPanelText2,SecondPanelText3,Details2,vote2));

      mainpanel.add(Box.createVerticalStrut(5));
      String ThirdPanelText1="# BEST CR SELCTION :";
      String ThirdPanelText2="Here You Can Select A Class Rpresentative(CR) And Give Your Valuable Vote To Him.";
      String ThirdPanelText3="You Can Checkout Criterias from the Detail button .\n ";
      //String ForthPanelText3="You Can Checkout Criterias from the Detail button .\n ";
      Details3 =new JButton("Detail");
      
      vote3 =new JButton("Select");
       
     // mainpanel.add(createClientPanel(ThirdPanelText1,ThirdPanelText2,ThirdPanelText3,Details3,vote3));

      mainpanel.add(Box.createVerticalStrut(5));
      String ForthPanelText1="# BEST THE SHOPPING MALLS SELECTION:";
      String ForthPanelText2="Here You Can Select & Vote a Shopping Mall and Vote for Best Shopping Mall in the City.\n" ;
      String ForthPanelText3="You Can Checkout Criterias from the Detail button .\n ";
      
      Details4 =new JButton("Detail");
      
      vote4 =new JButton("Select");
       
      
      
    // mainpanel.add(createClientPanel(ForthPanelText1,ForthPanelText2,ForthPanelText3,Details4,vote4));
      mainpanel.add(Box.createVerticalStrut(20));
	  
	  highPanel.add("North",mainpanel);
      getContentPane().add(highPanel);
      }
      
      
      protected  JPanel createClientPanel(String text,String des,String des2,JButton detail,JButton vote,JButton add) {
      	
       //System.out.println("Yes Enter in");
       
       JPanel Cpanel=new JPanel();
       
       Cpanel.setLayout(new BorderLayout());
       
       
      
       Cpanel.setBorder(BorderFactory.createEtchedBorder());
       
       
       JPanel firstLinePanel=new JPanel();
       
       JPanel buttonPanel=new JPanel();
       
       buttonPanel.setLayout(new FlowLayout());

       firstLinePanel.setLayout(new BoxLayout(firstLinePanel, BoxLayout.Y_AXIS));
       firstLinePanel.add(Box.createHorizontalStrut(10));
       //firstbuttonPanel.setLayout(new BoxLayout(firstbuttonPanel, BoxLayout.X_AXIS));
       
       JLabel label1 = new JLabel(text,JLabel.LEFT);
	   label1.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
	   firstLinePanel.add(label1);
	   firstLinePanel.add(Box.createVerticalStrut(5));

       JLabel label2 = new JLabel(des,JLabel.LEFT);
	   label2.setFont(new Font("TimesNewRoman", 0, 15));
       firstLinePanel.add(label2);
       firstLinePanel.add(Box.createVerticalStrut(5));
       
       JLabel detail1=new JLabel(des2,JLabel.LEFT);
	   detail1.setFont(new Font("TimesNewRoman", 0, 15));
       firstLinePanel.add(detail1);
       
       
        
   		
        detail.addActionListener(this);
        buttonPanel.add(detail);
        buttonPanel.add(Box.createHorizontalStrut(5));
         
       
        vote.addActionListener(this);
        
        buttonPanel.add(vote);
        buttonPanel.add(add);
        add.addActionListener(this);
        
        
        Header[i] = text;
      	Dsc[i] = des;
      	info[i] = des2;
      	
      	Detail[i]=detail;
      	sendBtn[i]=vote;
      	Cand[i]=add;
       	
       	i=i+1;
       	
       // SetData(text,des,des2,detail,vote,add);
         
        buttonPanel.add(Box.createHorizontalStrut(10));
       
    
       
	      
        Cpanel.add("West",firstLinePanel);
        Cpanel.add("South",buttonPanel);
        return Cpanel;
         
        }
        
         protected void setupMenuBar(){
         	
           //set menubar
           menubar=new JMenuBar();
           setJMenuBar(menubar);
           //add menu in menubar
 	 	   mnuView = new JMenu("View");
		   mnuView.setMnemonic('V');
		   mnuFiles = new JMenu("Files");
	       mnuFiles.setMnemonic('F');
           //add menuitem in menubar
           mnuConnect=new JMenuItem("Connect..");
 	 	   mnuConnect.setMnemonic('C');
 	 	   mnuConnect.addActionListener(this);
 	 	   mnuFiles.add(mnuConnect);
           mnuAbt=new JMenuItem("About");
 	 	   mnuAbt.addActionListener(this);
 	 	   mnuAbt.setMnemonic('A');
 	 	   mnuFiles.add(mnuAbt);
           mnuExit=new JMenuItem("Exit");
 	 	   mnuExit.addActionListener(this);
 	       mnuExit.setMnemonic('E');
 	       mnuFiles.add(mnuExit);
          
           Help=new JMenuItem(" Show All Panel");
 	 	   Help.addActionListener(this);
 	       Help.setMnemonic('A');
 	       
 	       addPanel=new JMenuItem("Add New Panel");
 	       addPanel.addActionListener(this);
 	       addPanel.setMnemonic('N');
 	       
 	       mnuView.add(Help);
 	       mnuView.add(addPanel);
           menubar.add(mnuFiles);
 	       menubar.add(mnuView);
           }
		protected void setUpToolbar ()  {
			
         Container con = getContentPane();
         tbClient = new JToolBar();

		 btbExit = new JButton(new ImageIcon( getClass().getResource("/icons/Logoff.gif") ) );
		 btbConfigure = new JButton( new ImageIcon( getClass().getResource("/icons/Log.gif") ) );
		 btbHelp = new JButton( new ImageIcon( getClass().getResource("/icons/About.gif") ) );

         //Set up tooltips
		 btbExit.setToolTipText("Exit");
		 btbConfigure.setToolTipText("Configure");
		 btbHelp.setToolTipText("Help");

         //Add buttons to toolbar
		 tbClient.add( btbConfigure );
		 btbConfigure.addActionListener(this);
		 tbClient.addSeparator();

		 tbClient.add( btbExit );
		 btbExit.addActionListener(this);
		 tbClient.addSeparator();

		 tbClient.add( btbHelp );
		 btbHelp.addActionListener(this);
		 tbClient.addSeparator();

         con.add(tbClient,BorderLayout.NORTH);
		 }

        
        
         /*protected void dialogsini() {
         Container con = getContentPane();
		 con.setLayout(null);
         //connect dialogs
         dia = new JDialog(this, "Connect..", true);
		 dia.getContentPane().setLayout(null);
         // dia.setLayout(new BorderLayout());
         passlbl = new JLabel("Host Name:");
		 passlbl.setFont(new Font("Tahoma",Font.BOLD, 11));
         passlbl.setBounds(36, 60, 152, 30);
         dtxtHost = new JTextField();
		 dtxtHost.setFont(new Font("Tahoma", 0,11));
         dtxtHost.setBounds(107, 36, 148, 19);
         Ipname = new JLabel("IP");
		 Ipname.setFont(new Font("Tahoma", Font.BOLD,11));
         Ipname.setBounds(36, 40, 72, 17);
         dtxtIp = new JTextField();
		 dtxtIp.setFont(new Font("Tahoma", 0, 11));
         dtxtIp.setBounds(107, 67, 148, 19);
         cmdConnect = new JButton("Connect");
		 cmdConnect.setBounds(100, 90, 88, 25);
         dia.setSize(285,165);
         dia.getContentPane().add(cmdConnect);
		 dia.getContentPane().add(passlbl);
		 dia.getContentPane().add(dtxtHost);
	     dia.getContentPane().add(Ipname);
		 dia.getContentPane().add(dtxtIp);
         dia.setLocation((800-285)/2,(600-165)/2);
		 cmdConnect.addActionListener(this);
         }*/
         
        
        protected void getConnection()
         {
         
                  
                  System.out.println("DataBase is connected");
                  try
                   {
			             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                          con=DriverManager.getConnection("jdbc:odbc:voting");
                   }
		       
		       catch(Exception e)
                 {
                  	System.out.println("JDBC:ODBC driver failed to load.");
                  	return;
                 }
                try
                {
                
                stmt = con.createStatement();
                }
 
                catch(Exception e)
                {
 	               e.printStackTrace();
    	            return;
                }	
         
         	
         	
         }  
        
        
        protected  JPanel createClientPanel2(String text,String des,String des2,JButton vote) {
       
       //System.out.println("Yes Enter in");
       
       JPanel Cpanel=new JPanel();
       
       Cpanel.setLayout(new BorderLayout());
       
       
      
       Cpanel.setBorder(BorderFactory.createEtchedBorder());
           
       
       JPanel firstLinePanel=new JPanel();
       
       JPanel buttonPanel=new JPanel();
       
       buttonPanel.setLayout(new FlowLayout());

       firstLinePanel.setLayout(new BoxLayout(firstLinePanel, BoxLayout.Y_AXIS));
       firstLinePanel.add(Box.createHorizontalStrut(10));
       
       
       JLabel label1 = new JLabel(text,JLabel.LEFT);
	   label1.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
	   firstLinePanel.add(label1);
	   firstLinePanel.add(Box.createVerticalStrut(5));

       JLabel label2 = new JLabel(des,JLabel.LEFT);
	   label2.setFont(new Font("TimesNewRoman", 0, 15));
       firstLinePanel.add(label2);
       firstLinePanel.add(Box.createVerticalStrut(5));
       
       JLabel detail1=new JLabel(des2,JLabel.LEFT);
	   detail1.setFont(new Font("TimesNewRoman", 0, 15));
       firstLinePanel.add(detail1);
       
       buttonPanel.add(Box.createHorizontalStrut(5));
       vote.addActionListener(this);
       buttonPanel.add(vote);
       
        Header[i] = text;
      	Dsc[i] = des;
      	info[i] = des2;
      	
      	select[i]=vote;
      	
       	i=i+1;
       	
       buttonPanel.add(Box.createHorizontalStrut(10));
       
        Cpanel.add("West",firstLinePanel);
        Cpanel.add("South",buttonPanel);
        return Cpanel;
         
        }
 
        
        
         public class Valid extends JFrame //implements ActionListener
{
public Valid()
   {
    super(" Voting Panels ");
    
    setSize(800,800);
    setVisible(true);
    
    
    
   mainSubPanel = new JPanel();
      
      mainSubPanel.setLayout(new BorderLayout());
     JPanel SubFramePanel=new JPanel();
      
     SubFramePanel.setLayout(new BoxLayout(SubFramePanel,BoxLayout.Y_AXIS));
    // SubFramePanel.add(Box.createVerticalStrut(5));
     
     
     
    try
    {
    
       sql = "SELECT *FROM votingPanel"; //where Voting_panel_id="+e;
                      rs = stmt.executeQuery(sql);
      
    // mainpanel.add(Box.createVerticalStrut(5));
    
    
       while( rs.next())
       {
      String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     vote2 =new JButton("Select");
     AddCand2=new JButton("ADD CAND");
     SubFramePanel.add(createClientPanel2(rs.getString(2),rs.getString(3),SecondPanelText3,vote2));      
     validate(); 
     	
     	
     	
     	mainSubPanel.add("North",SubFramePanel);
     getContentPane().add(mainSubPanel);
     
     }
   }
                         catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
               }
	}
	}	
		
   /////////////////////////////////////////////////////////////////
   public class Candidates extends JFrame implements ActionListener {

	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu helpMenu;
	protected JMenuItem mnuExit,mnuAbt,mnuHelp;	
    protected JTextField nText,dText;
	protected String cname,cdsc;	
	private JButton cAdd,cEdit,Edit; 
	private	int cnt =0,l =0,i =0,flag =0,editNo=1,cnt1,cnt2,q=0;
	
	private JButton storeEditBtn[] = new JButton[20];
	private JTextField canName[] = new JTextField[20];
	private JTextField canDsc[] = new JTextField[20];
	
	private JPanel mainPanel,fistPanel,scndPanel,thidPanel,fourthPanel,cPanel,namePanel,cButtonPanel,cAddPanel,nameAddPanel,cAddButtonPanel,newcPanel,cHeadPanel;
	private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String sql,s1,s2;	
	
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
		 
		 
		 candNameArray[f1] = s1;
		 
		
		 
		 
		 candDscArray[q] = s2;
		 
		 
		// System.out.println(s1);
	//	 System.out.println(s2);
		 
		 //System.out.println("DDDDDDD"+candNameArray[f]);
		 f1++;
		// System.out.println("DDDDDDD"+candDscArray[q]);
		 q++;
		 
	 System.out.println("No. of records are"+f1);
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
	
	
	

   ////////////////////////////////////////////////////////////////
  
  
  public void actionPerformed(ActionEvent ae) {
     	
   if(ae.getSource()==mnuExit){
         int ai= JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", " Client Model", JOptionPane.YES_NO_OPTION);
		 if(ai==0)
		 System.exit(0);
		 }
         //About
		if(ae.getSource()==mnuAbt) {
		String msg ;
		msg = "Feel free to distribute and re-distribute this Open Source project.\n";
		msg += "Use this project at your educational purposes.\n\n";
		msg += "Developed using New I/O technologies and doing voting\n\n";
		JOptionPane.showMessageDialog(null, msg, " Client", JOptionPane.INFORMATION_MESSAGE );
		}

	/*	if(ae.getSource()==mnuConnect)
        dia.show();

        String user = dtxtHost.getText();
        String pass = dtxtIp.getText();
     if(ae.getSource()==cmdConnect){
           if(user.compareTo(pass)==0)
            {
            JOptionPane.showMessageDialog(null,"Wait For server is connected ","Login",JOptionPane.INFORMATION_MESSAGE);
		    //JOptionPane.showMessageDialog(null,"Login Successful","Login",JOptionPane.INFORMATION_MESSAGE);
		    mainpanel.setVisible(true);
		    menubar.setVisible(true);
		    btbExit.setVisible(true);
		    }
	    else
             JOptionPane.showMessageDialog(null, "LOGIN FAILD", "Client", JOptionPane.ERROR_MESSAGE);
        }
        if(ae.getSource()==btbConfigure){
         dia.show();
         }*/

      if(ae.getSource()==btbExit) {
        int ai= JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", " Client Model", JOptionPane.YES_NO_OPTION);
		if(ai==0)
		System.exit(0);
        }

      
      
      if(ae.getSource()==Detail[0]){
       	
        String msg="1.Voter age should be greater than 18.\n";
		msg +="2. Voter should be an Indian people.\n";
		msg +="3. One Voter is allowed to Register only His single Vote.\n";
		msg +="4. One Voter can Register His Vote on single specified Party candidates\n";
		JOptionPane.showMessageDialog(null,msg,"Login", JOptionPane.INFORMATION_MESSAGE);
        }
      if(ae.getSource()==Detail[1]){
      Piegraph p1=	new Piegraph();
      	/* String msg="1.There is no Restriction on age.\n";
		 msg +="2. One Voter can can Register His Vote on Single World Wonder.\n";
		 msg +="3. One Voter is allowed to Register only His single Vote.\n";
    	 JOptionPane.showMessageDialog(null,msg,"Login", JOptionPane.INFORMATION_MESSAGE);
    	 */
    	 }
     if(ae.getSource()==Detail[2]){
        String msg="1. The Voter should be a Class people.\n";
		msg +="2. One Voter is allowed to Register only His single Vote.\n";
		msg +="3. One Voter can Register His Vote on single specified CR candidates\n";
		JOptionPane.showMessageDialog(null,msg,"Login", JOptionPane.INFORMATION_MESSAGE);
        }
     if(ae.getSource()==Detail[3]){
        String msg="1.Voter should be a Customer of Shopping Mall.\n";
		msg +="2. One Voter is allowed to Register only His single Vote.\n";
		msg +="3. One Voter can Register His Vote on single specified Shopping Mall \n";
		JOptionPane.showMessageDialog(null,msg,"Login", JOptionPane.INFORMATION_MESSAGE);
        }

	
/*	if(ae.getSource()==vote1)
	
	{   	
	    
	 try
       {
       	
       	
       	   if(flag1==0)
       	   {
       	       a++;
       	       e=a;
               sql= "INSERT INTO votingPanel VALUES("+a+",'"+j1[0]+"','"+Header[0]+"')";
               stmt.executeUpdate(sql);
               System.out.println("Record inserted successfully...");
               flag1=flag1+1;
               
               	 
                       
                        
           }  
             
            else   
               {
               	
              
               sql = "SELECT *FROM votingPanel"; 
                      rs = stmt.executeQuery(sql);
                        rs.next();
                        // System.out.println("No: "+rs.getString(1)+"\n"+
                          //                 "Name: "+rs.getString(2)+"\n"+
                           //               "Desc: "+rs.getString(3));
                    mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS)); 
                   mainpanel.add(Box.createVerticalStrut(5));
                    validate(); 
                  System.out.println("Record present successfully...");
                 }         
           }
             catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
             }
   }	
	if(ae.getSource()==vote2)
	{        
       try
       {
       	
       	
       	 if(flag2==0)
       	 {
       	 b=b+1;
          f=b;
         sql= "INSERT INTO votingPanel VALUES("+b+",'"+j1[1]+"','"+Header[1]+"')";
               stmt.executeUpdate(sql);
               System.out.println("Record inserted successfully...");
               flag2++;
            }      
             else   
               {
               
               
               sql = "SELECT *FROM votingPanel where Voting_panel_id="+f;                        rs = stmt.executeQuery(sql);
                        rs.next();
                         System.out.println("No: "+rs.getString(1)+"\n"+
                                           "Name: "+rs.getString(2)+"\n"+
                                           "Desc: "+rs.getString(3));
                        
                       validate();                                                                         
                       System.out.println("Record present successfully...");
                 }         
           }
             catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
               }
   }	
   	if(ae.getSource()==vote3)
	{	

	   try
       {
       	
       	
       	
       	if(flag3==0)
       	{
       	c++;
       	g=c;
         sql= "INSERT INTO votingPanel VALUES("+c+",'"+j1[2]+"','"+Header[2]+"')";
               stmt.executeUpdate(sql);
               System.out.println("Record inserted successfully...");
        flag3++;       
       }       
               
           else   
               {
               	
               	
              
               sql = "SELECT *FROM votingPanel where Voting_panel_id="+g;
                        rs = stmt.executeQuery(sql);
                        rs.next();
                         System.out.println("No: "+rs.getString(1)+"\n"+
                                           "Name: "+rs.getString(2)+"\n"+
                                           "Desc: "+rs.getString(3));
                  System.out.println("Record present successfully...");
                }         
               
           }
             catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
               }
   }	
   	if(ae.getSource()==vote4)
	{	
	     
	    try
         {
         	
         	
         	if(flag4==0)
         	{
         		d++;
         	    h=d;
         sql= "INSERT INTO votingPanel VALUES("+d+",'"+j1[3]+"','"+Header[3]+"')";
               stmt.executeUpdate(sql);
               System.out.println("Record inserted successfully...");
               flag4++;
               }
                else   
               {
               		
               	
               	
               	
                        
                        sql = "SELECT *FROM votingPanel where Voting_panel_id="+h;
                        rs = stmt.executeQuery(sql);
                        rs.next();
                        System.out.println("No: "+rs.getString(1)+"\n"+
                                           "Name: "+rs.getString(2)+"\n"+
                                           "Desc: "+rs.getString(3));
                       System.out.println("Record present successfully...");
               
                      }         
               
           }
             catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
               }
   }*/			
		
		if(ae.getSource()==Help)
		{
			
			
			Valid v1=new Valid();
			}
			
		if(ae.getSource()==Cand[1])
        {
          	System.out.println("Enter in");
          	Candidates c1=new Candidates();
             
          		
        }	
		  /*if(ae.getSource()==Cand[1])
        {
          	
           Candidates c1=new Candidates();	
        }*/
       
       
        if(ae.getSource()==Cand[2])
        {
          	System.out.println("lklk");
           Candidates c1=new Candidates();	
        }
        if(ae.getSource()==Cand[3])
        {
          	
           Candidates c1=new Candidates();	
        }
        if(ae.getSource()==Cand[4])
        {
          	
           Candidates c1=new Candidates();	
        }
        if(ae.getSource()==Cand[5])
        {
          	
           Candidates c1=new Candidates();	
        }
        
        
        if(ae.getSource()==select[0])
        {
          	
          try
    {
       /* sql="Select Voting_Panel_id From votingPanel";
					   rs= stmt.executeQuery(sql);
					  String  str=rs.getString(1);
                      System.out.println(rs.getString(1));*/
    
    	
    	//sql="Select Voting_panel_id,Voting_panel_Name from votingPanel where Voting_panel_Name="+panelName;
    //	rs=stmt.executeQuery(sql);
    	//System.out.println("PanelName is="+panelName);
	//	 int c1=Integer.parseInt(rs.getString(1));
        
		//
    	
    
		
		
       sql = "SELECT *FROM votingPanel where Voting_panel_id="+1;
                      rs = stmt.executeQuery(sql);
      
    
    
      rs.next();
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Result");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     
     mainpanel.add(createClientPanel(rs.getString(2),rs.getString(3),SecondPanelText3,Details2,Send,AddCand2));      
     validate(); 
     //Pname=votingPanelTxt.getText();
     //System.out.println("PNAmE: "+Pname);
     
     
   }
                         catch(SQLException e)
             {
               System.out.println("Data Base is throws exc...");
               }  	
        }
        
        
        
        
        
        
        
        
        if(ae.getSource()==select[1])
        {
          	
     
     mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
    
    
   
      
      System.out.println("FAULT:");
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     System.out.println("No PROB:");
     mainpanel.add(createClientPanel(Header[1],Dsc[1],info[1],Details2,Send,AddCand2));      
     validate(); 
     
    
        }
        
        
        
        if(ae.getSource()==select[2])
        {
          	
          
      
    
      
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     System.out.println("No PROB:");
     mainpanel.add(createClientPanel(Header[2],Dsc[2],info[2],Details2,Send,AddCand2));      
     validate(); 
     
     
   
        }
        
        
        if(ae.getSource()==select[3])
        {
          	
        
      
    
    
      
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     System.out.println("No PROB:");
     mainpanel.add(createClientPanel(Header[3],Dsc[3],info[3],Details2,Send,AddCand2));      
     validate(); 
     
     
   
        }
        
        
        
        if(ae.getSource()==select[4])
        {
          	
          
     
    
      
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     System.out.println("No PROB:");
     mainpanel.add(createClientPanel(Header[4],Dsc[4],info[4],Details2,Send,AddCand2));      
     validate(); 
     
     
   
        }
        
        
        
        
        
        if(ae.getSource()==select[5])
        {
          	
         
      
    
    
      
     String SecondPanelText3="You Can Checkout Criterias from the Detail button  \n ";
     Details2 =new JButton("Detail");
     Send =new JButton("Send");
     AddCand2=new JButton("ADD CAND");
     System.out.println("No PROB:");
     mainpanel.add(createClientPanel(Header[5],Dsc[5],info[5],Details2,Send,AddCand2));      
     validate(); 
     
     
   
        }
        
        /////////////////////////////////////////////////////////////////////////////////
        
        
        if(ae.getSource()==sendBtn[1])
        {
        	String PanelName=Header[0];
        	String panelDsc=Dsc[0];
        	String panelInfo=info[0];
        	
        	
        	
        	for(int j=0;j<20;j++)
        	{
        	        StoreCandNameArr[j]=candNameArray[j];
        			 StoreCandDscArr[j]=candDscArray[j];
        			 
        		//	 StoreCandNameArr[j]="dIGFDJG";
        		//	 StoreCandDscArr[j]="GDFGDG";
        	}
           //System.out.println("nAME"+candNameArray[0]);
        	
        	
        System.out.println(" F IS"+f1);		
        	
        	
        	Thread t = new Thread(new ServerThread(PanelName,panelDsc,panelInfo,StoreCandNameArr,StoreCandDscArr,f1));
			t.start();
        
        //	System.out.println("It is OK2222");
        	
        }
        
        
        
        
        if(ae.getSource()==addPanel)
        {
  
                    AddPanel r1=new AddPanel();
                    
 
         }

   
      	
        
        
     
}









          public static void main(String [] args) throws Exception {
          	
   
	
			/*setSize(800,600);
			setTitle("True");
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);*/
		try
		{
			String Vname1,Vno1;
			ServerModule c1= new ServerModule();	
			//new AddPanel();
			//Thread t = new Thread(new ServerThread());
		//	t.start();
			System.out.println("DFD");
			
			 
	//		Vname1=c1.Header[0];
	//	 	Vno1=c1.Dsc[0];
		 	
		//	System.out.println("Hi:"+Vname);
	//		System.out.println("Hi:"+Vno);	
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);			
		}
	}
}



class ServerThread implements Runnable {
	
	ServerSocket socket;
	String ClientPanelName,ClientPanelDsc,ClientPanelInfo;
	String CN[]=new String[20];
	String CD[]=new String[20];
	int referanceF;
	Statement stmt1;
	int cnt1,z,o,w=0;
	String temp1,temp2;
	
	Connection con;
                 Statement stmt;
                  ResultSet rs;
                  String sql,sql1,name[]=new String[10];	
	public ServerThread(String x,String y,String z,String A[],String B[],int noOfRec) {
		
		getConnection();
		try {
			socket=new ServerSocket(8765);
			 ClientPanelName = x;
	    	 ClientPanelDsc = y;
		     ClientPanelInfo=z;
		     referanceF=noOfRec;
		  System.out.println("No of gettin rec:"+referanceF);   
		     for(int c=0;c<20;c++)
		{
			CN[c]=A[c];
			CD[c]=B[c];
		}
		//System.out.println("No:"+A[0]);
		//System.out.println("No:"+B[0]);
		     
		}
		catch(Exception e ) { 
			System.out.println(e);
		}
			
	}
	 protected void getConnection()
         {
         
                  
                  System.out.println("DataBase is connected Server side");
                  try
                   {
			             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                          con=DriverManager.getConnection("jdbc:odbc:voting");
                   }
		       
		       catch(Exception e)
                 {
                  	System.out.println("JDBC:ODBC driver failed to load.");
                  	return;
                 }
                try
                {
                
                stmt = con.createStatement();
                }
 
                catch(Exception e)
                {
 	               e.printStackTrace();
    	            return;
                }	
         
         	
         	
         }  
        
	public void run() {
		System.out.println("Server is ready");
		
		//Temp v = new Temp();
		
		save s = new save();
		CandidateTemp Cand=new CandidateTemp();
		
		
		
	
		s.VoterName = ClientPanelName;
		s.VoterDsc = ClientPanelDsc;
		s.VoterInfo = ClientPanelInfo;
		Cand.rec=referanceF;
		for(int c=0;c<20;c++)
		{
			Cand.CandName[c]=CN[c];
			Cand.CandDesc[c]=CD[c];
		}
		System.out.println("No:"+CN[0]);
			System.out.println("No:"+CD[0]);
		System.out.println("No of gettin rec:"+Cand.rec);
		try {

		while(true) {
			Socket insocket=socket.accept();//with the help of accept() we can got the request from client.
			System.out.println("Client is connected");

			
			OutputStream out=insocket.getOutputStream();
			InputStream in=insocket.getInputStream();
			ObjectOutputStream oos =new ObjectOutputStream(out);
			
	        ObjectInputStream ois=new ObjectInputStream(in);
	
		
					
			System.out.println("No:"+s.VoterName);
			System.out.println("No:"+s.VoterDsc);
			
			oos.writeObject(s);
		//	oos.flush(); 
			
			//System.out.println("No:"+Cand.CandName[0]);
			//System.out.println("No:"+Cand.CandDesc[0]);
			
			
			oos.writeObject(Cand);
			
			oos.flush(); 
			
			
			SecureVote svv= (SecureVote) ois.readObject();	
			
			System.out.println("SECURED CLASS CAND Name:"+svv.VoteCandName);
			System.out.println("SECURED CLASS Panel Name:"+svv.VotePanelName);
			System.out.println("SECURED CLASS Cnt Vote:"+svv.Votecnt);

			temp1=svv.VoteCandName;
			temp2=svv.VotePanelName;
		
		
			try {
		    
		    sql1= " select * From Result ";
            stmt = con.createStatement();    
			rs=stmt.executeQuery(sql1);
			
			while(rs.next())
			{
			
				   name[w]=rs.getString(2);
				   System.out.println("Name of Cnadidate is as"+name[w]);
				w++;   
				   
			}	
				  // System.out.println("Name is present in db properly "+name[w]);	 
				   // System.out.println("Name is present in db properly "+rs.getString(2));
				   	for(int i=0;i<5;i++)
				   	{
				   	 
				   if(name[i]==temp1)
				    {
				 	 	
				     sql1 = "SELECT * from Result ";  
				     stmt = con.createStatement();
				     rs=stmt.executeQuery(sql1);
				     rs.next();
				  	 z=Integer.parseInt(rs.getString(4));
               		 System.out.println(" Candidate Vote Counter is "+z);
               		 cnt1=z+1;
                     sql1 = "UPDATE Result SET Votes ="+cnt1+" WHERE Candidate_Name='"+temp1+"'";
                   	 stmt = con.createStatement();
               	     stmt.executeUpdate(sql1);
               	     System.out.println("Record updated successfully...");
				  
                   }
                   else
                   {
                   	System.out.println("Record Not Found successfully...");
                   }
            }
                  /* else
				 {
				 			
				 sql1= "INSERT INTO Result VALUES("+1+",'"+temp1+"','"+temp2+"',"+1+")";
           	     stmt = con.createStatement();
                 stmt.executeUpdate(sql1);
                 System.out.println("Record inserted successfully...");
                 
  				}*/
  			
		}			
			catch(Exception e ) { 
			
			System.out.println("DB Exception Catch hear");
			System.out.println(e);
		}		
			
				
			
			
             
               	/*
               	  	sql1 = "SELECT * from Result where Candidate_Name ="+svv.VoteCandName; 
               	  	//stmt = con.createStatement();	
            		rs = stmt.executeQuery(sql);
              		rs.next();
               		cnt1=Integer.parseInt(rs.getString(4));
               		cnt1=cnt1+1;
            	
               	 	sql1 = "UPDATE Result SET Votes="+cnt1+" where Candidate_Name="+svv.VoteCandName;
               	 //	stmt = con.createStatement();
                   	stmt.executeUpdate(sql1);
                   	System.out.println("Record updated successfully...");
                   
              	*/		
		
			insocket.close();
		}
		
		
		
		
		
		
		
		}
		catch(Exception e ) { 
			System.out.println(e);
		}
			
	}
}

class save implements Serializable
{
	String VoterName,VoterDsc,VoterInfo;
}

class CandidateTemp  implements Serializable
{
	String CandName[]=new String[20];
	String CandDesc[]=new String[20];
	int rec;
}
class SecureVote implements Serializable
{
	String VoteCandName;
	String VotePanelName;
	int Votecnt;
}






/*class Temp  
{
	String Vname,Vno;
	
	
	Temp()
	{
	//	this.Vname = "VNAME";
	//	this.Vno = "11";
		 CandidateTemp c1= new CandidateTemp();
		 Vname=c1.Header[0];
		 Vno=c1.Dsc[0];
		System.out.println("Hi:"+Vname);
			System.out.println("Hi:"+Vno);	
	
	
    }  
		
}*/
       	
          	
          	
          	
          	
		// CandidateTemp c1= new CandidateTemp();
//	}


//}
        
        
        
        
        
        
        
       
      
      
      