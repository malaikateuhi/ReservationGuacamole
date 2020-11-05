package Interface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
	ImageIcon im;  
    public BackgroundPanel(ImageIcon im){  
        this.im=im;  
        this.setOpaque(true);                 
    }  

    public void paintComponent(Graphics g){  
        super.paintComponents(g);  
        g.drawImage(im.getImage(),0,0,this.getWidth(),this.getHeight(),im.getImageObserver());  
    }  
    
    
}

