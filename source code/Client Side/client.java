import java.net.*;
import java.io.*;
import java.lang.*;
import java.sql.*;

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

class client extends JFrame implements ActionListener

{
      private JMenu mnuFiles;
      private JMenuBar menubar;
     protected JPanel highPanel,mainpanel;
     JLabel Ipname,passlbl;
  
   private JMenuItem mnuConnect;
   private JMenuItem mnuAbt;
   private JMenuItem mnuExit;
	private JDialog dia,diaconfig;
private JTextField dtxtHost,iconfig,hostad, dtxtIp ;
JButton cmdConnect,NextBtn;
    String storepanelName; 
    String g1[]=new String[20];
    int GlobalRecCnt,CanVoteCnt=0;
    	String g2[]=new String[20];
    	
    	
    	private static Socket socket;
        private static InputStream in;
        private static 	ObjectInputStream ois;
        private static  OutputStream out;
	    private static  ObjectOutputStream oos;
			    
    
     public client(String s1,String s2,String s3,String a[],String b[],int noOfRecGet)
     {
    for(int v=0;v<20;v++)
    {
    g1[v]=a[v];
    g2[v]=b[v];	
    }
    storepanelName=s1;
    GlobalRecCnt=noOfRecGet;
    
     setTitle("Client Frame");
	 setSize(800,600);
	 buildframe(s1,s2,s3);
     pack();
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setupMenuBar();
     //dialogsini();
	 //setUpToolbar();
     setVisible(true);
     
     }
     protected void setupMenuBar(){
     	
           //set menubar
           menubar=new JMenuBar();
           setJMenuBar(menubar);
           //add menu in menubar
 	 	  
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
          menubar.add(mnuFiles);
 	       
           }
     
     protected void buildframe(String Panelname,String PanelDesc,String PanelInfo){
     	
      highPanel = new JPanel();
      highPanel.setLayout(new BorderLayout());
      mainpanel=new JPanel();
      mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
      
      JButton next=new JButton("NEXT");
           
      mainpanel.add(createClientPanel(Panelname,PanelDesc,PanelInfo,next));
      validate();
      mainpanel.add(Box.createVerticalStrut(20));
	  highPanel.add("North",mainpanel);
      getContentPane().add(highPanel);
     
     }
      protected  JPanel createClientPanel(String text,String des,String des2,JButton next) {
      	
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
       
       NextBtn=new JButton();
         
       NextBtn=next;
       NextBtn.addActionListener(this);
        buttonPanel.add(next);
        buttonPanel.add(Box.createHorizontalStrut(10));
       
    
       
	      
        Cpanel.add("West",firstLinePanel);
        Cpanel.add("South",buttonPanel);
        return Cpanel;
         
        }
      protected void dialogsini() {
      	
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
         }
         
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
		
		
		if(ae.getSource()==mnuConnect)
            dia.show();

		/*String user = dtxtHost.getText();
        //String pass = dtxtIp.getText();
          //    if(ae.getSource()==cmdConnect){
           //if(user.compareTo(pass)==0)
            //{
            JOptionPane.showMessageDialog(null,"Wait For server is connected ","Login",JOptionPane.INFORMATION_MESSAGE);
		   mainpanel.setVisible(true);
		    }
	    else
             JOptionPane.showMessageDialog(null, "LOGIN FAILD", "Client", JOptionPane.ERROR_MESSAGE);
        }*/
        
        if(ae.getSource() == NextBtn)
        {
       CandVoting CV = new CandVoting(g1,g2,GlobalRecCnt);
        }
        


     }
     
  
 /////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////// 

 class CandVoting  extends JFrame implements ActionListener
 {
 	int p=0;
     JButton Vote1[]=new JButton[10];
     String cname[]=new String[10];
      
 	 CandVoting(String name[], String dsc[],int y)
 	{
     setTitle("Voting Frame");
	 setSize(800,600);
	 VoterFrame(name,dsc,y);
     pack();
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
 	}
 	
   protected void VoterFrame(String name[],String Desc[],int r){
     	
      highPanel = new JPanel();
      highPanel.setLayout(new BorderLayout());
      mainpanel=new JPanel();
      mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
      	
   // JButton Vote1[]=new JButton[10];
       for(int x=0;x<r;x++)
       {
       
       JButton Vote=new JButton("Vote");   
      mainpanel.add(createClientPanelVote(name[x],Desc[x],Vote));
      validate();
       }
      mainpanel.add(Box.createVerticalStrut(20));
	  highPanel.add("North",mainpanel);
      getContentPane().add(highPanel);
     
     }
      protected  JPanel createClientPanelVote(String text,String des,JButton Vote2) {
      	
      //System.out.println("Yes Enter in");
       
       JPanel Cpanel=new JPanel();
       Cpanel.setLayout(new BorderLayout());
       Cpanel.setBorder(BorderFactory.createEtchedBorder());
       
       
       JPanel firstLinePanel=new JPanel();
       
       JPanel buttonPanel=new JPanel();
       
       buttonPanel.setLayout(new FlowLayout());

       firstLinePanel.setLayout(new BoxLayout(firstLinePanel, BoxLayout.Y_AXIS));
       firstLinePanel.add(Box.createHorizontalStrut(10));
      
        cname[p]=text;
        
          
       JLabel label1 = new JLabel(text,JLabel.LEFT);
	   label1.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
	   firstLinePanel.add(label1);
	   firstLinePanel.add(Box.createVerticalStrut(5));

       JLabel label2 = new JLabel(des,JLabel.LEFT);
	   label2.setFont(new Font("TimesNewRoman", 0, 15));
       firstLinePanel.add(label2);
       firstLinePanel.add(Box.createVerticalStrut(5));
       
        buttonPanel.add(Box.createHorizontalStrut(5));
         buttonPanel.add(Vote2);
        Vote2.addActionListener(this);
       Vote1[p]=Vote2;
      // NextBtn=new JButton();
       p++;
       //NextBtn=next;
       
      // Vote[p].setText("vote");
       
        
        buttonPanel.add(Box.createHorizontalStrut(10));
       
       
	      
        Cpanel.add("West",firstLinePanel);
        Cpanel.add("East",buttonPanel);
        return Cpanel;
         
        }
       public void actionPerformed(ActionEvent ae) {
        	
        	if(ae.getSource()==Vote1[0])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[0];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close();
			   JOptionPane.showMessageDialog(null, "Your vote has been Registered", " Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);	
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        	
        		if(ae.getSource()==Vote1[1])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[1];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close(); 
			    JOptionPane.showMessageDialog(null, "Your vote has been Registered", "  Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);		
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        		if(ae.getSource()==Vote1[2])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[2];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close();
			   JOptionPane.showMessageDialog(null, "Your vote has been Registered", " Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);	
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        	
        		if(ae.getSource()==Vote1[3])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[3];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close(); 
			    JOptionPane.showMessageDialog(null, "Your vote has been Registered", " Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);		
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        		if(ae.getSource()==Vote1[4])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[4];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close();
			   JOptionPane.showMessageDialog(null, "Your vote has been Registered", " Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);	
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        	
        		if(ae.getSource()==Vote1[5])
        	{
        	
        	
        		CanVoteCnt++;
        		System.out.println("Vote is secured");
        	    
        	        		
        		SecureVote sv=new SecureVote();
        		
        		sv.VoteCandName=cname[5];
        		sv.VotePanelName=storepanelName;
        		sv.Votecnt=CanVoteCnt;
        		
        		System.out.println("Candidate name="+sv.VoteCandName);
        		
        		System.out.println("Panel name="+sv.VotePanelName);
        		System.out.println("Cnt no="+sv.Votecnt);
        		
        		try {
        		 
        	      //  Socket socket1=new Socket("127.0.0.1",8765);
        		
        	//OutputStream out1=socket1.getOutputStream();
			 //   ObjectOutputStream oos1 =new ObjectOutputStream(out1);
			    
			  System.out.println("Vote is  11111not secured");
			    oos.writeObject(sv);
			  // 	 System.out.println("Vote is  11111not secured");
			   //oos1.flush();
			   // socket.close();
			   //  socket1.close(); 
			    JOptionPane.showMessageDialog(null, "Your vote has been Registered", " Client", JOptionPane.INFORMATION_MESSAGE ); 
			    System.exit(0);		
        		}
        	catch(Exception e)
        		{
        				System.out.println(e);	
        			System.out.println("Vote is  not secured");	
        		}
        	    
        	//	System.out.println("Vote is Register");
        		
        	}
        	
        		
        }

 }
 
 
  
 
 ///////////////////////////////////////////////////////////////
 

 
 /////////////////////////////////////////////////////////////////    
     	
	public static void main(String args[])
	{
		
		
	
	
	try
	{
		
 	socket=new Socket("127.0.0.1",8765);
	//Temp t = new Temp();
	
	//OutputStream out=socket.getOutputStream();
	//ObjectOutputStream oos =new ObjectOutputStream(out);
	
	//oos.writeObject(t);
	//oos.flush();
	
	
	 
	
	
	
       in=socket.getInputStream();
     out=socket.getOutputStream();
       ois=new ObjectInputStream(in);
        oos=new ObjectOutputStream(out);
	
	
	
	save r= (save) ois.readObject();
	CandidateTemp CT=(CandidateTemp) ois.readObject();
	
	
	
	

	
	/*System.out.println(": "+r.VoterName);
	System.out.println(": "+r.VoterDsc);
	System.out.println(": "+r.VoterInfo);
	System.out.println(": "+r);*/
    
    client c=new client(r.VoterName,r.VoterDsc,r.VoterInfo,CT.CandName,CT.CandDesc,CT.rec);
	
   //CandVoting  CV=new CandVoting(CT.CandName[0],CT.CandDesc[0]);
 
//	socket.close();
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Wait for server Connection", " Client", JOptionPane.INFORMATION_MESSAGE );
	} 
	}
}




//////////////////////////////////////////////////


	
