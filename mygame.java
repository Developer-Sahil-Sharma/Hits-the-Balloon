import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
public class mygame extends Applet implements KeyListener,Runnable,ActionListener,FocusListener {
	Thread t;
	Font fo;
	AudioClip u,v;
	int score,tempx,count,level;
	int i,a,b,xa,xb,xc,xd,xe,xf,ya,yb,yc,yd,ye,yf,w;
   Image e,f,gi,h,j,k;
   int c[]= {100,120,100};
   int d[]= {180,200,220};
 
   
   
	public void init()
	{
		level=0;
		 count=10;
	    score=0;
	    w=50;
		i=0;
		fo=new Font("Arial",Font.BOLD, 25);
		setFont(fo);
		setBackground(Color.blue);
		a=0;b=200;
		xa=500;xb=700;xc=900;xd=500;xe=700;xf=900;
		ya=800;yb=800;yc=800;yd=800;ye=800;yf=800;
		
			e=getImage(getCodeBase(),"S40.png");
			f=getImage(getCodeBase(),"S40 (1).png");
			gi=getImage(getCodeBase(),"H50.png");
			h=getImage(getCodeBase(),"ex.jpg");
			j=getImage(getCodeBase(),"ex1.jpg");
			k=getImage(getCodeBase(),"ex1.jpg");
			u=getAudioClip(getCodeBase(),"BO.wav");
			v=getAudioClip(getCodeBase(),"OM.wav");
		addKeyListener(this);
		addFocusListener(this);
		 t=new Thread(this);
	}
	public void paint(Graphics g)
	{
	                                            	// for arrow
		 g.setColor(Color.black);
		  g.fillRect(a, b, 100,5);
		  g.setColor(Color.red);
		  g.fillPolygon(c,d,3);
		                                           //for baloon
		  g.drawImage(e,xa,ya,100,100,this);
		  g.drawImage(f,xb,yb,100,100,this);
		  g.drawImage(gi,xc,yc,100,100,this);
		                                           // for blast effect
		  g.drawImage(h,xd,yd,100,100,this);
		  g.drawImage(j,xe,ye,100,100,this);
		  g.drawImage(k,xf,yf,100,100,this);
		                                           // for show Score
		  g.setColor(Color.black);
		  g.drawString("SCORE : "+score, 1100, 100);
		  g.drawString("CHANCE : "+count, 1100, 150);
		  repaint();
	
		 
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
                                                    //for Control the Arrow
		if (e.getKeyCode()==e.VK_UP)
		{
			if(b>=40)
			{
				b=b-20;
				for(i=0;i<3;i++)
        		{
        			d[i]=d[i]-20;
        		}
			}
			else
			{
				b=b;
				for(i=0;i<3;i++)
	    		{
	    			d[i]=d[i];
	    		}	
			}
				

		}
		if (e.getKeyCode()==e.VK_DOWN)
		{
			if(b<=660)
			{
				b=b+20;
				for(i=0;i<3;i++)
        		{
        			d[i]=d[i]+20;
        		}
			}
			else
			{
				b=b;
				for(i=0;i<3;i++)
        		{
        			d[i]=d[i];
        		}
			}
				
		}
		                                 // Press 'w' than move the Arrow
			if(e.getKeyChar()=='w'||e.getKeyChar()=='W')
	         {
							 t.start();
			 }	
			                            // Press 'q' than Close the Game 
			if(e.getKeyChar()=='q'||e.getKeyChar()=='Q')
	         {
							System.exit(0);
			 }	
			
	
		
			
         }
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		
		try
		{
			Thread.sleep(w);
			while(true)
			{
				                  // for move the Arrow
				//Thread.sleep(10);
        		a=a+20;
        		for(i=0;i<3;i++)
        		{
        			c[i]=c[i]+20;
        		}
        		i++;
        	
        			if (a>=1200)
	        		{
	        			a=0;
	        			c[0]=100;
	        			c[1]=120;
	        			c[2]=100;
	        			
	        		//	t.stop();
	    
	        		}
        			Thread.sleep(w);
	           		
	        	    	e=getImage(getCodeBase(),"S40.png");
	        	    	f=getImage(getCodeBase(),"S40 (1).png");
	        	    	gi=getImage(getCodeBase(),"H50.png");
	        	    	h=getImage(getCodeBase(),"ex.jpg");
	        			j=getImage(getCodeBase(),"ex1.jpg");
	        			k=getImage(getCodeBase(),"ex1.jpg");
	        			u=getAudioClip(getCodeBase(),"BO.wav");
	        			v=getAudioClip(getCodeBase(),"OM.wav");
	        	    	                     
	        			// for move all Balloon down to up
	        	    	 ya=ya-10;
	        	    	 if(ya<=600)
	        	    	 {
	        	    		 yc=yc-10;
	        	   
	        	    	 }
	        	    	if(yc<=500)
	        	    	{
	        	    		 yb=yb-10;
	        	    	}
	        	    	
	        	    	i++;
	        	    	if((c[1]>=xa&&c[1]<=xa+100)&&(d[1]>=ya&&d[1]<=ya+100))
	        	    	{
	        	    		 u.play(); 
	        	    		score=score+5;    // Score Update
	        	    		yd=ya;    // for Show blast effect
	        	    		
	        	    		ya=800;
	        	    		
	        	    	}
	        	    	if((c[1]>=xb&&c[1]<=xb+100)&&(d[1]>=yb&&d[1]<=yb+100))
	        	    	{
	        	    		 v.play(); 
	        	    		score=score+5;
	        	    		ye=yb;
	        	    		yb=800;
	        	    		
	        	    	}
	        	    	if((c[1]>=xc&&c[1]<=xc+100)&&(d[1]>=yc&&d[1]<=yc+100))
	        	    	{
	        	    		 v.play(); 
	        	    		score=score+5;
	        	    		yf=yc;
	        	    		yc=800;
	        	    		
	        	    	}
	        	    	
	        	    	if(ya<=0)
        	    		{
        	    			count--;
        	    			ya=800;
        	    		}
	        	    	if(yb<=0)
	        	    	{
	        	    		count--;
	        	    		yb=800;
	        	    	}
	        	    	if(yc<=0)
	        	    	{
	        	    		count--;
	        	    		yc=800;
	        	    	}

	        			 if(count<=0)
	        	    	 {
	        	    		 JOptionPane.showMessageDialog(this, "GAME OVER \n"+"SCOCE : "+score);
	        	    		 requestFocus();
	        	    		 t.stop();
	 
	        	    	 }
	        			 if(score>=100)
	        			 {
	        				 w=40;
	        			 }
	        			 if(score>=200)
	        			 {
	        				 w=30;
	        			 }
	        			 if(score>=300)
	        			 {
	        				 w=20;
	        			 }
	        			 if(score>=400)
	        			 {
	        				 w=10;
	        			 }
	        			 if(score>=500)
	        			 {
	        				 w=5;
	        			 }
	        			 if(ya==700)
	        	    		{
	        	    			yd=800;
	        	    		}
	        			 if(yb==700)
	        	    		{
	        	    			ye=800;
	        	    		}
	        			 if(yc==700)
	        	    		{
	        	    			yf=800;
	        	    		}
	        		repaint();
	        			 
			}
		}
		catch(Exception ex) {}
		
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(a>50)
        {
       	 t.start();
 		
        }
	}
	@Override
	public void focusGained(FocusEvent e) {
		
	}
	@Override
	public void focusLost(FocusEvent e) {

	}
}
