import java.awt.*;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import javax.swing.JPanel;
import java.sql.*;

class Piegraph extends JFrame {
           PiegraphBuild pie1;  
       	   public Piegraph() {
   
		        buildWindow();
		   }

	
	     protected void buildWindow() {
	      	
	        Container con=getContentPane();
		     pie1=new PiegraphBuild();
		   
			     addWindowListener(new WindowAdapter()
             {
                  public void windowClosing(WindowEvent e)
                  {
                        System.exit(0);
                   }
             });
              
            con.add(pie1);
            
   		   setTitle("PIE-CHART");
           setSize(800,600);
           setVisible(true);
         }
         
     public static void main(String []args) {
	 	
       new Piegraph();
	
     	}
   }

class PiegraphBuild extends JPanel 
{
	 
	 Connection con;
                 Statement stmt;
                  ResultSet rs;
                  String sql,sql1;
	 
	 private Map<String,Integer> pieData;
	             	
	
	 PiegraphBuild() 
	 {
	 	
	   pieData = new TreeMap<String,Integer>();
	   getConnection();
	   initializeData();
	   setBackground(Color.white);
     
     } 
     
     
     
   ///////////////////////getdata///////////////////////
   
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
        
        
   
   /////////////////////////////////////            

 //*************** To Initialize the Object *************************************//
	    protected void initializeData() {
	    	
	    	
	    	try {
	    		
	    	
	    	sql="select * from Result";
	    	 stmt = con.createStatement();    
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				
				String s1=rs.getString(2);
				int n=Integer.parseInt(rs.getString(4));
				pieData.put(s1,n);
				
			
			}
			}
			catch(SQLException e)
			{
				System.out.println("fgsdgsg");
				
			}
	
	
			
    }
	
	
/*****************************************************************************************
	 * This method should draw the pie based on the pie data.
	 * Calculate total number of voted from the PieData map,
	 * Calculate the % of vote each party has got.
	 * Calculate how to transform this data into  the data which can be displayed in Pie.
	 * I.E. 50% means 0.5*360 = 180 degree and so on..
	 * @param g
****************************************************************************************/
	  	int Tvotes ;
	  	double percentage;
	  	int Vote1,Vote,Iangle=90,n=0;
	  	int color1=25 ,color2=50,color3=75,X_axixs=80;
	  
	    public void paintComponent(Graphics g)
	 	{    
	 		super.paintComponents(g);
	 		Set<String> keySet = pieData.keySet();
	     	Iterator<String> keyIterator = keySet.iterator();
	    	while(keyIterator.hasNext()) 						//To Get the Total Number Of Votes 
	    	{    
	        	String partyName = keyIterator.next();
	       		pieData.get(partyName);
	       		Vote1 = pieData.get(partyName);
	       		Tvotes=Tvotes+Vote1;							//Formula For Total Number of Votes
	      	}	
	     		     
	     
	     Set<String> keySet1 = pieData.keySet();
	     Iterator<String> keyIterator1 = keySet1.iterator();
	     while(keyIterator1.hasNext()) 							//To Calculate the Degrees & Draw the Pie Diagram.
	     {    
	     	double Tvotes2=(double)Tvotes;
    	   	String partyName1 = keyIterator1.next();
	       	pieData.get(partyName1);							//For Accessing the Partyname from Mapped Set
	       	System.out.println(partyName1);
	       	
	       	Vote = pieData.get(partyName1);						//For Accessing the Votes of Parties from Mapped Set
	       	System.out.println("Vote \t" +Vote);
	       	System.out.println("Total Votes \t" +Tvotes2);		
	       	
	       	percentage=(Vote/Tvotes2)*100;						//To Calculate the Percentage of Votes.
	       	System.out.println("Percentage \t" +percentage);
	       	
	       	double deg1=(percentage/100)*360;					//To Calculate the Degrees from Percentage of Votes.
	        int degree1=(int) deg1;
	       	System.out.println("DEGREE \t\t"+degree1);
	       	
	       	
	       	n=n+1;
	       	if(n==1)
	       		g.setColor(Color.BLACK);
	       	if(n==2)
	       		g.setColor(Color.ORANGE);
	       	if(n==3)
	       		g.setColor(Color.BLUE);
	       	if(n==4)
	       		g.setColor(Color.DARK_GRAY);
	       	if(n==5)
	       		g.setColor(Color.RED);
	       	if(n==6)
	       		g.setColor(Color.PINK);
	       		if(n==7)
	       		g.setColor(Color.GREEN);
	       	
	       	   if(n>8)
	       	  {
	          	Color color4=new Color(color1,color2,color3);
	 		    g.setColor(color4);
			   }
	 		   g.drawString(partyName1,X_axixs,500);				//For Printing the Party Names of Respective Pie-Diagram. 
	 	       X_axixs=X_axixs+80;
		    
		      g.fillArc(300,200,201,201,Iangle,degree1);			//For Drawing the Pie Diagram of Respective Political Parties.
		      Iangle=Iangle+degree1;
	            
	        color1=color1+25;									//For Filling the Pie-Diagram with Different Colors Shades.
	        color2=color2+25;
	        color3=color3+25;
	        
	         System.out.println("\n\n");
	      }
	     
	       String label="PIE-CHART";
	       Font font=new Font("ArialBlack",Font.ITALIC,20);
	       g.drawRect(30,50,720,460);
 		   g.setColor(Color.black);
	 	   g.setFont(font);
	 	   g.drawString(label,360,150);
	 }
	 
	
	}
	
