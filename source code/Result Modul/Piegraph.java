
/***************************************************************************************
*	Class: PieGraph , ResultGUI
*	Project: On Line Voting System
*   Language: JAVA.
*	Year: 2007-2008
*
*	Use this project module for Used in the show the result in any OnLine voting system purposes.
*	The Result Can be show according its value ie hear result will show accourding to voting.
*	Feel free to distribute and re-distribute this project.
*	Feel free to add new features.
*	Suggestions are welcomed.
*
*	Redistribution and use in source and binary forms, with or
*	without modification, are permitted provided that the following
*	conditions are met:
*
*   Feature: 
*	-the Code is Reusuable.
*
*	You acknowledge that Software is not designed
*	intended for use in the design, construction, operation or
*	maintenance of any nuclear facility.
*   
******************************************************************************************/




import java.awt.*;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import javax.swing.JPanel;

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
	 private Map<String,Integer> pieData;
	
	 PiegraphBuild() 
	 {
	   pieData = new TreeMap<String,Integer>();
	   initializeData();
	   setBackground(Color.white);
     
     }           

 //*************** To Initialize the Object *************************************//
	    protected void initializeData() {
		pieData.put("BJP",1170);
		pieData.put("Congress",170);
		pieData.put("Shivsena", 170);
		pieData.put("BSP",170);
		pieData.put("Others", 170);
	    
			
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
/****************To Get the Total Number Of Votes ****************************************/   
	  	 
	    	while(keyIterator.hasNext()) 					
	    	{    
	        	String partyName = keyIterator.next();
	       		pieData.get(partyName);
	       		Vote1 = pieData.get(partyName);
	       		
/***********************************Formula For Total Number of Votes*********************/
	       		 
	       		Tvotes=Tvotes+Vote1;							
	      	}	
	     		     
	     
	     Set<String> keySet1 = pieData.keySet();
	     Iterator<String> keyIterator1 = keySet1.iterator();
	     
/********************To Calculate the Degrees & Draw the Pie Diagram.************************/
	      
	      while(keyIterator1.hasNext()) 							
	     {    
	     	double Tvotes2=(double)Tvotes;
    	   	String partyName1 = keyIterator1.next();
    	   	
/********************For Accessing the Partyname from Mapped Set***************************/
    	   		 
	       	pieData.get(partyName1);						
	       	System.out.println(partyName1);
	       	
/**********************For Accessing the Votes of Parties from Mapped Set******************/
	       	 
	       	 Vote = pieData.get(partyName1);						
	       	System.out.println("Vote \t" +Vote);
	       	System.out.println("Total Votes \t" +Tvotes2);		
	       	
/********************To Calculate the Percentage of Votes***********************************/
	       	 
	       	percentage=(Vote/Tvotes2)*100;						
	       	System.out.println("Percentage \t" +percentage);
	       	
/*****************To Calculate the Degrees from Percentage of Votes.***********************/
	       	 
	       	double deg1=(percentage/100)*360;					
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
			  
/**************For Printing the Party Names of Respective Pie-Diagram.***********************/ 
			    
	 		   g.drawString(partyName1,X_axixs,500);				
	 	       X_axixs=X_axixs+80;
		    
/*****************For Drawing the Pie Diagram of Respective Political Parties.**************/
		     
		      g.fillArc(300,200,201,201,Iangle,degree1);			
		      Iangle=Iangle+degree1;
	       
/***********For Filling the Pie-Diagram with Different Colors Shades.*********************/
	         
	        color1=color1+25;								
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
	
