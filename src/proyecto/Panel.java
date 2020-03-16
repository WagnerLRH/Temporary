package proyecto;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

public class Panel extends JPanel{

  private int widthlog;
  private int heightlog;
  private int widthlogin;
  private int heightlogin;

  public Panel(){
	widthlogin=(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
	heightlogin=(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
    widthlog=(widthlogin/2)/2;
    heightlog=(int) (((widthlogin/2)/3.5)-25);
  }

  public int getWidthLog(){
    return widthlog;
  }

  public int getHeightLog(){
    return heightlog;
  }

  public int getWidthLogin(){
    return widthlogin;
  }

  public int getHeightLogin(){
    return heightlogin;
  }
  
  /*public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  System.out.println("super.paintComponent");
  }*/

}
